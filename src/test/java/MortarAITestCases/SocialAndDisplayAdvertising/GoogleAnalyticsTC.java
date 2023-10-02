package MortarAITestCases.SocialAndDisplayAdvertising;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.GoogleAnalytics;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleAnalyticsTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;
    GoogleAnalytics googleAnalytics;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        googleAnalytics = navigation.clickOnGoToGoogleAnalyticsReportingPage();
    }

    @Test(priority = 1)
    public void verifyClickGoToGoogleAnalyticsPageTest() {
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        googleAnalytics = navigation.clickOnGoToGoogleAnalyticsReportingPage();
        System.out.println("Navigate to Google Analytics Reporting");
    }
}
