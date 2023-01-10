import { HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut(): void {
    window.sessionStorage.clear();
  }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }

  public saveUser(user: any): void {
    console.log(user);
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  public getUser(): any {
    const user = window.sessionStorage.getItem(USER_KEY);
    if (user) {
      return JSON.parse(user);
    }
    return {};

  }

  public authHeader() {
    const userData: {
      token:string,
      id:number,
      username: string,
      email:string
    } = JSON.parse(window.sessionStorage.getItem('auth-user')!);
    
    return {
      headers: new HttpHeaders({
        // "Content-type": "application:json",
        "Authorization": "Bearer " + userData.token
      }),
      observe: "response" as "body"
    }; 
  }
}
