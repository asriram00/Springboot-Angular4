import { User } from './user.model';
import { Injectable } from '@angular/core';

@Injectable()
export class UserserviceService {
  users: User[] = [];

  constructor () {
  }
  getUsers () {
    return this.users;
  }
  addUser (userObj) {
    let user: User = <User> JSON.parse(userObj);
    this.users.push(user);
    return this.users;
  }

}
