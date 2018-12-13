import { Component, OnInit } from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import {CategoryService} from '../../services/category.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
declare const $;
declare const M;

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories: any;
  categorySelected: any;

  discountForm: FormGroup;

  constructor(private authService: AuthService,
              private categoryService: CategoryService,
              private formBuilder: FormBuilder,
              private router: Router) {

    this.getCategories();
    this.inicializationForm();
  }

  ngOnInit() {
  }

  isAdmin() {
    return this.authService.isAdmin();
  }

  inicializationForm() {
    this.discountForm = this.formBuilder.group({
      discount: [null, [Validators.required]],
    });

  }

  getCategories() {
    this.categoryService.getCategories().subscribe( res => {
      this.categories = res;
      console.log(res);
    }, err => {
      console.log(err);
    });
  }

  formatDiscont(item) {
    return item.discount * 100;
  }

  openModal(name: string) {
    $(document).ready(function() {
      $(name).modal();
      $(name).modal('open');
    });
  }

  editDiscount(item: any) {
    this.categorySelected = item;
    this.openModal('#modal');
  }

  saveEdition() {
    let category = Object.assign({}, this.categorySelected);
    category.discount = this.discountForm.get('discount').value / 100;
    this.categoryService.editCategory(category).subscribe(
      res => {
          this.categorySelected.discount = category.discount;
          M.toast({html: 'Categoria atualizada com sucesso'});
       }, err => {
          console.log(err);
          M.toast({html: 'Ocorreu algum erro'});
    })
  }
}
