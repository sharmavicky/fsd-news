import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { HomePage } from '../home/home.po';

describe('Login page', () => {
    let page: LoginPage;
    let home = new HomePage();
    const EC = protractor.ExpectedConditions;
    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });

    it('should be able to login as user', () => {
        page.sendEmailForLogin().sendKeys('user');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
        //  browser.wait(EC.visibilityOf(home.getTitle()));
        //    expect(home.getTitle().isPresent()).toBeTruthy();
          browser.sleep(2000);
        expect(browser.driver.getCurrentUrl()).toContain('home');
    });

    it('should be able to login as admin', () => {
        page.sendEmailForLogin().sendKeys('admin');
        page.sendPasswordForLogin().sendKeys('123456');
        page.getLoginButton().click();
        // browser.wait(EC.visibilityOf(home.getTitle()));
        browser.sleep(2000)
        expect(browser.driver.getCurrentUrl()).toContain('/admin');
    });
     /* it('should be not be able to login if email is wrong', async() => {
        page.sendEmailForLogin().sendKeys('sz@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Invalid Email Id or Password.');
    });   */
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1