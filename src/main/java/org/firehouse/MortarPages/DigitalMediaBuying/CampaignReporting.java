package org.firehouse.MortarPages.DigitalMediaBuying;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class CampaignReporting extends TestBase {
    public CampaignReporting() {
        PageFactory.initElements(driver, this);}
    public String verifyCampaignReportingPageHeader() {return driver.getTitle();}


}
