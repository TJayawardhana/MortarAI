package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Creatives;
import org.firehouse.MortarPages.EmailsAndJourneys.Acoustic;
import org.firehouse.MortarPages.Integrations;
import org.firehouse.MortarPages.MyCustomers;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerChurnPrediction extends TestBase {
    @FindBy(xpath = "xpath=//h1[contains(text(),'Analytics')]")
    WebElement analyticsLabel;
    @FindBy(xpath = "xpath=//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement businessOwnerID;
    //Nav BAr
    //Business Overview Button
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
    //Date Filter
    @FindBy(id = "dropdownMenuButton")
    WebElement dateFilterButton;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-child(1)")
    WebElement next30DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(2)")
    WebElement next60DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(3)")
    WebElement previous30DaysFilter;
    @FindBy(css = "[class='dropdown-menu mb-2 show'] .dropdown-item:nth-of-type(4)")
    WebElement previous60DaysFilter;
    //AI Analytics Page
    @FindBy(id = "ngb-nav-0")
    WebElement customerChurnPredictionLink;
    @FindBy(xpath = "//button[contains(.,' Export Underlying Sales Data')]")
    WebElement exportUnderlyingSalesDataButton;
    @FindBy(css = "[class='btn btn-outline-dark mx-2']")
    WebElement exportButton;
    @FindBy(id = "ngb-nav-1")
    WebElement salesLink;
    @FindBy(id = "ngb-nav-2")
    WebElement segmentLink;
    @FindBy(id = "ngb-nav-3")
    WebElement productsLink;
    @FindBy(id = "ngb-nav-4")
    WebElement trendsLink;
    @FindBy(id = "ngb-nav-5")
    WebElement demographicLink;
    @FindBy(id = "ngb-nav-6")
    WebElement targetAudienceLink;

    @FindBy(css = "[class='col-md-6 col-lg-6 bm-aligned-middle bm-mobile-aligned'] h5")
    //[contains(text(),'Customers at risk of churn')]
    WebElement customersAtChurnList;
    @FindBy(css = "[class='text-36 subheading mb-3 ng-star-inserted']")
    WebElement connectYourPlatformText;
    @FindBy(id = "dropdownBasic1")
    WebElement minimumPurchaseCountDropdown;

    public CustomerChurnPrediction(){
        PageFactory.initElements(driver, this);
    }
    public String verifyAIAnalyticsPageTitle() {
        return driver.getTitle();
    }

    public boolean validateAIAnalyticsHeader() {
        return analyticsLabel.isDisplayed();
    }

    public boolean validateAIAnalyticsText() {
        return businessOwnerID.isDisplayed();
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }
    public MyCustomers clickOnGoToMyCustomer() {
        navMyCustomersLink.click();
        return new MyCustomers();
    }
    public Integrations clickOnGoToIntegrations() {
        navIntegrationsLink.click();
        return new Integrations();
    }
    public Acoustic clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new Acoustic();
    }
    public Facebook clickOnGoToSocialAndDisplayAdvertising() {
        navSocialDisplayAdvertisingLink.click();
//        navFacebookAdvertisingLink.click();
        return new Facebook();
    }
    public Creatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new Creatives();
    }

    public boolean customersChurnListDisplay(){
        return customersAtChurnList.isDisplayed();
    }
    public String verifyCustomerChurnListHeaderName(){
        String text = customersAtChurnList.getText();
        System.out.println(text);
        return text;
    }
    public void clickOnExportSalesDataButton(){
        exportUnderlyingSalesDataButton.click();
    }
    public void exportUnderlyingSalesDataButtonHover(){
        Actions action = new Actions(driver);
        action.moveToElement(exportUnderlyingSalesDataButton);

    }
    public boolean customerNoDataInAIAnalyticsTextCheck(){
        return connectYourPlatformText.isDisplayed();
    }

    public Sales salesLinkClick(){
        salesLink.click();
        return new Sales();
    }
    public Segments segmentLinkClick(){
        segmentLink.click();
        return new Segments();
    }
    public Products productLinkClick(){
        productsLink.click();
        return new Products();
    }
    public Trends trendsLinkClick(){
        trendsLink.click();
        return new Trends();
    }
    public Demographic demographicLinkClick(){
        demographicLink.click();
        return new Demographic();
    }
    public TargetAudience targetAudienceLinkClick(){
        targetAudienceLink.click();
        return new TargetAudience();
    }
    public void changeTheMinimumPurchaseCount(String minimumPurchaseCountValue){
        Select minimumPurchaseCount = new Select(driver.findElement(By.id("dropdownBasic1")));
        minimumPurchaseCount.selectByValue(minimumPurchaseCountValue);
    }


}
