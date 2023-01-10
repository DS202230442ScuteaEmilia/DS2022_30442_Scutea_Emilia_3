import { Component, OnInit } from '@angular/core';
import { Device } from 'src/app/common/device/device';
import { DeviceService } from 'src/app/services/device/device.service';
import { UserService } from 'src/app/services/user/user.service';
import { MatDialog } from '@angular/material/dialog';
import { CreateDeviceComponent } from '../create-device/create-device.component';
import { EditDeviceComponent } from '../edit-device/edit-device.component';
import { User } from 'src/app/common/user/user';
import { MatOption } from '@angular/material/core';


@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.css']
})
export class DeviceListComponent implements OnInit {

  devices: Device[] = [];

  users: User[] = [];

  selectedUser!: User;
  selectedDevice !: Device;

  constructor(private deviceService: DeviceService,
              private matDialog: MatDialog, 
              private userService: UserService) { }

  ngOnInit(): void {
    this.listDevices();
    this.listUsers();

  }

  listDevices() {
    this.devices = this.deviceService.getDeviceList();
  }

  listUsers() {
    this.users = this.userService.getUserList();
  }

  createDeviceDialog() {
    let dialogRef = this.matDialog.open(CreateDeviceComponent, {
      width: "500px",
      height: "300px"
    });
  }

  editDeviceDialog(device: Device) {
    let dialogRef = this.matDialog.open(EditDeviceComponent, {
      data: device,
      width: "500px",
      height: "300px"
    });
   
  }

  deleteDevice(device: Device) {
    this.deviceService.deleteDeviceMethod(device.id);
    window.location.reload();
  }

  assignDeviceToUser(){
    this.userService.assignDeviceToUser(this.selectedUser, this.selectedDevice);
    window.location.reload();
  }
}
