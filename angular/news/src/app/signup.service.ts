import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders(
    {
      'Content-Type': 'application/json',
    }
  )
};
@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }
  saveUrl: string = "/news/save"
  signup(json): Observable<any> {
    console.log("inside service");
    return this.http.post(this.saveUrl, json, httpOptions)

  }
}
