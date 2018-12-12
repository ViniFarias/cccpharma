import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {AuthService} from '../../services/auth.service';
declare var $: any;
@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  // Colors
  foodColor: boolean;
  comesticColor: boolean;
  medicinesColor: boolean;
  personalColor: boolean;
  selectAllColor: boolean;

  category: string;
  itens: any;
  close: boolean;

  products: any;

  productForm: FormGroup;

  constructor(private productService: ProductService,
              private formBuilder: FormBuilder,
              private authSerive: AuthService) {
    this.toAllColor(false);
    this.category = 'Nenhuma categoria selecionada';
    this.getAllProducts();

    this.inicializationForm();

  }


  ngOnInit() {
    this.toAllColor(false);
  }

  inicializationForm() {
    this.productForm = this.formBuilder.group({
      name: [null, [Validators.required]],
      barcode: [null, [Validators.required]],
      manufacturer: [null, [Validators.required]],
      category: [null, [Validators.required]],
      price: [null, [Validators.required]],
      available: [null],
    });
  }

  color(name: string) {
    if (name === 'selectAll') {
      const color = !this.selectAllColor;
      this.toAllColor(color);
    } else {
      this.toAllColor(false);
      this[name] = !this[name];
    }
  }

  displayName(name: string) {
    $(document).ready(function () {
      $('#' + name).tooltip();
      $('#' + name).tooltip('open');
    });

    setTimeout(function(){
      $(document).ready(function () {
      $('#' + name).tooltip('close');
    });
    }, 500); 
  }

  checkDiscount(item: any) {
    return item.category.discount == 0;
  }


  selectOption(name: string) {
    this.color(name);
    this.showCategory(name.replace('Color',''));

    if (this.category === 'Produtos') {
      this.itens = this.products;
    } else {
      this.itens = this.products.filter(obj => obj.category.name === this.category);
    }
  }


  selectFilter(op: string){
    this.closeDropdown();
    this.sortArray(op);
  }

  sortArray(type) {
    this.products.sort((a: any, b: any) => {
      if (a[type] < b[type]) {
        return -1;
      } else if (a[type] > b[type]) {
        return 1;
      } else {
        return 0;
      }
    });
  }

  showCategory(name) {
    let resp = '';

    if (this.selectAllColor) {
      resp = 'Produtos';
    } else if (this.foodColor) {
      resp = 'Alimentos';
    } else if(this.comesticColor) {
      resp = 'Cosméticos';
    } else if(this.medicinesColor) {
      resp = 'Medicamentos';
    } else if(this.personalColor) {
      resp = 'Higiene Pessoal';
    } else {
      resp = 'Nenhuma categoria selecionada';
    }
    this.category = resp;
  }

  toAllColor(op: boolean) {
    this.foodColor = op;
    this.comesticColor = op;
    this.medicinesColor = op;
    this.personalColor = op;
    this.selectAllColor = op;
  }


  calculePrice(item) {
    return item.price * (1 - item.category.discount);
  }

  openDropdow() {
    $(document).ready(function(){
      $('.dropdown-trigger').dropdown({
        coverTrigger: false,
        alignment: 'left'
      });
      $('.dropdown-trigger').dropdown('open');
    });
  }

  closeDropdown() {
    $('#dropdown1').click(function (event) {
      event.stopPropagation();
    });
  }


  getAllProducts() {
    this.productService.getAllProject().subscribe( res => {
      this.products = res;
    }, (err) => {
      console.log(err);
    });
  }

  openModal() {
    $(document).ready(function() {
      $('.modal').modal();
      $('#modal1').modal('open');
    });
  }


  registerProduct() {
    const body = this.productForm.getRawValue();
    body.category = { 'id': body.category};
    this.productService.registerProduct(body);
    this.getAllProducts();
  }


  isAdmin() {
    return this.authSerive.isAdmin();
  }
}
