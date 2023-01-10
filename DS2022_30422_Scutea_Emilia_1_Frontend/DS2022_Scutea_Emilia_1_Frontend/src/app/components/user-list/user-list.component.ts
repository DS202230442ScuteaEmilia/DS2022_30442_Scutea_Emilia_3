import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/common/user/user';
import { UserService } from 'src/app/services/user/user.service';
import { MatDialog } from '@angular/material/dialog';
import { CreateUserComponent } from '../create-user/create-user.component';
import { HttpClient } from '@angular/common/http';
import { EditUserComponent } from '../edit-user/edit-user.component';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[] = [];

  
  constructor(private userService: UserService,
              private matDialog: MatDialog
              ) { }

  ngOnInit(): void {
    this.listUsers();
  }
  listUsers() {
    this.users = this.userService.getUserList();
  }

  createUserDialog() {
    let dialogRef = this.matDialog.open(CreateUserComponent, {
      width: "500px",
      height: "300px"
    });
  }

  editUserDialog(user: User) {
    let dialogRef = this.matDialog.open(EditUserComponent, {
      data: user,
      width: "500px",
      height: "300px"
    });
  }

  deleteUser(user: User){
    this.userService.deleteUserMethod(user.id);
    window.location.reload();
  }
}
