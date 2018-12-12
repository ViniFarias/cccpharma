import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {UsersService} from '../../services/users.service';

declare const M;
declare const $;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  preserveWhitespaces: false
})
export class LoginComponent implements OnInit {


  loginForm: FormGroup;
  registerForm: FormGroup;

  constructor(private authService: AuthService,
              private formBuilder: FormBuilder,
              private userService: UsersService) {

    this.inicializationForm('loginForm');
    this.inicializationForm('registerForm');
  }

  inicializationForm(name) {
    this[name] = this.formBuilder.group({
      username: [null, [Validators.required]],
      password: [null, [Validators.required]],
    });
  }

  ngOnInit() {
  }

  login() {
    const body = this.loginForm.getRawValue();
    this.authService.login(body);
  }

  openModal() {
    $(document).ready(function() {
      $('.modal').modal();
      $('#modal1').modal('open');
    });
  }

  registerUser() {
    let user = this.registerForm.getRawValue();
    user.name = user.username;

    this.userService.createUser(user).subscribe( res => {
      console.log(res);
      M.toast({html: 'Usuário registrado'});
    }, err => {
      console.log(err)
      M.toast({html: 'Um erro ocorreu'});
    })
  }
}
