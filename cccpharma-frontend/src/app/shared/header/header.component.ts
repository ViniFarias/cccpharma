import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  preserveWhitespaces: false
})
export class HeaderComponent implements OnInit {

  local: string;
  isLogged: boolean;
  isAdmin: boolean;

  constructor(private router: Router,
              private authService: AuthService) {
      this.router.events.subscribe((change) => {
        if (this.authService.isLogged()) {
          this.local = 'Home';
          this.isLogged = true;
        } else {
          this.isLogged = false;
          this.local = 'Descrição';
        }
      });
   }

  ngOnInit() {
  }


  logout() {
    this.authService.logout();
  }
}
