import { AdminPage } from "./admin.po";
import { browser } from "protractor";


describe('admin page', () => {

  let page: AdminPage
  beforeEach(() => {
    page = new AdminPage();
    page.navigateToAdminPage();
  });




  it('should be able to dispaly user details', () => {
   page.sendValueForSearch().sendKeys('user@gmail.com')
   page.getButttonForSearch().click();
   browser.sleep(2000)
   expect(browser.driver.getCurrentUrl()).toContain('')

  });
})


