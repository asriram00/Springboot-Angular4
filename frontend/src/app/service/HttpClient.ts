import { UserserviceService } from './userservice.service';
import { User } from './../user.model';
import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import { Router } from '@angular/router';

@Injectable()
export class HttpClient {
  //base64encodedData = new Buffer('ajay' + ':' + 'test').toString('base64');
  private options: RequestOptions;
  
  constructor(private http: Http, private userService: UserserviceService, private _router: Router) {}

  private b64Encode(str: string) {
    // first we use encodeURIComponent to get percent-encoded UTF-8,
    // then we convert the percent encodings into raw bytes which
    // can be fed into btoa.
    return window.btoa(str);
  }
  
  createAuthorizationHeader(headers: Headers) {
    headers.append('Content-Type', 'application/json');
    let currentUser;
    this.userService.currentUser.subscribe(user => currentUser = user)
    if(currentUser && currentUser.name && currentUser.password) {
      console.log(currentUser)
      headers.append('Authorization', 'Basic ' + this.b64Encode(currentUser.name+':'+currentUser.password));
    } else {
      this._router.navigate(['/login']);
    }
    this.options = new RequestOptions({headers: headers});
  }

  get(url) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    return this.http.get(url, this.options);
  }

  post(url, data) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    return this.http.post(url, data, this.options);
  }
}