package org.firehouse.MortarPages.DigitalMediaBuying;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaign extends TestBase {
    public CreateNewCampaign() {
        PageFactory.initElements(driver, this);
    }

    public String verifyCreateNewCampaignPageHeader() {
        return driver.getTitle();
    }
}
