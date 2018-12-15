import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {CategoryComponent} from './category/category.component';
import { SaleComponent } from './sale/sale.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'categoria', component: CategoryComponent },
  { path: 'vendas', component: SaleComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
