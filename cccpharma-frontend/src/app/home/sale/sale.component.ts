import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {CategoryService} from '../../services/category.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../services/product.service';
declare const $;
declare const M;

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css']
})
export class SaleComponent implements OnInit {

  products: any;
  data: any;

  name: string;


  searchedProducts: any;

  constructor(private authService: AuthService,
              private categoryService: CategoryService,
              private formBuilder: FormBuilder,
              private productService: ProductService,
              private router: Router) {
  	this.getProducts();
  	this.setData();
    this.searchedProducts = {};
  }

  ngOnInit() {
  }


  ngOnChanges() {

  }
  ngAfterViewInit() {
    
  }

  setData() {

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
      console.log(res);
      this.searchedProducts = res;
      console.log(this.searchedProducts)
    }, error1 => {
      console.log(error1);
       // M.toast({html: 'Um erro aconteceu'});
    });
  }


  // drawList(products : any) {

  // }

  // addCart(res : any) {
  //    for (var i = res.length - 1; i >= 0; i--) {
  //       if(res[i] in this.searchProduct)
  //    }
  // }


  //  IsPresentArray(product: any) {
  //    Boolean resp = false.
  //    this.searchedProducts.forEach((product) {
  //      console.log(element);
  //    });

  //    retur resp;
  // }

}
