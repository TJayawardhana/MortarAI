package org.firehouse.MortarPages;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class MyCustomers extends TestBase {
    public MyCustomers() {
        PageFactory.initElements(driver, this);}
    public String verifyMyCustomersPageHeader() {return driver.getTitle();}


}
