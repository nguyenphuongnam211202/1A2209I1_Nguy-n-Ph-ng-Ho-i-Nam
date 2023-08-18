import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;

  constructor(private _formBuilder: FormBuilder, private _productService: ProductService) { }

  ngOnInit(): void {
    this.productForm = this._formBuilder.group({
      id: [],
      name: [],
      price: [],
      description: []
    });
  }
  submit() {
    const product = this.productForm.value;
    this._productService.saveProduct(product);
    this.productForm.reset();
  }

}
