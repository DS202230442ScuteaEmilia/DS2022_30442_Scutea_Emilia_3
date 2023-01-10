import { Injectable } from '@angular/core';
import { Message } from 'src/app/common/message/message';
import { GreetServiceClient } from 'src/app/output/GreetServiceClientPb';
import { Empty } from 'src/app/output/greet_pb';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

messages: Message[]=[];
  constructor() { }

  getMessagesList(from: number, to: number): Message[] {
    const empty = new Empty();
    
    const mess = new GreetServiceClient('http://localhost:8080')
                    .getMessages(empty, {}, (err, response) => {
                    this.messages = this.process(response, from, to);
            });
    return this.messages;
  }

  process(response: any, from: number, to: number) {
    const list = response.getMessagesList();
    const messageList : Message[] = [];
    for(let index = 0; index< list.length; index++){
     
      if((from == list[index].getFrom() && to == list[index].getTo()) || (to == list[index].getFrom() && from == list[index].getTo())){
        const message = new Message(list[index].getFrom(), list[index].getTo(), list[index].getMessage());
        messageList.push(message);
      }
    }
    return messageList;
  }
}
