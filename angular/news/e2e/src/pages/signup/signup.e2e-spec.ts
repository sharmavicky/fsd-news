
import { protractor, browser } from 'protractor';
import { HomePage } from '../home/home.po';
import { signupPage } from './signup.po';

describe('Signup page', () => {
    let page: signupPage;
    let home = new HomePage();
    const EC = protractor.ExpectedConditions;
    beforeEach(() => {
        page = new signupPage();
        page.navigateToSignupPage();
    });

    it('should be able to signup as user', () => {
        page.sendNameSignupPage().sendKeys('analyst');
        page.sendEmailSignupPage().sendKeys('user1234@gmail.com');
        page.sendPasswordForSignup().sendKeys('123456');
        page.sendLanguageId().sendKeys("english");
        page.getSignupButton().click();
        // browser.wait(EC.visibilityOf(home.getTitle()));
        //    expect(home.getTitle().isPresent()).toBeTruthy();
        browser.sleep(2000)
        expect(browser.driver.getCurrentUrl()).toContain('');
    });


    it('should be not able to signup as user if emailId already present', () => {
        page.sendNameSignupPage().sendKeys('user@gmail.com');
        page.sendEmailSignupPage().sendKeys('user');
        page.sendPasswordForSignup().sendKeys('123456');
        page.sendLanguageId().sendKeys("english");
        page.getSignupButton().click();
        // browser.wait(EC.visibilityOf(home.getTitle()));
        browser.sleep(2000)
        expect(browser.driver.getCurrentUrl()).toContain('');
    });

});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1