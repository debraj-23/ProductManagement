import { DebugElement } from '@angular/core';
import {
  ComponentFixture,
  fakeAsync,
  TestBed,
  tick,
  waitForAsync,
} from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { LoginComponent } from './login.component';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

class Page {
  get submitButton() {
    return this.fixture.nativeElement.querySelector('btn');
  }
  get usernameInput() {
    return this.fixture.debugElement.nativeElement.querySelector('#emailid');
  }
  get passwordInput() {
    return this.fixture.debugElement.nativeElement.querySelector('#pwd');
  }

  get errorMsg() {
    return this.fixture.debugElement.query(By.css('.error')).nativeElement;
  }

  constructor(private fixture: ComponentFixture<LoginComponent>) {}

  public updateValue(input: HTMLInputElement, value: string) {
    input.value = value;
    input.dispatchEvent(new Event('input'));
  }
}
describe('Login Component', () => {
  let loginComponent: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let debugEl: DebugElement;

  let loginService: RegistrationService;
  let loginServiceSpy: { login: jasmine.Spy };
  let routerSpy: { navigateByUrl: jasmine.Spy };
  let router: Router;
  let page: Page;

  beforeEach(() => {
    loginServiceSpy = jasmine.createSpyObj(RegistrationService, ['loginUser']);
    routerSpy = jasmine.createSpyObj(Router, ['navigateByUrl']);
    TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [LoginComponent],
      providers: [
        { provide: RegistrationService, useValue: loginServiceSpy },
        { provide: Router, useValue: routerSpy },
      ],
    });
    fixture = TestBed.createComponent(LoginComponent);
    loginComponent = fixture.componentInstance;
    debugEl = fixture.debugElement;
    loginService = TestBed.inject(RegistrationService);
    router = TestBed.inject(Router);
    page = new Page(fixture);
    fixture.detectChanges();
  });

  it('empty credentials', () => {
    //page.updateValue(page.usernameInput, 'debraj@gmail.com');
    expect(loginComponent.user).toBeNull;
    fixture.detectChanges();
    expect(loginComponent.msg).toBe('');
  });


});