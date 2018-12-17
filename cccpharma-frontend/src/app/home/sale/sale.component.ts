import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../services/product.service';
import {SaleService} from '../../services/sale.service';


declare const $;
declare const M;

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {


  CART = 'Carinho';
  EMPTY_CART = this.CART + ' de compras vazio';
  PRODUCT = 'Produtos';

  products: any;

  name: string;

  title: string;
  searchedProducts: any;
  productsInCart: any;

  qtdForm: FormGroup;

  productSelected: any;

  constructor(private authService: AuthService,
              private saleService: SaleService,
              private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router) {

    this.title = this.EMPTY_CART;
    this.getProducts();
    this.searchedProducts = {};
    this.productsInCart = [];
    this.inicializationForm();
}

  ngOnInit() {
  }


  inicializationForm() {
    this.qtdForm = this.formBuilder.group({
      number: [null, [Validators.required, Validators.min(1)]],
    });

  }


  getProducts() {
    this.productService.getAllProject().subscribe( res => {
      this.products = res;
    }, (err) => {
      console.log(err);
    });
  }


  searchProduct() {
    this.productService.findProductByName(this.name).subscribe( res => {
      this.searchedProducts = res;
      this.title = this.PRODUCT;
    }, error1 => {
      console.log(error1);
       M.toast({html: 'Um erro aconteceu'});
    });
  }


  addCart() {
    M.toast({html: 'Adicionado ao carrinho'});
    this.productsInCart = this.productsInCart.filter(obj => obj.product.name !== this.productSelected.name);
    this.productsInCart.push({ 'product': this.productSelected, 'productsQuantity': this.qtdForm.get('number').value});
  }


  openModal(name: string, item: any) {
    this.productSelected = item;
    $(document).ready(function() {
      $(name).modal();
      $(name).modal('open');
    });
  }

  swapCart() {
    this.title = this.CART;
    this.searchedProducts = this.getProductByCart();
  }


  getProductByCart() {
    let products = [];

    for (let i = 0; i < this.productsInCart.length; i++) {
      products.push(this.productsInCart[i].product);
    }

    return products;

  }

  purchase() {
    let body = {};
    const d = new Date();

    body['saleDate'] = d.getDate() + '/' + (d.getMonth() + 1) + '/' + d.getFullYear();
    body['value'] = this.getFinalValue();
    body['soldProducts'] = this.productsInCart;

    this.saleService.makePurchase(body).subscribe(
      res => {
        console.log(res);
        M.toast({html: 'Compra realizada com sucesso'});
        this.productsInCart = [];
      },
      err => {
        console.log(err);
        M.toast({html: 'Ocorreu um erro ao realizar a compra'});
      });
  }

  getFinalValue() {
    let sum = 0;

    for (let i = 0; i < this.productsInCart.length; i++) {
      let item = this.productsInCart[i];
      console.log(item);
      sum += (item.product.price * (1 - item.product.category.discount) * item.productsQuantity);
    }

    return sum;

  }

}


