package org.firehouse.MortarPages;


import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.DigitalMediaBuying.CampaignReporting;
import org.firehouse.MortarPages.DigitalMediaBuying.CreateNewCampaign;
import org.firehouse.MortarPages.EmailsAndJourneys.Acoustic;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.GoogleAnalytics;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BusinessOverview extends TestBase {
    @FindBy(css = ".ng-star-inserted > .Overview")
    WebElement verifyBusinessOverviewPage;
    @FindBy(xpath = "//li[contains(text(),'B&M-SankaXYZ')]")
    WebElement businessOwnerID;
    //NAVBAR//////////////
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
//    @FindBy(xpath = "//span[contains(text(),'Emails & Journeys')]")
    @FindBy(xpath = "//li[5]/div")
    WebElement navEmailsAndJourneyLink;

    //Social & Display Advertising From Nav Bar
//    @FindBy(xpath = "//span[contains(text(),'Social & Display Advertising')]")
    @FindBy(css = "[data-intercom-target='Social \\& Display Advertising'] .nav-text")
    WebElement navSocialDisplayAdvertisingLink;
    @FindBy(css = "[href='\\/social-and-display-ads\\/facebook'] .item-name")
    WebElement navFacebookAdvertisingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement navGoogleAnalyticsPageLink;
    //Digital Media Buying From Nav Bar
    @FindBy(css = "[data-intercom-target='Digital Media Buying'] .nav-text")
    WebElement navDigitalMediaBuyingLink;
    @FindBy(css = "li:nth-of-type(1) > .ng-star-inserted > .item-name.lvl1")
    WebElement campaignReportingPageLink;
    @FindBy(css = ".childNav .ng-star-inserted:nth-of-type(2) .item-name")
    WebElement campaignCreatingPageLink;
    //My Creatives From Nav Bar
    @FindBy(xpath = "//span[contains(text(),'My Creatives')]")
    WebElement navMyCreativesLink;
    ///

    //PopUp
    @FindBy(css = "div[role='document'] img")
    WebElement userVerificationPopup;

    //Graphs
    @FindBy(xpath = "//h4[contains(text(),'Conversions')]")
    WebElement conversionGraphHeading;
    @FindBy(xpath = "//p[contains(text(),'Sales')]")
    WebElement salesGraphInConversionHeader;
    @FindBy(css = "[class='font-weight-bold font-size-topic mb-0 p-0']")
    WebElement mailingListSubscriptionGraphHeader;
    @FindBy(xpath = "//h4[contains(text(),'New Contacts')]")
    WebElement newContactsGraphHeading;
    @FindBy(xpath = "//h4[contains(text(),'Customers (Spenders)')]")
    WebElement customerSpendersGraphHeader;
    @FindBy(xpath = "//h4[contains(.,'Basket Summary')]")
    WebElement basketSummaryGraphHeader;
    @FindBy(xpath = "//h4[contains(.,'Best Performing Products')]")
    WebElement bestPerformingProductGraphHeader;

    ///
    @FindBy(css = "[class='d-flex w-100 resizing'] [class='card mb-4 ng-star-inserted']" +
            " [class='btn mx-1 form-control btn-gray dropdown-toggle text-left']")
    WebElement selectOptionDropDownInSalesGraph;
    //DATA
    //Sales Graph Data
    @FindBy(css = "[for='sales-woocommerce']")
    WebElement wooCommerceDataInSalesGraph;
    @FindBy(css = "[for='sales-myob']")
    WebElement myObDataInSalesGraph;
    @FindBy(css = "[for='sales-mailchimp']")
    WebElement mailChimpDataInSalesGraph;
    @FindBy(id="sales-woocommerce")
    WebElement checkBoxWooComInSales;
    @FindBy(id="sales-myob")
    WebElement checkBoxMyObInSales;
    //Mailing Graph Data
    @FindBy(css = ".card.mb-4.ng-star-inserted.pr-0 > .bg-white.card-footer > .row > .col-md-12 > .form-row > " +
            ".btn-group.col-md-12 > .btn.btn-gray.dropdown-toggle.form-control.mx-1.text-left")
    WebElement selectOptionDropdownMailingListSubscriptionGraph;
    @FindBy(css = "[for='mailing-omnisend']")
    WebElement omniSendDataInMailingGraph;
    @FindBy(css = "[for='mailing-woocommerce']")
    WebElement wooComDataInMailingGraph;
    @FindBy(css = "[for='mailing-myob']")
    WebElement myObDataInMailingGraph;
    @FindBy(css = "[for='mailing-mailchimp']")
    WebElement mailChimpInMailing;
    @FindBy(id="mailing-mailchimp")
    WebElement checkBoxMailChimpInMailingGraph;
    @FindBy(id = "mailing-woocommerce")
    WebElement checkBoxWooComInMailingGraph;
    @FindBy(id = "mailing-myob")
    WebElement checkBoxMyObInMailingGraph;
    //Best Performing Product graph

    @FindBy(id = "inlineRadio1")
    WebElement quantityRadioButtonInBestPerformanceGraph;
    @FindBy(id = "inlineRadio2")
    WebElement revenueRadioButtonInBestPerformanceGraph;


    public BusinessOverview() {
        PageFactory.initElements(driver, this);
    }
    public String validateBusinessOverviewPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyUserVerificationPopup() {
        return userVerificationPopup.isDisplayed();
    }

    public boolean verifyBusinessOverviewPageText() {
        return verifyBusinessOverviewPage.isDisplayed();
    }

    /*public boolean verifyClientName(String brandNameVerify) {
        WebElement verifyName = driver.findElement(By.xpath("//li[contains(text(),'" + brandNameVerify + "')]"));
        return verifyName.isDisplayed();
    }*/

    public boolean verifyBusinessOwnerID(String businessOwnerId) {
        return driver.findElement(By.xpath("//li[contains(" +
                "text(),'" + businessOwnerId + "')]")).isDisplayed();
    }

    public BusinessOverview clickOnGoToBusinessOverview() {
        navBusinessOverviewLink.click();
        return new BusinessOverview();
    }

    public CustomerChurnPrediction clickOnGoToCustomerChurnPredictionAIAnalytics() {
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

    public Acoustic clickOnGoToEmailsAndJourneys() {
        navEmailsAndJourneyLink.click();
        return new Acoustic();
    }

    public void clickOnNavSocialDisplayAdvertisingLink() {
        navSocialDisplayAdvertisingLink.click();
    }

    public Facebook clickOnGoToFacebookAdvertisingPage() {
        navSocialDisplayAdvertisingLink.click();
        navFacebookAdvertisingPageLink.click();
        return new Facebook();
    }

    public GoogleAnalytics clickOnGoToAIAnalytics() {
        navSocialDisplayAdvertisingLink.click();
        navGoogleAnalyticsPageLink.click();
        return new GoogleAnalytics();
    }

    public void clickOnNavDigitalMediaBuying() {
        navDigitalMediaBuyingLink.click();
    }

    public CampaignReporting clickOnGoToCampaignReportingPage() {
        navDigitalMediaBuyingLink.click();
        campaignReportingPageLink.click();
        return new CampaignReporting();
    }

    public CreateNewCampaign clickOnGoToCreatNewCampaignPage() {
        navDigitalMediaBuyingLink.click();

        campaignCreatingPageLink.click();
        return new CreateNewCampaign();
    }

    public Creatives clickOnGoToMyCreatives() {
        navMyCreativesLink.click();
        return new Creatives();
    }

    public boolean verifyConversionGraphHeader() {
        return conversionGraphHeading.isDisplayed();
    }


    public boolean verifySalesGraphInConversionHeader() {
        return salesGraphInConversionHeader.isDisplayed();
    }

    public boolean verifyMailingListSubscriptionGraphInConversionHeader() {

        return mailingListSubscriptionGraphHeader.isDisplayed();
    }

    public boolean verifyNewContactGraph() {
        return newContactsGraphHeading.isDisplayed();
    }

    public boolean verifyCustomerSpendersGraphHeading() {
        return customerSpendersGraphHeader.isDisplayed();
    }

    public boolean verifyBasketSummaryGraphHeading() {
        return basketSummaryGraphHeader.isDisplayed();
    }


    public boolean verifyBestPerformingProductGraphHeading() {
        return bestPerformingProductGraphHeader.isDisplayed();
    }

    //Sales Graph
    public void verifyClickOnSelectOptionDropDown() {
        selectOptionDropDownInSalesGraph.click();
    }

    public boolean verifyWooComIsInSalesDataGraph() {
        return wooCommerceDataInSalesGraph.isDisplayed();

    }

    public boolean verifyMyObIsInSalesDataGraph() {
        return myObDataInSalesGraph.isDisplayed();
    }
    public boolean verifyWooComCheckBoxCheckedInSales() {
        return checkBoxWooComInSales.isSelected();
    }
    public boolean verifyMyObCheckBoxCheckedSales() {
        return checkBoxMyObInSales.isSelected();
    }
    public boolean verifyUnselectWooComCheckBox(){
        wooCommerceDataInSalesGraph.click();
        return checkBoxWooComInSales.isSelected();

    }
    public boolean verifyUnselectMyObCheckBox(){
        myObDataInSalesGraph.click();
        return checkBoxMyObInSales.isSelected();
    }

    //Mailing List Subscription
    public void verifyClickOnSelectOptionDropdownInMailing(){
        selectOptionDropdownMailingListSubscriptionGraph.click();
    }
    public boolean verifyWooComDataInMailingGraph(){
        return wooComDataInMailingGraph.isDisplayed();
    }

    public boolean verifyMyObDataInMailing(){
        return myObDataInMailingGraph.isDisplayed();
    }
    public boolean verifyOmniSendDataInMailing(){
        return omniSendDataInMailingGraph.isDisplayed();
    }
    public boolean verifyWooComCheckBoxCheckedInMailing() {
        return checkBoxWooComInMailingGraph.isSelected();
    }
    public boolean verifyMyObCheckBoxCheckedMailing() {
        return checkBoxMyObInMailingGraph.isSelected();
    }

    //Best Performing Product graph

    public boolean verifyBestPerformingProductsInQuantity(){
        return quantityRadioButtonInBestPerformanceGraph.isSelected();
    }
    public boolean verifyBestPerformingProductsInRevenue(){
        return revenueRadioButtonInBestPerformanceGraph.isSelected();
    }

    public void verifyQuantityRadioButtonClick(){
        quantityRadioButtonInBestPerformanceGraph.click();
    }
    public void verifyRevenueRadioButtonClick(){
        revenueRadioButtonInBestPerformanceGraph.click();

    }
}

