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
export class LoginService {
  constructor(private http: HttpClient) { }
   loginUrl: string="/news/authenticate"
   getUserUrl: string="/news/users/"
   changeStatusUrl: string="/news/change/"
   authenticate(user):Observable<any>{
    console.log("inside service");
    return this.http.post( this.loginUrl,  user,  httpOptions);
   }

   getUser(email):Observable<any>{
    return this.http.get(this.getUserUrl+email);

   }
   changeStatus(email):Observable<any>{
    console.log("inside change status")
   return this.http.get(this.changeStatusUrl+email);
  }
}
