import { createInjectableType } from '@angular/compiler';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Device } from 'src/app/common/device/device';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { DeviceService } from 'src/app/services/device/device.service';
@Component({
  selector: 'app-create-device',
  templateUrl: './create-device.component.html',
  styleUrls: ['./create-device.component.css']
})
export class CreateDeviceComponent implements OnInit {

  createDeviceForm !: FormGroup;

  newDevice: Device ={
    id: 0,
    address: '',
    description: '',
    user_id: 0,
    maxHourlyEnergyCons: 0
  };

  constructor(@Inject(MAT_DIALOG_DATA) public data: Device,
              private matDialogRef: MatDialogRef<CreateDeviceComponent>,
              private formBuilder: FormBuilder,
              private deviceService: DeviceService) { }

  ngOnInit(): void {
    this.createDeviceForm = this.formBuilder.group({
      address: ['', Validators.required],
      description: ['', Validators.required],
      maxHourlyEnergyCons: ['', Validators.required]
    });
  }

  ngOnDestroy() {
    this.matDialogRef.close(this.data);
  }

  onCloseClick() {
    this.matDialogRef.close();
  }

  createDeviceMethod() {
    this.fillNewDeviceValues();
    this.deviceService.createDeviceMethod(this.newDevice);
    this.matDialogRef.close();
    window.location.reload();
  }

  fillNewDeviceValues() {
    this.newDevice.address = this.createDeviceForm.value.address;
    this.newDevice.description = this.createDeviceForm.value.description;
    this.newDevice.maxHourlyEnergyCons = this.createDeviceForm.value.maxHourlyEnergyCons;
  }
}
