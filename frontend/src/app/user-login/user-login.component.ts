import { Router } from '@angular/router';
import { DataServiceService } from './../service/data-service.service';
import { UserserviceService } from './../service/userservice.service';
import { User } from './../user.model';
import { Component } from '@angular/core';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {

  user:User = new User('','','');

  userService;
  dataService;
  errorMsg: String;
  _router;
  constructor(userService : UserserviceService, dataService : DataServiceService, private router: Router) {
    this.userService = userService;
    this.dataService = dataService;
    this._router = router;
  };

  loginForm () {
    this.userService.setUser(this.user);
    this.dataService.loginUser(this.user)
        .subscribe(
          (respData) =>  {
            //this.user = respData
            console.log(respData);
            this.userService.setUser(respData);
            localStorage.setItem('currentUser', JSON.stringify(respData));
            this._router.navigate(['/list']);
          },
          (respError) => {
            console.log(respError);
            this.errorMsg = respError.status;
          });
  }


  // ngOnInit() {
  // }

}
