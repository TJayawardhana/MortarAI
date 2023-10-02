package MortarAITestCases.AIAnalytics;


import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.AIAnalytics.Products;
import org.firehouse.MortarPages.AIAnalytics.Segments;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductsTC extends TestBase {
    Login login;
    Dashboard dashboard;
    Products products;
    BusinessOverview businessOverview;
    CustomerChurnPrediction customerChurnPrediction;
    Segments segments;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPrediction = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        segments = customerChurnPrediction.segmentLinkClick();
        products = customerChurnPrediction.productLinkClick();
    }

    @Test(priority = 1)
    public void verifyProductsPageHeader() {
        String title = products.verifyProductsPageHeader();
        Assert.assertEquals(title, "Mortar - Web Portal", "Wrong page header");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}