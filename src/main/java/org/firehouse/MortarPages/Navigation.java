package org.firehouse.MortarPages;

import org.firehouse.Base.TestBase;
import org.firehouse.IntegrationPage;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.DigitalMediaBuying.CampaignReporting;
import org.firehouse.MortarPages.DigitalMediaBuying.CreateNewCampaign;
import org.firehouse.MortarPages.EmailsAndJourneys.Klaviyo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Navigation extends TestBase {
    @FindBy(css = ".navigation-left")
    WebElement navigationBarElement;
    //Nav BAr
    @FindBy(css = ".navigation-left li:nth-of-type(1)")
    WebElement navBusinessOverviewLink;

    //Ai Analytics From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(2)")
    WebElement navAiAnalyticsLink;

    //My Customer From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(3)")
    WebElement navMyCustomersLink;

    //Integration From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(4)")
    WebElement navIntegrationsLink;
    //Emails & Journeys From Nav Bar
    @FindBy(css = ".navigation-left .lvl1:nth-of-type(6)")
    WebElement navEmailsAndJourneyLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(1)")
    WebElement emailsAndJourneyPageSingleMailingLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(2)")
    WebElement klaviyoPageLink;
    //Social & Display Advertising From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(7)")
    WebElement navSocialDisplayAdvertisingLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(1)")
    WebElement facebookAdvertisingDashboardPageLink;
    @FindBy(css = ".childNav .nav-item.ng-star-inserted:nth-of-type(2)")
    WebElement googleAnalyticsDashboardPageLink;
    //Digital Media Buying From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(8)")
    WebElement navDigitalMediaBuyingLink;
    @FindBy(css = "li:nth-of-type(1) > .ng-star-inserted > .item-name.lvl1")
    WebElement campaignReportingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement campaignCreatingPageLink;

    //My Creatives From Nav Bar
    @FindBy(css = ".navigation-left li:nth-of-type(9)")
    WebElement navMyCreativesLink;

    public Navigation() {
        //PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyNavigationBarIsAvailable() {
        return navigationBarElement.isDisplayed();
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

    public IntegrationPage clickOnGoToIntegrations() {
        navIntegrationsLink.click();
        return new IntegrationPage();
    }

    public void clickOnOpenSubMenuEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
    }


    public Klaviyo clickOnGoToKlaviyoDashboardPage() {
        klaviyoPageLink.click();
        return new Klaviyo();
    }

    public void clickOnOpenSubMenuNavSocialDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
    }

    public void clickOnNavDigitalMediaBuying() {
        navDigitalMediaBuyingLink.click();
    }

    public CampaignReporting clickOnGoToCampaignReportingPage() {
        navDigitalMediaBuyingLink.click();
        campaignReportingPageLink.click();
        return new CampaignReporting();
    }

    public CreateNewCampaign clickOnGoToCreateNewCampaignPage() {
        navDigitalMediaBuyingLink.click();
        campaignCreatingPageLink.click();
        return new CreateNewCampaign();
    }
}