import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './services/auth/token-storage.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  private role!: string;
  isLoggedIn = false;
  showAdminPage = false;
  showUserPage = false;
  username!: string;

  constructor(private tokenStorageService: TokenStorageService) {}
  
  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.role = user.role;

      this.showAdminPage = this.role === 'ADMIN';
      this.showUserPage = this.role ==='USER';

      this.username = user.username;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}

