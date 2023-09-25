package org.firehouse.MortarPages;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.EmailsAndJourneys.Acoustic.SingleMailing;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends TestBase {
    //Nav BAr
    @FindBy(xpath = "//span[contains(text(),'Business Overview')]")
    WebElement navBusinessOverviewLink;

    //Ai Analytics From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'AI Analytics')]")
    WebElement navAiAnalyticsLink;

    //My Customer From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Customers')]")
    WebElement navMyCustomersLink;

    //Integration From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Integrations')]")
    WebElement navIntegrationsLink;
    //Emails & Journeys From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Emails & Journeys')]")
    WebElement navEmailsAndJourneyLink;

    //Social & Display Advertising From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Social & Display Advertising')]")
    WebElement navSocialDisplayAdvertisingLink;

    //Digital Media Buying From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'Digital Media Buying')]")
    WebElement navDigitalMediaBuyingLink;

    //My Creatives From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Creatives')]")
    WebElement navMyCreativesLink;
    public Navigation(){
        PageFactory.initElements(driver, this);
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }
    public CustomerChurnPrediction clickOnGoToCustomerChurnPrediction() {
        navAiAnalyticsLink.click();
        return new CustomerChurnPrediction();
    }
    public MyCustomers clickOnGoToMyCustomer() {
        navMyCustomersLink.click();
        return new MyCustomers();
    }
    public Integrations clickOnGoToIntegrations() {
        navIntegrationsLink.click();
        return new Integrations();
    }
    public SingleMailing clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new SingleMailing();
    }
    public Facebook clickOnGoToSocialAndDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
        return new Facebook();
    }

    public Creatives clickOnGoToCreatives() {
        navMyCreativesLink.click();
        return new Creatives();
    }
}

