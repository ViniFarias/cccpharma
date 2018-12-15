import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import {CategoryComponent} from './category/category.component';
import { LotComponent } from './lot/lot.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'categoria', component: CategoryComponent },
  { path: 'lote', component: LotComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
