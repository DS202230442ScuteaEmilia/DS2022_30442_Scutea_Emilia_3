import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login/login.component';
import { DeviceListComponent } from './components/device-list/device-list.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserViewComponent } from './components/user-view/user-view.component';
import { AdminViewComponent } from './components/admin-view/admin-view.component';
import { ChatComponent } from './components/chat/chat.component';


const routes: Routes = [
    { path: 'login', component: LoginComponent },
    { path: 'user', component: UserViewComponent },
    { path: 'admin', component: AdminViewComponent },
    { path: 'chat', component: ChatComponent },
    { path: '', redirectTo: 'login', pathMatch: 'full' }
  ];

  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }