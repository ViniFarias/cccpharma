import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {LotService} from '../../services/lot.service';
import {ProductService} from '../../services/product.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
declare const $;
declare const M;

@Component({
  selector: 'app-category',
  templateUrl: './lot.component.html',
  styleUrls: ['./lot.component.css']
})
export class LotComponent implements OnInit {

  lots: any;
  products: any;
  productSelected: any;

  lotForm: FormGroup;

  constructor(private authService: AuthService,
              private lotService: LotService,
              private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router) {

    this.getLots();
    this.getProducts();
    this.inicializationForm();
  }

  ngOnInit() {
  }

  isAdmin() {
    return this.authService.isAdmin();
  }

  inicializationForm() {
    this.lotForm = this.formBuilder.group({
      productsQuantityTotal: [null, [Validators.required]],
      product: [null, [Validators.required]],
      expirationDate: [null, [Validators.required]]
    });

  }

  getLots() {
    this.lotService.getLots().subscribe(res => {
      this.lots = res;
      console.log(res);
    }, err => {
      console.log(err);
    });
  }

  getProducts() {
    this.productService.getAllProject().subscribe(res => {
      this.products = res;
      console.log(res);
    }, err => {
      console.log(err);
    });
  }

  openModal(name: string) {
    $(document).ready(function() {
      $(name).modal();
      $(name).modal('open');
    });
  }

  registerLot() {
    const body = this.lotForm.getRawValue();
    body.product = { 'barcode': body.product};

    const date = new Date(body.expirationDate);
    const newDate = (date.getDate() + '/' + (date.getMonth() + 1) + '/' + date.getFullYear());
    console.log(newDate)
    body.expirationDate = newDate;
    this.lotService.registerLot(body).subscribe(
      res => {
        M.toast({html: 'Lote cadastrado com sucesso'});
        console.log(res);
        this.getLots();
        this.resetLotRegisterForm();
      }, err => {
        M.toast({html: 'Um erro aconteceu ao tentar cadastrar o lote'});
        console.log(err);
      }
    );

  }

  resetLotRegisterForm() {
    this.inicializationForm();
  }
}
