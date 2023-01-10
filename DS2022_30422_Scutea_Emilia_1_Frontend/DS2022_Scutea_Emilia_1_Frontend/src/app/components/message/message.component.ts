import { Component, Input, OnInit } from '@angular/core';
import { Message } from 'src/app/common/message/message';
import { User } from 'src/app/common/user/user';
import { Greeting } from 'src/app/output/greet_pb';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit {

  @Input()
  message!: Message;
  @Input()
  currentUser!: User;
  @Input()
  otherUser!: User;
  constructor() { }

  ngOnInit(): void {
  }

}
