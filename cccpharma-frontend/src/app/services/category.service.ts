import { Injectable } from '@angular/core';
import {HttpClient} from '../../../node_modules/@angular/common/http';
import {AuthService} from './auth.service';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  url: string;

  constructor(private http: HttpClient,
              private authService: AuthService) {

    this.url = environment.API + '/categories';
  }

  getCategories() {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const request = this.http.get(this.url, httpOptions);

    return request;
  }

  editCategory(category: any) {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const request = this.http.post(this.url, category, httpOptions);

    return request;
  }
}
