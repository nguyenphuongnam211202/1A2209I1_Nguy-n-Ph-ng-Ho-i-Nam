import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {ProductService} from '../service/product.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup;
  id: number;

  constructor(private _formBuilder: FormBuilder,
              private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _router: Router) {
  }

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
    });
    this.productForm = this._formBuilder.group({
      id: [this._productService.findById(this.id).id],
      name: [this._productService.findById(this.id).name],
      price: [this._productService.findById(this.id).price],
      description: [this._productService.findById(this.id).description]
    });
  }

  submit() {
    this._productService.delete(this.id);
    alert('Delete thành công');
    this._router.navigate(['/product/list']);
  }

}
