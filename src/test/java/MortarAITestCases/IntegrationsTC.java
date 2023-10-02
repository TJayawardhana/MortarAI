package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IntegrationsTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    Integrations integrations;
    BusinessOverview businessOverview;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        integrations = navigation.clickOnGoToIntegrations();
    }

    @Test(priority = 1)
    public void verifyClickGoToIntegrationsPageTest() throws InterruptedException {
//        testUtil.switchToFrame();
        Integrations integrations = navigation.clickOnGoToIntegrations();
        System.out.println("Navigate to Integrations");
        Thread.sleep(2000);
    }
}
