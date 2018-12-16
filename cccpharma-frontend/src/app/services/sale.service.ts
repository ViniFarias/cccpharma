import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {AuthService} from './auth.service';
import {HttpClient, HttpHeaders} from '../../../node_modules/@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SaleService {

  url: string;

  constructor(private http: HttpClient,
              private authService: AuthService) {

    this.url = environment.API + '/sales';
  }



  makePurchase(body: any) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': this.authService.getToken()
      })
    };
    console.log(body);
    const request = this.http.post(this.url, body, httpOptions);
    return request;
  }


  getSales() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': this.authService.getToken()
      })
    };
    console.log(this.url);
    const request = this.http.get(this.url, httpOptions);

    return request;
  }

  cancelSale(id: string) {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*',
        'Authorization': this.authService.getToken()
      })
    };

    const request = this.http.delete(this.url + id, httpOptions);

    return request;
  }
}
