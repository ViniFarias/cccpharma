import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';
import {ProductService} from '../../services/product.service';
import {LotService} from '../../services/lot.service';
import {SaleService} from '../../services/sale.service';

declare const M;

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  lots: any;
  products: any;
  missingProducts: any;
  sales: any;
  receita: any;
  invalidProducts: any;


  constructor(
      private authService: AuthService,
      private productService: ProductService,
      private lotService: LotService,
      private saleService: SaleService,
      private router: Router) {
    this.products = [];
    this.missingProducts = [];
    this.invalidProducts = [];
    this.sales = [];
    this.getLots();
    this.getProducts();
    this.getSales();
    this.receita = 0;
  }

  ngOnInit() {
    if (!this.authService.isLogged()) {
      M.toast({html: 'Usuário não atenticado'});
      this.router.navigate(['/']);
    }
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
    this.productService.getAllProducts().subscribe((res: any) => {

      res.forEach((product: any) => {

        this.productService.getAvailableQuantityByProductId(product).subscribe(res2 => {
          product.availableQuantity = res2;

          if (res2 === null) {
            this.missingProducts.push(product);
          } else {

            this.productService.productIsValid(product).subscribe(res3 => {
              product.isValid = res3;
              if (res3 === false) {
                this.invalidProducts.push(product);
              } else {
                this.products.push(product);
              }
              console.log(res3);
            }, err => {
              console.log(err);
            });
        }
          console.log(res2);
        }, err => {
          console.log(err);
        });
      });

      console.log(res);
    }, err => {
      console.log(err);
    });
  }

  getSales() {
    this.saleService.getSales().subscribe((res: any) => {
      this.receita = 0;
      this.sales = res;
      this.sales.forEach((sale: any) => {this.receita += sale.value;});
      console.log(res);
    }, err => {
      console.log(err);
    });
  }

}
