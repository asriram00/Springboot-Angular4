import { AuthGuardService } from './service/auth-guard.service';
import { HttpClient } from './service/HttpClient';
import { AlertService } from './service/alert.service';
import { DataServiceService } from './service/data-service.service';
import { UserserviceService } from './service/userservice.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserLoginComponent } from './user-login/user-login.component';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserLoginComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    JsonpModule,
    RouterModule.forRoot([
      { 
        path: '', 
        component: UserLoginComponent,
        canActivate: [AuthGuardService]
      },
      { 
        path: 'login', 
        component: UserLoginComponent
      },
      {
        path: 'list', 
        component: UserListComponent,
        canActivate: [AuthGuardService]
      },
      {
        path: '**',
        component: UserListComponent,
        canActivate: [AuthGuardService]
      }
    ])
  ],
  providers: [UserserviceService, DataServiceService, AlertService, HttpClient, AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
