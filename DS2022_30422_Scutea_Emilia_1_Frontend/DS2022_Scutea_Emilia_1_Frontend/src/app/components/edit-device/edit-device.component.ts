import { createInjectableType } from '@angular/compiler';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Device } from 'src/app/common/device/device';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { DeviceService } from 'src/app/services/device/device.service';
@Component({
  selector: 'app-edit-device',
  templateUrl: './edit-device.component.html',
  styleUrls: ['./edit-device.component.css']
})
export class EditDeviceComponent implements OnInit {

  editDeviceForm !: FormGroup;

  editDevice: Device = {
    id: 0,
    address: '',
    description: '',
    user_id: 0,
    maxHourlyEnergyCons: 0,
  };

  constructor(@Inject(MAT_DIALOG_DATA) public data: Device,
              private matDialogRef: MatDialogRef<EditDeviceComponent>,
              private formBuilder: FormBuilder,
              private deviceService: DeviceService) { }

  ngOnInit(): void {
    this.editDeviceForm = this.formBuilder.group({
      id: ['', Validators.required],
      address: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  ngOnDestroy() {
    this.matDialogRef.close(this.data);
  }

  onCloseClick() {
    this.matDialogRef.close();
  }

  editDeviceMethod() {
    this.fillNewDeviceValues();
    this.deviceService.editDeviceMethod(this.editDevice);
    this.matDialogRef.close();
    window.location.reload();
  }

  fillNewDeviceValues() {
    this.editDevice.id = this.editDeviceForm.value.id;
    this.editDevice.address = this.editDeviceForm.value.address;
    this.editDevice.description = this.editDeviceForm.value.description;
  }


}
