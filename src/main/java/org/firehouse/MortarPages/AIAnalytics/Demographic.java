package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Demographic extends TestBase {
    public Demographic() {
        PageFactory.initElements(driver, this);}
    public String verifyDemographicPageHeader() {return driver.getTitle();}


}
