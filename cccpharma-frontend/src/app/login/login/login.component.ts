import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  preserveWhitespaces: false
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup;

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder) {

    this.inicializationForm();
  }

  inicializationForm() {
    this.loginForm = this.formBuilder.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  ngOnInit() {
  }

  login() {
    const body = this.loginForm.getRawValue();
    console.log(body);
    this.authService.login(body);
  }

}
