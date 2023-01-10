
import { TestBed } from '@angular/core/testing';
import {HttpClientTestingModule , HttpTestingController} from '@angular/common/http/testing';

import { RegistrationService } from './registration.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';


describe('RegistrationService', () => {
  let service: RegistrationService
  let http:HttpClient;
  let httpController:HttpTestingController;
  beforeEach(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      providers:[RegistrationService],
    });
    service = TestBed.inject(RegistrationService);
    http = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);

  });
  afterEach(() => {
    httpController.verify();
  });

  it('should be created', () => {
    expect(service).toBeDefined();   
  });


  it('call login()', () => {
    const testData = true;
    const expectedURL = `/login`;
    const inputData = {
      id: 1,
      fname: 'Debraj',
      lname:'Som',
      email:'debraj@gmail.com',
      password:'debraj12'
    };

    service
      .loginUserFromRemote(inputData).subscribe((data: any) => expect(data).toEqual(testData));

    const req = httpController.expectOne('http://localhost:8081/login');

    expect(req.request.method).toEqual('POST');

    req.flush(testData);
  });

  it('call login() failed', () => {
    const expectedURL = `/login`;
    const emsg = 'status 500 error';
    const inputData = {
      id: 1,
      fname: 'Debraj',
      lname: 'Som',
      email: 'debraj@gmail.com',
      password: 'debraj123',
    };

    service.loginUserFromRemote(inputData).subscribe(
      () => fail('should have failed with the 500 error'),
      (error: HttpErrorResponse) => {
        expect(error.status).toEqual(500, 'status');
        expect(error.error).toEqual(emsg, 'message');
      }
    );

    const req = httpController.expectOne('http://localhost:8081/login');

    expect(req.request.method).toEqual('POST');

    req.flush(emsg, { status: 500, statusText: 'Server Error' });
  });

});