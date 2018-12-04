import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  type: string;

  ADMIN = 'ADMIN';

  constructor(private router: Router) { }

  login(body: any) {
    console.log(body);
    this.type = this.ADMIN;
    this.router.navigate(['/home']);
  }


  isLogged() {
    if (this.type === this.ADMIN) {
      return true;
    } else {
      return false;
    }
  }
}
