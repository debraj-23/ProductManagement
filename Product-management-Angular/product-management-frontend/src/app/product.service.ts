import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl = 'http://localhost:8081/view';

  constructor(private http: HttpClient) { 
  }

  public getProductList(): Observable<Product[]>{
    return this.http.get<Product[]>(this.productUrl);
  }
}
