package org.firehouse;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IntegrationPage extends TestBase {
    @FindBy(xpath = "//h1[contains(text(),'Integrations')]")
    WebElement integrationHeader;
    @FindBy(xpath = "//li[contains(text(),'John Duval Wines')]")
    WebElement displayingBrandName;
    @FindBy(xpath = "//h4[contains(.,'File Upload')]")
    WebElement fileUploadTileInIntegration;

    public IntegrationPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyPageTitle() {
        return driver.getTitle();
    }
    public boolean verifyHeaderOfIntegration() {
        return integrationHeader.isDisplayed();
    }
}
