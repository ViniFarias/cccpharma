import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import { CategoryComponent } from './category/category.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LotComponent } from './lot/lot.component';
import { SaleComponent } from './sale/sale.component';
import { SaleService} from '../services/sale.service';
import { SaleListComponent } from './sale-list/sale-list.component';

@NgModule({
  declarations: [
    HomeComponent,
    CategoryComponent,
    LotComponent,
    SaleComponent,
    SaleListComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    SaleService
  ]
})
export class HomeModule { }
