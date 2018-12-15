import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  TYPE = 'TYPE';
  ADMIN = 'ADMIN';
  CLIENT = 'CLIENT';
  TOKEN = 'TOKEN'

  url: string;

  constructor(
    private router: Router,
    private http: HttpClient) 
  { 
    this.url = environment.API + '/login';
  }

  login(body: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*'
      })
    };
    const request = this.http.post(this.url, body, httpOptions);
    console.log(this.url);
    request.subscribe( res => {
      const token = res['accessToken'];
      localStorage.setItem(this.TOKEN, token);
      if (res['admin']) {
        localStorage.setItem(this.TYPE, this.ADMIN);
        this.router.navigate(['/home']);
      } else {
        localStorage.setItem(this.TYPE, this.CLIENT);
        this.router.navigate(['/']);
      }
    }, (err) => {
      console.log(err);
    });

  }

  logout() {
    localStorage.clear();
    window.location.reload();
  }

  getToken() {
    return localStorage.getItem(this.TOKEN);
  }

  isLogged() {
    const type = localStorage.getItem(this.TYPE);
    if (type !== null ) {
      return true;
    } else {
      return false;
    }
  }

  isAdmin() {
    const type = localStorage.getItem(this.TYPE);
    if (type === this.ADMIN) {
      return true;
    } else {
      return false;
    }
  }

}
