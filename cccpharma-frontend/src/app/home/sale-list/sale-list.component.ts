import { Component, OnInit } from '@angular/core';
import {SaleService} from '../../services/sale.service';
declare const $;
declare const M;

@Component({
  selector: 'app-sale-list',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent implements OnInit {


  sales: any;

  constructor(private saleService: SaleService) {
    this.sales = [];
    this.getSales();
  }

  ngOnInit() {
  }

  getSales() {
    this.saleService.getSales().subscribe( res => {
      this.sales = res;
      console.log(res);
    }, err => {
      console.log(err);
    });
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

  selectFilter(op: string){
    this.closeDropdown();

    if (op === 'saleDate') {
      this.sortByDate(op, 0);
    } else {
      this.sortArray(op);
    }

  }

  cancelSale(sale: any) {
    this.saleService.cancelSale(sale.id).subscribe( res =>{
      console.log(res);
      this.sales = this.sales.filter(obj => obj !== sale);
      M.toast({html: 'Venda cancelada com sucesso'});
    }, err => {
      M.toast({html: 'Ocorreu algum erro'});
      console.log(err);
    })
  }

  private sortArray(type) {
    this.sales.sort((a: any, b: any) => {
      if (a[type] < b[type]) {
        return -1;
      } else if (a[type] > b[type]) {
        return 1;
      } else {
        return 0;
      }
    });
  }


  private sortByDate(type, num) {
    if (num !== 3) {
      this.sales.sort((a: any, b: any) => {
        const _a = this.getPartDate(a[type], num)
        const _b = this.getPartDate(b[type], num)
        if (_a < _b) {
          return -1;
        } else if (_a > _b) {
          return 1;
        } else {
          return 0;
        }
      });
      this.sortByDate(type, num + 1);
    }
  }

  private getPartDate(data: string, num: number) {
    return data.split('/')[num];
  }



}
