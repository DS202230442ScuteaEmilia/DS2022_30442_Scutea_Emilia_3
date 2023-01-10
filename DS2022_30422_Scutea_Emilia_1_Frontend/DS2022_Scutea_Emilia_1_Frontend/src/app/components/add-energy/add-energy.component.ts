import { createInjectableType } from '@angular/compiler';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Device } from 'src/app/common/device/device';
import {FormControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { DeviceService } from 'src/app/services/device/device.service';
import { Energy } from 'src/app/common/energy/energy';

@Component({
  selector: 'app-add-energy',
  templateUrl: './add-energy.component.html',
  styleUrls: ['./add-energy.component.css']
})
export class AddEnergyComponent implements OnInit {

  addEnergyForm !: FormGroup;

  addEnergy: Energy = {
    id: 0,
    energy: 0
  }
  

  constructor(@Inject(MAT_DIALOG_DATA) public data: Energy,
              private matDialogRef: MatDialogRef<AddEnergyComponent>,
              private formBuilder: FormBuilder,
              private deviceService: DeviceService) { }

  ngOnInit(): void {
    this.addEnergyForm = this.formBuilder.group({
      id: ['', Validators.required],
      energy: ['', Validators.required],
    });
  }

  ngOnDestroy() {
    this.matDialogRef.close(this.addEnergy);
  }

  onCloseClick() {
    this.matDialogRef.close();
  }

  addEnergyMethod() {
    this.fillNewDeviceValues();
    this.deviceService.addEnergy(this.addEnergy.id, this.addEnergy.energy);
    this.matDialogRef.close();
  }

  fillNewDeviceValues() {
    this.addEnergy.id = this.addEnergyForm.value.id;
    this.addEnergy.energy = this.addEnergyForm.value.energy;
  }

}
