package org.firehouse.MortarPages.SocialAndDisplayAdvertising;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class GoogleAnalytics extends TestBase {
    public GoogleAnalytics() {
        PageFactory.initElements(driver, this);}
    public String verifyGoogleAnalyticsPageHeader() {return driver.getTitle();}
}
