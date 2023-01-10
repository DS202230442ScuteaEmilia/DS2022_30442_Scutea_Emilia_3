import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { Device } from "src/app/common/device/device";
import { TokenStorageService } from "../auth/token-storage.service";
import { Consumption } from "src/app/common/consumption/consumption";

@Injectable({
    providedIn: 'root'
})
export class DeviceService {

  constructor(private httpClient: HttpClient,
              private tokenStorageService: TokenStorageService) { }


  public devices!: string | any[];


  getDeviceList(): Device[] {
    const devices: Device[] = [];
    this.httpClient.get<any>("http://localhost:8088/api/admin" + "/devices", this.tokenStorageService.authHeader())
    .subscribe(
      data => {
        data.body.forEach((device: Device)  =>{
          if(device.user_id === null){
            device.user_id = 0;
          }
          devices.push(device);})
        });
      this.devices = devices;
      return devices;
  }
    
  
  getAllDevicesForUser(): Device[]{
    const devices: Device[] = [];
    const user_id = JSON.parse(window.sessionStorage.getItem('auth-user')!).id;


    this.httpClient.get<any>("http://localhost:8088/api/user" + "/user-devices/" + user_id,this.tokenStorageService.authHeader()).subscribe(
      data => {
        data.body.forEach((device: Device)  =>{
          if(device.user_id === null){
            device.user_id = 0;
          }
          devices.push(device);})
        });
    
        return devices;
    }
    
  getAllConsumptionsForUser(): Consumption[] {
    const user_id = JSON.parse(window.sessionStorage.getItem('auth-user')!).id;
    const consumptions: Consumption[] = [];
    this.httpClient.get<any>("http://localhost:8088/api/user" + "/user-consumptions/" + user_id, this.tokenStorageService.authHeader()).subscribe(
      data => {
        data.body.forEach((cons: Consumption)  =>{
          consumptions.push(cons);})
        }
    );
    return consumptions;

  }
    
  createDeviceMethod(data: Device){
   
    return this.httpClient.post<any>("http://localhost:8088/api/admin" + "/create-device",  data, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  editDeviceMethod(data: Device){   
    return this.httpClient.post<any>("http://localhost:8088/api/admin" + "/edit-device",  data, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  deleteDeviceMethod(id: number) {
    return this.httpClient.delete<any>("http://localhost:8088/api/admin" + "/delete-device/" + id, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }

  addEnergy(id: number, energy: number){
    return this.httpClient.post<any>("http://localhost:8088/api/user" + "/add-energy-consumption/" + id + "/" + energy,  null, this.tokenStorageService.authHeader())
    .subscribe(
      data => {});
  }


}