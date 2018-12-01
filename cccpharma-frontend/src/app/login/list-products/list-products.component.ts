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


  constructor() { 
    this.toAllColor(false);
  }

  ngOnInit() {
    this.toAllColor(false);
  }

  color(name: string) {
    if (name == 'selectAll') {
      const color = !this.selectAllColor;
      this.toAllColor(color);
    } else {
      this[name] = !this[name];
    }
  }

  selectOption(name: string) {
    this.color(name);
  }

  toAllColor(op: boolean) {
    this.foodColor = op;
    this.comesticColor = op;
    this.medicinesColor = op;
    this.personalColor = op;
    this.selectAllColor = op;
  }
  
}
