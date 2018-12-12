import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../../node_modules/@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = environment.API + '/users';
  }

  createUser(body: any) {

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    };

    const request = this.http.post(this.url + '/registration', body, httpOptions);

    return request;
  }
}
