package MortarAITestCases.EmailsAndJourneys;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.DigitalMediaBuying.CampaignReporting;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class KlaviyoTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;


    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        navigation.clickOnOpenSubMenuEmailsAndJourneys();
        navigation.clickOnGoToKlaviyoDashboardPage();
    }

    @Test(priority = 1)
    public void verifiedClickGoToKlaviyoDashboardInEmailsAndJourney() throws InterruptedException {
        navigation.clickOnOpenSubMenuEmailsAndJourneys();
        System.out.println("Navigate to Mails And Journeys Sub Menu ");
        Thread.sleep(5000);
        navigation.clickOnGoToKlaviyoDashboardPage();
        Thread.sleep(5000);
        System.out.println("Navigate to Klaviyo Dashboard Page in Emails And Journeys");
    }
}
