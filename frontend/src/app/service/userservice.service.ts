import { User } from './../user.model';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/BehaviorSubject'

@Injectable()
export class UserserviceService {

  constructor () {
  }
  private userSource = new BehaviorSubject<User>(User);
  currentUser = this.userSource.asObservable();

  setUser(user: User) {
    this.userSource.next(user);
  }
}
