import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { environment } from '../../environments/environment';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  url: string;

  constructor(private http: HttpClient,
              private authService: AuthService) {
    this.url = environment.API + '/users';
  }

  createUser(body: any) {
    const httpOptions = this.authService.getHttpHeadersWithoutToken();
    const request = this.http.post(this.url + '/registration', body, httpOptions);

    return request;
  }
}
