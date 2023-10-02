package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.*;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.DigitalMediaBuying.CampaignReporting;
import org.firehouse.MortarPages.DigitalMediaBuying.CreateNewCampaign;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.GoogleAnalytics;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NavigationTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;
    MyCustomers myCustomer;
    Integrations integrations;
    Facebook facebook;
    GoogleAnalytics googleAnalytics;
    CampaignReporting campaignReporting;
    CreateNewCampaign createNewCampaign;
    Creatives myCreatives;
    CustomerChurnPrediction customerChurnPrediction;
    public NavigationTC() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        navigation = new Navigation();
        Thread.sleep(5000);
    }

    @Test(priority = 1)
    public void BusinessOverviewPageTitleTest() {
        String title = businessOverview.validateBusinessOverviewPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyNavigationBarIsAvailable() throws InterruptedException {
        Thread.sleep(2000);
        boolean isAvailable = navigation.verifyNavigationBarIsAvailable();
        Assert.assertTrue(isAvailable, "Navigation bar is Not Available");
    }

    @Test(priority = 3)
    public void verifiedGoToBusinessOverview() {
        businessOverview = navigation.clickOnGoToBusinessOverview();
        System.out.println("Navigate To Business Overview");
    }

    @Test(priority = 4)
    public void verifiedGoToAIAnalytics() throws InterruptedException {
        Thread.sleep(2000);
        customerChurnPrediction = navigation.clickOnGoToCustomerChurnPrediction();
        System.out.println("Navigate to Customer Churn Prediction AI Analytics");
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    public void verifyClickGoToMyCustomerPageTest() throws InterruptedException {
        myCustomer = navigation.clickOnGoToMyCustomer();
        System.out.println("Navigate to My Customer");
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void verifyClickGoToIntegrationsPageTest() throws InterruptedException {
        integrations = navigation.clickOnGoToIntegrations();
        System.out.println("Navigate to Integrations");
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void verifyClickToOpenSubMenuEmailsAndJourneysPageTest() throws InterruptedException {
        navigation.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
    }
    @Test(priority = 9)
    public void verifiedClickToGoToSingleMailingInEmailsAndJourney() throws InterruptedException {
        navigation.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
        navigation.clickOnGoToSingleMailingInEmailsAndJourneyPage();
        Thread.sleep(5000);
        System.out.println("Navigate to Single Mailing Page in Mails And Journeys");
    }
    @Test(priority = 10)
    public void verifiedClickGoToKlaviyoDashboardInEmailsAndJourney() throws InterruptedException {
        navigation.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
        navigation.clickOnGoToKlaviyoDashboardPage();
        Thread.sleep(5000);
        System.out.println("Navigate to Klaviyo Dashboard Page in Emails And Journeys");
    }


    @Test(priority = 11)
    public void VerifyOpeningSocialDisplayAdvertisingSubNavBar() {
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        System.out.println("Navigate to Social Display Advertising Sub Navigation Bar");
    }

    @Test(priority = 12)
    public void verifyClickGoToFacebookAdvertisingPageTest() {
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        facebook = businessOverview.clickOnGoToFacebookAdvertisingPage();
        System.out.println("Navigate to Facebook Advertising");
    }

    @Test(priority = 13)
    public void verifyClickGoToGoogleAnalyticsPageTest() {
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        googleAnalytics = navigation.clickOnGoToGoogleAnalyticsReportingPage();
        System.out.println("Navigate to Google Analytics Reporting");
    }

    @Test(priority = 14)
    public void VerifyOpeningDigitalMediaBuyingSubNavBar() {
        navigation.clickOnNavDigitalMediaBuying();
        System.out.println("Navigate to Digital Media Buying Sub Navigation Bar");
    }

    @Test(priority = 15)
    public void verifyClickGoToCampaignReportingPageTest() {
        navigation.clickOnNavDigitalMediaBuying();
        campaignReporting = navigation.clickOnGoToCampaignReportingPage();
        System.out.println("Navigate to Campaign Reporting");
    }

    @Test(priority = 16)
    public void verifyClickGoToCreateACampaignPageTest() {
        navigation.clickOnNavDigitalMediaBuying();
        createNewCampaign = navigation.clickOnGoToCreateNewCampaignPage();
        System.out.println("Navigate to Create New CampaignPage");
    }

    @Test(priority = 17)
    public void verifyClickGoToMyCreativesTest() {
        myCreatives = navigation.clickOnGoToMyCreatives();
        System.out.println("Navigate to My Creatives");
    }


}

