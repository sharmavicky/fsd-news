import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor() { }

  loggedIn :  boolean = false;
  role: string;
  email: string;
  blacklist:boolean;
  languageCode:any;
   id:any;
 token:any;
  login() {
    console.log("Inside auth service login()");
    this.loggedIn = true;
  }

  logout() {
    console.log("Inside auth service logout()");
    this.loggedIn = false;
  }

  getRole() {
    return this.role;
  }

  setRole(role: string) {
    this.role = role;
  }

   getToken(){
    return  this.token;
   }
   SetToken(token: any){
    this.token=token;
   }
  getLanguageCode(){
    return  this.languageCode;
   }
 
   setLanguageCode(languageCode:string){
       this.languageCode=languageCode;
    }
    setSetStatus(blacklist:boolean){
      this.blacklist=blacklist;
    }
    getStatus(blacklist:boolean){
      return this.blacklist;
    }
    
  setUserId(id:number) {
    this.id = id;
  }
  getUserId() {
    return this.id;
  }
}
