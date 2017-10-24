import { HttpClient } from './HttpClient';
import { User } from './../user.model';
import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';


@Injectable()
export class DataServiceService {

  private url: String = 'http://localhost:8080/api';

  users: User[];

  constructor(private _http: HttpClient) { }

  fetchUsers(): Observable<User[]> {
    return this._http.get(this.url + '/users')
                     .map((response: Response) => response.json())
                     .catch(this._errorHandler);
  }

  addUser(user: User): Observable<User[]> {
    return this._http.post(this.url + '/register', user)
                     .map((response: Response) => response.json())
                     .catch(this._errorHandler);
  }

  loginUser(user: User): Observable<User> {
    return this._http.post(this.url + '/login', user)
                     .map((response: Response) => response.json())
                     .catch(this._errorHandler);
  }
  
  _errorHandler(error: Response) {
    return Observable.throw(error || 'Server Error');
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

}
