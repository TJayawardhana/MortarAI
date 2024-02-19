package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.IntegrationPage;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.testng.Assert;
import org.testng.annotations.*;

public class IntegrationTC extends TestBase {

    Login login;
    Navigation navigationBar;
    Dashboard dashboard;
    BusinessOverview businessOverview;
    IntegrationPage integrationPage;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        integrationPage = navigationBar.clickOnGoToIntegrations();
    }

    @Test(priority = 1)
    public void IntegrationPageTitleTest() {
        String title = integrationPage.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

