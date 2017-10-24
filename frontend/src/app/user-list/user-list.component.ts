import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { DataServiceService } from './../service/data-service.service';
import { UserserviceService } from './../service/userservice.service';
import { User } from './../user.model';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  title = 'List of User name';
  user: User = new User('', '', '');
  currentUser: User;
  users: User[];
  userService;
  dataService;
  errorMsg: String;
  _router;
  constructor(userService : UserserviceService, dataService : DataServiceService, private router: Router) {
    this.userService = userService;
    this.dataService = dataService;
    this._router = router;
  };

  sumbitForm () {
    this.dataService.addUser(this.user)
        .subscribe(
          (respData) =>  {
            this.users = respData
            console.log(this.users);
          },
          (respError) => {
            console.log(respError);
            this.errorMsg = respError.status;
          });
    
    // this.userService.addUser(this.user);
    // this.users = this.userService.getUsers();
  }
  ngOnInit() {
    console.log('LocalStorage:'+ localStorage.getItem('currentUser'));
    this.dataService.fetchUsers()
        .subscribe(
          (respData) =>  {
            this.users = respData
            console.log(this.users);
          },
          (respError) => {
            console.log(respError);
            this.errorMsg = respError.status;
          });
    this.userService.currentUser.subscribe(currentUser => this.currentUser = currentUser)
  }
}
