import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from 'src/app/common/user/user';
import { BehaviorSubject } from 'rxjs';
import { Device } from 'src/app/common/device/device';
import { TokenStorageService } from "../auth/token-storage.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient,
              private tokenStorageService: TokenStorageService) { }

  getUserList(): User[] {
    const users: User[] = [];
    this.httpClient.get<any>("http://localhost:8088/api/admin" + "/users", this.tokenStorageService.authHeader())
    .subscribe(
      data => {
        data.body.forEach((user: User)  =>{
          users.push(user);})
        });
    
      return users;
  }

  getAdministrator(): User[] {
    const users: User[] = [];
    this.httpClient.get<any>("http://localhost:8088/api/admin/get_admin", this.tokenStorageService.authHeader())
    .subscribe(
      data => {
        // data.body.forEach((user: User)  =>{
          users.push(data.body);})
        // });  
        console.log(users)
    return users;
  }

  createUserMethod(data: User){
   
    return this.httpClient.post<any>("http://localhost:8088/api/admin" + "/create-user",  data, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  editUserMethod(data: User){  
    console.log(this.tokenStorageService.authHeader());
 
    return this.httpClient.post<any>("http://localhost:8088/api/admin" + "/edit-user",  data, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  deleteUserMethod(id: number) {
    return this.httpClient.delete<any>("http://localhost:8088/api/admin" + "/delete-user/" + id, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  assignDeviceToUser(selectedUser: User, selectedDevice: Device){
    return this.httpClient.post<any>("http://localhost:8088/api/admin" + "/assign-device/" + selectedUser + "/" + selectedDevice, null, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});    
  }
}

interface GetResponse {
  _embedded: {
    users: User[];
  }
}
