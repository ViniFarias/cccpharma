import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {AuthService} from './auth.service';

declare const M;

@Injectable({
  providedIn: 'root'
})
export class LotService {

  url: string;

  constructor(private http: HttpClient,
              private authService: AuthService) {
    this.url = environment.API + '/lots';
  }

  getLots() {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const request = this.http.get(this.url, httpOptions);

    return request;
  }

  registerLot(body: any) {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const request = this.http.post(this.url, body, httpOptions);

    return request;
  }
}
