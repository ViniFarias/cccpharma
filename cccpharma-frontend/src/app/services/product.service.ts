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
        'Access-Control-Allow-Origin': '*',
        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0NTE2Njk2MX0.6vK8Fwo95gpohES_t_gsWXbpUT9HCij_uQBSHQVbTkCbiUR447BlStjiZoLG0gFm4OhR0z_NVNH05sB5ysEG1g'
      })
    };
    console.log(this.url);

    const request = this.http.get(this.url, httpOptions);

    return request;

  }
}
