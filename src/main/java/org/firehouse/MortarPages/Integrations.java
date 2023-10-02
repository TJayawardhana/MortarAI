package org.firehouse.MortarPages;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Integrations extends TestBase {
    public Integrations() {
        PageFactory.initElements(driver, this);}
    public String verifyIntegrationsPageHeader() {return driver.getTitle();}
}
