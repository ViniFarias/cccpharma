import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../services/product.service';
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
  constructor(private productService: ProductService) {
    this.toAllColor(false);
    this.category = 'Nenhuma categoria selecionada';
    this.getAllProducts();
  }


  ngOnInit() {
    this.toAllColor(false);
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
    var e = document.getElementById('options');
    e.onmouseover = function() {
      document.getElementById('popup' + name).style.display = 'block';
    }
    e.onmouseout = function() {
      document.getElementById('popup' + name).style.display = 'none';
    }
  }

  selectOption(name: string) {
    this.color(name);
    this.showCategory(name.replace('Color',''))
    
    if (this.category === 'Produtos')
      this.itens = this.products;
    else {
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
      $('.dropdown-trigger').dropdown();
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
      console.log(res['data']);
    }, (err) => {
      console.log(err);
    });
  }

  public products = [
    {
      "barcode": "12345678",
      "name": "Perfume 1",
      "manufacturer": "Fab1",
      "available": true,
      "price": 35,
      "expirationDate": "10/01/2020",
      "category": {
          "name": "Cosméticos",
          "discount": 0.1
      },
      
    },

    {
      "barcode": "12345678",
      "name": "Bolo 1",
      "manufacturer": "Fab1",
      "available": true,
      "price": 10,
      "expirationDate": "07/01/2020",
      "category": {
          "name": "Alimentos",
          "discount": 0.1
      },
    },

    {
      "barcode": "12345678",
      "name": "Escova Dental",
      "manufacturer": "Fab1",
      "available": true,
      "price": 7,
      "expirationDate": "07/01/2023",
      "category": {
          "name": "Higiene Pessoal",
          "discount": 0.1
      }
    },

    {
      "barcode": "12345678",
      "name": "Amoxilina",
      "manufacturer": "Fab1",
      "available": true,
      "price": 55,
      "expirationDate": "07/01/2024",
      "category": {
          "name": "Medicamentos",
          "discount": 0.1
      }
    }

  ];
  
}
