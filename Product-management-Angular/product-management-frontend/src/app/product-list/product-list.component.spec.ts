import { of } from "rxjs";
import { Product } from "../product";
import { ProductListComponent } from "./product-list.component";

describe('ProductList Component',()=>{
  let product: Product[];
  let component: ProductListComponent;
  let mockProductService: any;

  beforeEach(()=>{
    product = [
      {
        id: 1,
        name: 'Headphone',
        description: 'Samsung earphones',
        price: 1000,
      },
      {
        id: 2,
        name: 'Headphone',
        description: 'Samsung earphones new',
        price: 1200,
      },
      {
        id: 3,
        name: 'Headphone',
        description: 'Samsung earphones pro',
        price: 3000,
      }
    ];

    mockProductService = jasmine.createSpyObj(['getProductList']);
    component = new ProductListComponent(mockProductService);
  });

  describe('getProductList()',()=>{
    it('should get all the products from list of products',()=>{
      mockProductService.getProductList.and.returnValue(of(true));
      component.products = product;
      component.ngOnInit;
      expect(component.products.length).toBe(3)
    }); 
  });
});