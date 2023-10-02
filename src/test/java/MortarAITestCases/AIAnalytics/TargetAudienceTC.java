package MortarAITestCases.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.*;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.testng.Assert;
import org.testng.annotations.*;

public class TargetAudienceTC extends TestBase {
    Login login;
    Dashboard dashboard;
    TargetAudience targetAudience;
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
        targetAudience = customerChurnPrediction.targetAudienceLinkClick();
    }

    @Test(priority = 1)
    public void verifyTrendsPageHeader() {
        String title = targetAudience.verifyTargetAudiencePageHeader();
        Assert.assertEquals(title, "Mortar - Web Portal", "Wrong page header");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
