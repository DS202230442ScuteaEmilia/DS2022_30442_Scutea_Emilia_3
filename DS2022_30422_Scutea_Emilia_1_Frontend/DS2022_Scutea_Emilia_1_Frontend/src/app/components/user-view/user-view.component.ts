import { Component, OnInit } from '@angular/core';
import { Device } from 'src/app/common/device/device';
import { DeviceService } from 'src/app/services/device/device.service';
import { MatDialog } from '@angular/material/dialog';
import { AddEnergyComponent } from '../add-energy/add-energy.component';
import { Energy } from 'src/app/common/energy/energy';
import { Consumption } from 'src/app/common/consumption/consumption';
import { MatDatepickerModule } from '@angular/material/datepicker';
import Chart from 'chart.js/auto';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { TokenStorageService } from 'src/app/services/auth/token-storage.service';
import { indexOfAny } from 'igniteui-angular-core';
import { ChartValue } from 'src/app/common/chart-value';
import { ValuesHolder } from 'igniteui-angular-charts';
import { WebSocketShareService } from 'src/app/websocket/websocketshareservice';
import { WebSocketAPI } from 'src/app/websocket/websocketapi';
import { Greeting, GreetRequest } from 'src/app/output/greet_pb';
import { GreetServiceClient } from 'src/app/output/GreetServiceClientPb';


@Component({
  selector: 'app-user-view',
  templateUrl: './user-view.component.html',
  styleUrls: ['./user-view.component.css']
})
export class UserViewComponent implements OnInit {

  devices: Device[] = [];

  consumptions : Consumption[] = [];

  filteredConsumptions: number[] = [];

  public myChart: any;

  selectedDevice !: Device;

  consum !: string[];
  
  public Total=150;
  public MaxHeight= 160;
  values: Array<ChartValue> = [];

  wsData: string = 'Hello'; // default data, will be updated when the new data is pushed from spring boot backend

  constructor(
    private deviceService: DeviceService,
              private matDialog: MatDialog,
              private matDatePicker: MatDatepickerModule,
              private httpClient: HttpClient,
              private tokenStorageService: TokenStorageService,
              private websocketService: WebSocketShareService, 
              private webSocketAPI: WebSocketAPI
              ) { }

  ngOnInit(): void {
    this.listDevices();
    this.listConsumptions();
    this.filteredConsumptions = [];
    this.webSocketAPI.connect();          
    this.onNewValueReceive();
  }

  listDevices(){
    this.devices = this.deviceService.getAllDevicesForUser();
  }

  addEnergyDialog(device: Device) {
    const energyCons : Energy = {
      id: device.id,
      energy: 0
    };
    let dialogRef = this.matDialog.open(AddEnergyComponent, {
      data: energyCons,
      width: "500px",
      height: "300px"
    });
  }

  listConsumptions() {
    this.consumptions = this.deviceService.getAllConsumptionsForUser();
  }

  date!: Date;

  async getConsumptionsByDate(date: String, selectedDevice: Device) {
    const asyncResult = await this.httpClient.post<any>("http://localhost:8088/api/user" + "/consumptions-date/" + selectedDevice, date, this.tokenStorageService.authHeader())
    .toPromise();
    this.filteredConsumptions = asyncResult.body;
  }

  searchConsumptionByDate() {
   this.getConsumptionsByDate(this.date.toString(), this.selectedDevice);  
   this.displayChart();
   };

  displayChart(){
    this.values = [];

    for(let i = 0; i < this.filteredConsumptions.length; i++){
      this.values.push(new ChartValue(parseFloat(this.filteredConsumptions[i].toFixed(1)), Math.round((this.filteredConsumptions[i]*this.MaxHeight)/this.Total) + '%', i.toString()));
    }
  }

  connect() {
    this.webSocketAPI.connect();
  }
  disconnect() {
    this.webSocketAPI.disconnect();
  }
  // method to receive the updated data.
  onNewValueReceive() {
    this.websocketService.getNewValue().subscribe(resp => {
      this.wsData = resp;
    });
  }

  getMessages() {
    // create our greeting object
    // let greeting = new Greeting();
    // greeting.setFirstName('Slimen')
    // greeting.setLastName('Arnaout')

    //  // prepare the greet request
    //  const request = new GreetRequest();
    //  request.setGreeting(greeting);

    //  // create gRPC client that will call our java server
    //  const client = new GreetServiceClient('http://localhost:8080')
    //                 .greet(request, {}, (err, response) => {
    //             console.log({err, response});
    //         });
  }

  // openCjat() {
  //   let dialogRef = this.matDialog.open(ChatComponent, {
  //     // data: user,
  //     width: "500px",
  //     height: "300px"
  //   });
  // }


}
