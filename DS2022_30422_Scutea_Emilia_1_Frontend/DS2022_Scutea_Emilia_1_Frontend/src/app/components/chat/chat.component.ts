import { Component, OnInit } from '@angular/core';
import { Message } from 'src/app/common/message/message';
import { User } from 'src/app/common/user/user';
import { GreetServiceClient } from 'src/app/output/GreetServiceClientPb';
import { Empty, Greeting, GreetRequest } from 'src/app/output/greet_pb';
import { MessageService } from 'src/app/services/message/message.service';
import { UserService } from 'src/app/services/user/user.service';
import { DoCheck } from '@angular/core';
import { TokenStorageService } from 'src/app/services/auth/token-storage.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {
  messages!: any[];
  currentUser!: any;
  otherUser!: any;
  selectedUser !: any;
  users: User[] = [];
  isAdmin = true;
  otherUser_name!: any;

  constructor(public userService: UserService, public messageService: MessageService) { }
  ngOnInit() {
    this.users = this.userService.getUserList();
    this.currentUser = JSON.parse(window.sessionStorage.getItem('auth-user')!);
    this.isAdmin = this.currentUser.role === 'ADMIN';
    if(this.isAdmin === false){
      this.otherUser = 3;
      this.otherUser_name = "Administrator";
    }
    
    setInterval(() => {
      this.update();
    }, 10);
  }

  update() {
    this.messages = this.messageService.getMessagesList(this.currentUser.id, this.otherUser);
  }

  handleSubmit(event: any) {
    event.preventDefault();
    const message = event.target[0].value;
    event.target[0].value = '';

    let greeting = new Greeting();
    greeting.setFrom(this.currentUser.id.toString())
    greeting.setTo(this.otherUser.toString())
    greeting.setMessage(message)
    const request = new GreetRequest();
    request.setGreeting(greeting);
     const client = new GreetServiceClient('http://localhost:8080')
                    .greet(request, {}, (err, response) => {
                console.log({err, response});
            });
    this.update();
  }

  startChat() {
    if(this.selectedUser == null) {
      alert("You did not select any user");
    }
    else{
      this.otherUser = this.selectedUser;
      for(let index = 0; index < this.users.length; index++) {
        if(this.users[index].id == this.selectedUser){
          this.otherUser_name = this.users[index].username;
        }
      }
      this.update();
    }
  }

}
