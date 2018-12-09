import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import { LoginComponent } from './login/login.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { AuthService } from '../services/auth.service';
import {ProductService} from '../services/product.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [LoginComponent, ListProductsComponent],
  imports: [
    CommonModule,
    LoginRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    AuthService,
    ProductService
  ]
})
export class LoginModule { }
