package org.firehouse.MortarPages.EmailsAndJourneys;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Klaviyo extends TestBase {
    public Klaviyo() {
        PageFactory.initElements(driver, this);}
    public String verifyKlaviyoPageHeader() {return driver.getTitle();}
}
