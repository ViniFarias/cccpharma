import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  TYPE = "TYPE";
  ADMIN = 'ADMIN';

  constructor(private router: Router) { }

  login(body: any) {
    console.log(body);
    localStorage.setItem(this.TYPE, this.ADMIN);
    this.router.navigate(['/home']);
  }


  isLogged() {
    const type = localStorage.getItem(this.TYPE);
    if (type === this.ADMIN) {
      return true;
    } else {
      return false;
    }
  }
}
