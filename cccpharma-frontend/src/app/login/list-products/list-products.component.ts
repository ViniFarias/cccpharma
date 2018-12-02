import { Component, OnInit } from '@angular/core';
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
  constructor() { 
    this.toAllColor(false);
    this.category = 'Nenhuma categoria selecionada';
  }


  ngOnInit() {
    this.toAllColor(false);
  }

  color(name: string) {
    if (name == 'selectAll') {
      const color = !this.selectAllColor;
      this.toAllColor(color);
    } else {
      this.toAllColor(false);
      this[name] = !this[name];
    }
  }

  selectOption(name: string) {
    this.color(name);
    this.showCategory(name.replace('Color',''))
    
    if (this.category == 'Produtos')
      this.itens = this.products;
    else {
      this.itens = this.products.filter(obj => obj.category.name === this.category);
    }
  }


  selectFilter(op: string){
    this.closeDropdown();
    console.log(op);
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

  public products = [
    {
      "barcode": "12345678",
      "name": "Perfume 1",
      "manufacturer": "Fab1",
      "available": true,
      "price": 35,
      "category": {
          "name": "Cosméticos",
          "discount": 0.1
      }
    },

    {
      "barcode": "12345678",
      "name": "Bolo 1",
      "manufacturer": "Fab1",
      "available": true,
      "price": 10,
      "category": {
          "name": "Alimentos",
          "discount": 0.1
      }
    },

    {
      "barcode": "12345678",
      "name": "Escova Dental",
      "manufacturer": "Fab1",
      "available": true,
      "price": 7,
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
      "category": {
          "name": "Medicamentos",
          "discount": 0.1
      }
    }

  ];
  
}
