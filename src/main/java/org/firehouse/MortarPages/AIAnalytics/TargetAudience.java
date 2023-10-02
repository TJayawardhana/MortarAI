package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class TargetAudience extends TestBase {
    public TargetAudience() {
        PageFactory.initElements(driver, this);}
    public String verifyTargetAudiencePageHeader() {return driver.getTitle();}


}

