package MortarAITestCases.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.*;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemographicTC extends TestBase {
    Login login;
    Dashboard dashboard;
    Demographic demographic;
    BusinessOverview businessOverview;
    CustomerChurnPrediction customerChurnPrediction;


    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPrediction = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        demographic = customerChurnPrediction.demographicLinkClick();
    }

    @Test(priority = 1)
    public void verifyDemographicPageHeader() {
        String title = demographic.verifyDemographicPageHeader();
        Assert.assertEquals(title, "Mortar - Web Portal", "Wrong page header");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}