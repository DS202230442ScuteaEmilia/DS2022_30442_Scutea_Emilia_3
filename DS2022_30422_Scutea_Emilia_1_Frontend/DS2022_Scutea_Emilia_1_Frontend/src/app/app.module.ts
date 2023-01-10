import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserService } from './services/user/user.service';
import { DeviceListComponent } from './components/device-list/device-list.component';
// import { Routes, RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { CreateUserComponent } from './components/create-user/create-user.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditUserComponent } from './components/edit-user/edit-user.component';
import { CreateDeviceComponent } from './components/create-device/create-device.component';
import { EditDeviceComponent } from './components/edit-device/edit-device.component';
import { UserViewComponent } from './components/user-view/user-view.component';
import { LoginComponent } from './components/login/login/login.component';

import { AppRoutingModule } from './app-routing.module';
import { AdminViewComponent } from './components/admin-view/admin-view.component';
import { AddEnergyComponent } from './components/add-energy/add-energy.component';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { WebSocketAPI } from './websocket/websocketapi';
import { WebSocketShareService } from './websocket/websocketshareservice';
import { AlertModule } from './_alert';
import { MessageComponent } from './components/message/message.component';
import { ChatComponent } from './components/chat/chat.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    DeviceListComponent,
    CreateUserComponent,
    EditUserComponent,
    CreateDeviceComponent,
    EditDeviceComponent,
    UserViewComponent,
    LoginComponent,
    AdminViewComponent,
    AddEnergyComponent,
    MessageComponent,
    ChatComponent,
  ],
  entryComponents: [
    CreateUserComponent
  ],
  imports: [
    // RouterModule.forRoot(routes), 
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatDatepickerModule,
    MatNativeDateModule,
    AlertModule
  ],
  providers: [UserService, WebSocketAPI, WebSocketShareService, DeviceListComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
}
