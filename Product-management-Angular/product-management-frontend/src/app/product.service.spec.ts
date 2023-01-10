import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
//import { Product } from '../product';
import { ProductService } from './product.service';

describe('Product Service', () => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let postService: ProductService;
  let product = [
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
  beforeEach(() => {
    let httpClientSpyObj = jasmine.createSpyObj('HttpClient', ['get']);
    TestBed.configureTestingModule({
      providers: [
        ProductService,
        {
          provide: HttpClient,
          useValue: httpClientSpyObj,
        },
      ],
    });
    postService = TestBed.inject(ProductService);
    httpClientSpy = TestBed.inject(HttpClient) as jasmine.SpyObj<HttpClient>;
  });

  describe('getProductList()', () => {
    it('should return expected products when getproductlist is called', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(product));
      postService.getProductList().subscribe({
        next: (Product) => {
          expect(Product).toEqual(product);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    });
  });
});