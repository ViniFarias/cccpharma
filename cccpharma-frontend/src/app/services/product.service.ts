import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {AuthService} from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url: string;

  constructor(private http: HttpClient,
              private authService: AuthService) {
    this.url = environment.API + '/products';
  }

  getAllProducts() {
    const httpOptions = this.authService.getHttpHeadersWithoutToken();
    const request = this.http.get(this.url, httpOptions);

    return request;
  }

  registerProduct(body: any) {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const request = this.http.post(this.url, body, httpOptions);

    return request;
  }

  getAvailableQuantityByProductId(product: any) {
    const productId = product.barcode;
    const httpOptions = this.authService.getHttpHeadersWithoutToken();
    const request = this.http.get(this.url + '/' + productId + '/availableQuantity', httpOptions);

    return request;
  }

  findProductByName(name: any) {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const newURL = this.url + '/name/contains/' + name;
    const request = this.http.get(newURL, httpOptions);

    return request;
  }


  availableQuantityProduct(id: string) {
    const httpOptions = this.authService.getHttpHeadersWithToken();
    const newUrl = this.url + '/' + id + '/availableQuantity';
    const request = this.http.get(newUrl + '', httpOptions);

    return request;
  }
}
