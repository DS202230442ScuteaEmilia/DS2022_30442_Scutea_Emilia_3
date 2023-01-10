import { createInjectableType } from '@angular/compiler';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { User } from 'src/app/common/user/user';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { UserService } from 'src/app/services/user/user.service';



@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css']
})
export class CreateUserComponent implements OnInit {

  createUserForm !: FormGroup;
  newUser: User = {
    id: 0,
    username: '',
    email: '',
    password: '',
    age: 0
  };

  constructor(@Inject(MAT_DIALOG_DATA) public data: User,
              private matDialogRef: MatDialogRef<CreateUserComponent>,
              private formBuilder: FormBuilder,
              private userService: UserService) { }

  ngOnInit(): void {
    this.createUserForm = this.formBuilder.group({
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


  createUserMethod() {
    this.fillNewUserValues();
    this.userService.createUserMethod(this.newUser);
    this.matDialogRef.close();
    window.location.reload();
  }

  fillNewUserValues() {
    this.newUser.username = this.createUserForm.value.username;
    this.newUser.email = this.createUserForm.value.email;
    this.newUser.password = this.createUserForm.value.password;
    this.newUser.age = this.createUserForm.value.age;  
  }

}

