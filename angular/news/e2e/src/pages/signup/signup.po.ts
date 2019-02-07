import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class signupPage {

    navigateToSignupPage() {
        return browser.get('/signup');
    }

    sendEmailSignupPage() {
        return element(by.id('signupemail'));
    }

    sendPasswordForSignup() {
        return element(by.id('signuppassword'));
    }
    getSignupButton() {
        return element(by.id('signupButton'));
    }
    sendLanguageId() {
        return element(by.id('languageid'));
    }

    sendNameSignupPage() {
        return element(by.id('signupname'));
    }
 /*    getErrorMessage() {
        return element(by.className('alert alert-danger'));
    }  */

}
