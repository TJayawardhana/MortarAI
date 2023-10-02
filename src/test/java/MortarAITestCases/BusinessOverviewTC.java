package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.*;
import org.firehouse.MortarPages.DigitalMediaBuying.CampaignReporting;
import org.firehouse.MortarPages.DigitalMediaBuying.CreateNewCampaign;
import org.firehouse.MortarPages.EmailsAndJourneys.Acoustic;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.GoogleAnalytics;
import org.testng.Assert;
import org.testng.annotations.*;

public class BusinessOverviewTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;
    MyCustomers myCustomer;
    Integrations integrations;

    Acoustic acoustic;
    Facebook facebook;
    GoogleAnalytics googleAnalytics;
    CampaignReporting campaignReporting;
    CreateNewCampaign createNewCampaign;
    Creatives Creatives;
    CustomerChurnPrediction customerChurnPrediction;

    public BusinessOverviewTC() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = businessOverview.validateBusinessOverviewPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyBusinessOverviewPage() {

        boolean businessOverviewPageText = businessOverview.verifyBusinessOverviewPageText();
        Assert.assertTrue(businessOverviewPageText, "Not in the Business Overview Page");

    }

    @Test(priority = 3)
    public void verifyBusinessOwnerIDTest() {
        Assert.assertTrue(businessOverview.verifyBusinessOwnerID(prop.getProperty("brandName")));
    }

    @Test(priority = 4)
    public void verifyClickGoToBusinessOverviewPageTest() {
        businessOverview = businessOverview.clickOnGoToBusinessOverview();
    }

    @Test(priority = 5)
    public void verifyAIAnalyticsPageTest() {
        customerChurnPrediction = navigation.clickOnGoToCustomerChurnPrediction();
    }

    @Test(priority = 6)
    public void verifyClickGoToMyCustomerPageTest() {
        myCustomer = navigation.clickOnGoToMyCustomer();
    }

    @Test(priority = 7)
    public void verifyClickGoToIntegrationsPageTest() {
        integrations = businessOverview.clickOnGoToIntegrations();
    }

    @Test(priority = 8)
    public void verifyClickGoToEmailsAndJourneysPageTest() {
        acoustic = businessOverview.clickOnGoToEmailsAndJourneys();
    }

    @Test(priority = 9)
    public void VerifyOpeningSocialDisplayAdvertisingSubNavBar() {
        businessOverview.clickOnNavSocialDisplayAdvertisingLink();
    }

    @Test(priority = 10)
    public void verifyClickGoToFacebookAdvertisingPageTest() {
        facebook = businessOverview.clickOnGoToFacebookAdvertisingPage();
    }

    @Test(priority = 11)
    public void verifyClickGoToGoogleAnalyticsPageTest() {
        googleAnalytics = businessOverview.clickOnGoToAIAnalytics();
    }

    @Test(priority = 12)
    public void VerifyOpeningDigitalMediaBuyingSubNavBar() {
        businessOverview.clickOnNavDigitalMediaBuying();
    }

    @Test(priority = 13)
    public void verifyClickGoToCampaignReportingPageTest() {
        campaignReporting = businessOverview.clickOnGoToCampaignReportingPage();
    }

    @Test(priority = 14)
    public void verifyClickGoToCreateACampaignPageTest() {
        createNewCampaign = businessOverview.clickOnGoToCreatNewCampaignPage();
    }

    @Test(priority = 15)
    public void verifyClickGoToMyCreativesTest() {
        Creatives = businessOverview.clickOnGoToMyCreatives();
    }


    //Verify Graphs Available
    @Test(priority = 16)
    public void verifiedConversionGraphsHeading() {
        Assert.assertTrue(businessOverview.verifyConversionGraphHeader(), "Conversion graph  not displaying");
    }

    @Test(priority = 17)
    public void verifiedSalesGraphInConversionHeading() {

        Assert.assertTrue(businessOverview.verifySalesGraphInConversionHeader(), "Sales Graph not displaying");
    }

    @Test(priority = 18)
    public void verifiedMailingListSubscriptionGraphInHeading() {

        Assert.assertTrue(businessOverview.verifyMailingListSubscriptionGraphInConversionHeader(), "Mailing List " +
                "Subscription Graph is Not displaying");

    }

    @Test(priority = 19)
    public void verifiedNewContactGraphHeading() {

        String errorMessage = "New Contact Graph not displaying";
        Assert.assertTrue(businessOverview.verifyNewContactGraph(), "New Contact graph is not displaying");

    }

    @Test(priority = 20)
    public void verifiedCustomerSpendersGraphHeading() {

        String errorMessage = "Customer(Spenders) Graph not displaying";
        Assert.assertTrue(businessOverview.verifyCustomerSpendersGraphHeading(), errorMessage);
    }

    @Test(priority = 21)
    public void verifiedBasketSummaryGraphHeading() {

        Assert.assertTrue(businessOverview.verifyBasketSummaryGraphHeading(), "Basket Summary is " +
                "Graph not displaying");
    }

    @Test(priority = 22)
    public void verifiedBestPerformingProductGraphHeading() {
        Assert.assertTrue(businessOverview.verifyBestPerformingProductGraphHeading(), "Best " +
                "performing product is Graph not displaying");
    }

    //Sales Graph
    @Test(priority = 23)
    public void verifiedWooComDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyWooComIsInSalesDataGraph(), "Woocommerce Data is not " +
                "Available in Sales graph");

    }

    @Test(priority = 24)
    public void verifiedMyObDataInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();

        Assert.assertTrue(businessOverview.verifyMyObIsInSalesDataGraph(), "Myob Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 25)
    public void verifiedMailChimpInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyMyObIsInSalesDataGraph(), "Myob Data is not " +
                "Available in Sales graph");

    }

    @Test(priority = 26)
    public void verifiedWooComDataIsSelectedInSalesGraph() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Assert.assertTrue(businessOverview.verifyWooComCheckBoxCheckedInSales(), "Woocommerce Data is not " +
                "Selected in Sales graph");
    }

    @Test(priority = 27)
    public void verifiedMyObDataIsSelectedInSalesGraph() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropDown();
        Thread.sleep(2000);
        boolean isSelected = businessOverview.verifyMyObCheckBoxCheckedSales();
        Assert.assertTrue(isSelected, "Myob Data is not " +
                "Selected in Sales graph");
    }

    @Test(priority = 28)
    public void verifiedUnselectWooComDataInSales() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        boolean isSelected = businessOverview.verifyUnselectWooComCheckBox();
        Assert.assertFalse(isSelected, "Woocommerce data is checkbox didnt unselected");
    }

    @Test(priority = 29)
    public void verifiedUnselectMyObDataInSales() {
        businessOverview.verifyClickOnSelectOptionDropDown();
        boolean isSelected = businessOverview.verifyUnselectMyObCheckBox();
        Assert.assertFalse(isSelected, "Myob data is checkbox didnt unselected");
    }

    //Mailing List Subscription Graph
    @Test(priority = 30)
    public void verifiedWooComDataInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyWooComDataInMailingGraph(), "Woocommerce Data is not " +
                "Available in Mailing graph");
    }

    @Test(priority = 31)
    public void verifiedMyObDataInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyMyObDataInMailing(), "Myob Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 32)
    public void verifiedOmniSendInMailing() {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Assert.assertTrue(businessOverview.verifyOmniSendDataInMailing(), "Omnisend Data is not " +
                "Available in Sales graph");
    }

    @Test(priority = 33)
    public void verifiedWooComDataIsSelectedInMailing() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Thread.sleep(2500);
        Assert.assertTrue(businessOverview.verifyWooComCheckBoxCheckedInMailing(), "Woocommerce Data is not " +
                "Selected in Mailing graph");
    }

    @Test(priority = 34)
    public void verifiedMyObDataIsSelectedInMailing() throws InterruptedException {
        businessOverview.verifyClickOnSelectOptionDropdownInMailing();
        Thread.sleep(2000);
        boolean isSelected = businessOverview.verifyMyObCheckBoxCheckedMailing();
        Assert.assertTrue(isSelected, "Myob Data is not " +
                "Selected in Mailing graph");

    }
    @Test(priority = 35)
    public void verifiedBestPerformingProductsIsInQuantity() {
        boolean isSelect = businessOverview.verifyBestPerformingProductsInQuantity();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Quantity");
    }
    @Test(priority = 36)
    public void verifiedBestPerformingProductsIsInRevenue() {
        boolean isSelect = businessOverview.verifyBestPerformingProductsInRevenue();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Revenue");
    }
    @Test(priority = 37)
    public void verifiedSelectBestPerformingProductsToQuantity() {
        businessOverview.verifyQuantityRadioButtonClick();
        boolean isSelect = businessOverview.verifyBestPerformingProductsInQuantity();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Quantity");
    }
    @Test(priority = 38)
    public void verifiedSelectBestPerformingProductsToRevenue() {
        businessOverview.verifyRevenueRadioButtonClick();
        boolean isSelect = businessOverview.verifyBestPerformingProductsInRevenue();
        Assert.assertTrue(isSelect,"Best Performing Products data are not in Revenue");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

