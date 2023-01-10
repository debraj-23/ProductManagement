import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProductListComponent implements OnInit {
  products: Product[];

  constructor(private productService: ProductService){}

  ngOnInit() {
    {
      this.productService.getProductList().subscribe(data => {
        this.products=data;
      });
  }


  }
}
