import { UserserviceService } from './userservice.service';
import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable()
export class AuthGuardService implements CanActivate {

  constructor(private router: Router, private userService: UserserviceService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    let currentUser;
    this.userService.currentUser.subscribe(user => currentUser = user)
    if (currentUser && currentUser.name && currentUser.password) {
      // logged in so return true
      console.log('User logged in');
      return true;
    }
    console.log('User logged out');
    // not logged in so redirect to login page with the return url
    this.router.navigate(['/login']);
    return false;
  }
}
