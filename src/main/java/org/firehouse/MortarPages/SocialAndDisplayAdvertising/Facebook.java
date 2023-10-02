package org.firehouse.MortarPages.SocialAndDisplayAdvertising;


import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Facebook extends TestBase {
    public Facebook() {
        PageFactory.initElements(driver, this);}
    public String verifyFacebookPageHeader() {return driver.getTitle();}
}
