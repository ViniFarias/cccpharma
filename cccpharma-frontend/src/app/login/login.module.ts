import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login/login.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { AuthService } from '../services/auth.service';

@NgModule({
  declarations: [LoginComponent, ListProductsComponent],
  imports: [
    CommonModule,
    LoginRoutingModule
  ],
  providers: [
    AuthService
  ]
})
export class LoginModule { }
