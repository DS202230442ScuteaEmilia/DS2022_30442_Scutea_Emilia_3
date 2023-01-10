import { createInjectableType } from '@angular/compiler';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { User } from 'src/app/common/user/user';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  editUserForm !: FormGroup;

  editUser: User = {
    id: 0,
    username: '',
    email: '',
    password: '',
    age: 0
  };

  constructor(@Inject(MAT_DIALOG_DATA) public data: User,
              private matDialogRef: MatDialogRef<EditUserComponent>,
              private formBuilder: FormBuilder,
              private userService: UserService) { }

  ngOnInit(): void {
    this.editUserForm = this.formBuilder.group({
      id: ['', Validators.required],
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      age: ['', Validators.required]
    });
  }

  ngOnDestroy() {
    this.matDialogRef.close(this.data);
  }

  onCloseClick() {
    this.matDialogRef.close();
  }

  hide = true;

  email = new FormControl('', [Validators.required, Validators.email]);

  editUserMethod() {
    this.fillNewUserValues();
    this.userService.editUserMethod(this.editUser);
    this.matDialogRef.close();
    window.location.reload();
  }

  fillNewUserValues() {
    this.editUser.id = this.editUserForm.value.id;
    this.editUser.username = this.editUserForm.value.username;
    this.editUser.email = this.editUserForm.value.email;
    this.editUser.password = this.editUserForm.value.password;
    this.editUser.age = this.editUserForm.value.age;  
  }

}
