package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Trends extends TestBase {
    public Trends() {
        PageFactory.initElements(driver, this);}
    public String verifyTrendsPageHeader() {return driver.getTitle();}


}
