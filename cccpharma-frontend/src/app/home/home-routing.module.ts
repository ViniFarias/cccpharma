import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {CategoryComponent} from './category/category.component';
import { SaleComponent } from './sale/sale.component';
import { LotComponent } from './lot/lot.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'categoria', component: CategoryComponent },
  { path: 'lote', component: LotComponent },
  { path: 'vendas', component: SaleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
