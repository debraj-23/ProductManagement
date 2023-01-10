import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( private http: HttpClient) { }

  public loginUserFromRemote(user: User):Observable<any>{

    return this.http.post<any>("http://localhost:8081/login", user);
  }
}
