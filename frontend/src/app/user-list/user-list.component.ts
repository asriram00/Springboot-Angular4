import { User } from './../user.model';
import { UserserviceService } from './../userservice.service';

import { Component } from '@angular/core';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {
  title = 'List of User name';
  user = new User('', '');
  users;
  userService = new UserserviceService();
  constructor(service : UserserviceService) {
    this.users = service.getUsers();
  };
  sumbitForm () {
    console.log(this.user);
    this.userService.addUser(JSON.stringify(this.user));
    console.log(this.userService.getUsers());
    this.users = this.userService.getUsers();
  }
}
