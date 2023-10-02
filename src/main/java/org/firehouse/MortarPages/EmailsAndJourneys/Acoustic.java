package org.firehouse.MortarPages.EmailsAndJourneys;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Acoustic extends TestBase {
    public Acoustic() {
        PageFactory.initElements(driver, this);}
    public String verifySingleMailingPageHeader() {return driver.getTitle();}
}
