import { browser, element, by } from "protractor";
import { NavigationEnd } from "@angular/router";


/* import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get('/');
  }

  */

 export class AdminPage{
   navigateToAdminPage() {
     return browser.get('/admin');
   }
  


  sendValueForSearch(){
    return element(by.id('search'));

  }

  getButttonForSearch(){
    return element(by.id('searchButton'))
  }
}