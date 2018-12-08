import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url: string;

  constructor(private http: HttpClient) {
    this.url = environment.API + '/products';
  }

  getAllProject() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json',
        'Access-Control-Allow-Origin': '*'

  })
    };

    const request = this.http.get(this.url, httpOptions);

    return request;

  }
}
