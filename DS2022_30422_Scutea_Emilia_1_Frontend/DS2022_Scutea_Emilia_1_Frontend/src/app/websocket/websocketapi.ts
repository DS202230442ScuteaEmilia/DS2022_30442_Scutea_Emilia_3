import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { WebSocketShareService } from './websocketshareservice';
import { Injectable } from '@angular/core';
import { AlertService } from '../_alert';
import { TokenStorageService } from "../services/auth/token-storage.service";
import { DeviceService } from '../services/device/device.service';
import { DeviceListComponent } from '../components/device-list/device-list.component';

@Injectable()
export class WebSocketAPI {
    webSocketEndPoint: string = 'http://localhost:8088/api/websocket';
    topic: string = "/topic";
    stompClient: any;

    constructor(private websocketShare: WebSocketShareService,
                public alertService: AlertService,
                public tokenStorageService: TokenStorageService,
                public deviceService: DeviceService,
                public deviceListComponent: DeviceListComponent){
    }

    connect() {
        console.log("Initialize WebSocket Connection");
        let ws = new SockJS(this.webSocketEndPoint);
        this.stompClient = Stomp.over(ws);
        const _this = this;
        _this.stompClient.connect({}, function () {
            _this.stompClient.subscribe(_this.topic, function (sdkEvent: { body: string; }) {
                _this.onMessageReceived(sdkEvent);
            });
            //_this.stompClient.reconnect_delay = 2000;
        }, this.errorCallBack);
    };

    disconnect() {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
        this.connect();
    }

    // on error, schedule a reconnection attempt
    errorCallBack(error: string) {
        console.log("errorCallBack -> " + error)
        setTimeout(() => {
            this.connect();
        }, 10);
    }

    onMessageReceived(message: { body: string; }) {
        let splited = message.body.split(":");
        console.log(splited);
        console.log(splited[0]);
        let receivedId = splited[0];
        let loggedIn = this.tokenStorageService.getUser().id;
        console.log("received Id " + receivedId);
        console.log("logged in " + loggedIn);

        console.log("equals ", receivedId===loggedIn);
        console.log("equals ", receivedId==loggedIn);

        if(receivedId == loggedIn){
            console.log("entered if");
            this.websocketShare.onNewValueReceive(splited[1]);
            this.sendAlert(splited[1]);
        }
    }

    sendAlert(message: string){
        this.alertService.warn("     Warning: " + message, false);
    }
}
