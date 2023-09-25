package tc.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.*;
import org.firehouse.MortarPages.*;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.testng.Assert;
import org.testng.annotations.*;

public class CustomerChurnPredictionTC extends TestBase {
    //NAV BAR
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    MyCustomers myCustomer;
    Integrations integrations;
    Facebook facebook;
    Creatives Creatives;
    //AI Analytics Page
    CustomerChurnPrediction customerChurnPrediction;
    Sales sales;
    Segments segments;
    Products products;
    Trends trends;
    Demographic demographic;
    TargetAudience targetAudience;

    public CustomerChurnPredictionTC() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPrediction = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
    }

    @Test(priority = 1)
    public void verifyingCustomersAtChurnListDisplay() {
//        testUtil.switchToFrame();
        try {
            boolean customerChurnTable = customerChurnPrediction.customersChurnListDisplay();
            Assert.assertTrue(customerChurnTable, "AI analytics Data is not available");
        } catch (Exception e) {
            boolean customerAiAnalyticsData = customerChurnPrediction.customerNoDataInAIAnalyticsTextCheck();
            Assert.assertTrue(customerAiAnalyticsData, "Error");
        }

    }

    @Test(priority = 2)
    public void verifiedCustomerAtChurnListHeader() {
        String heading = customerChurnPrediction.verifyCustomerChurnListHeaderName();
        Assert.assertEquals(heading, "Customers at risk of churn", "Customer at risk churn list header is not available");
    }

    @Test(priority = 2)
    public void verifyExportUnderlyingSalesData() {
        customerChurnPrediction.clickOnExportSalesDataButton();
    }

    @Test(priority = 5)
    public void verifySelectMinimumPurchaseCount() {
        String value = "5";
        customerChurnPrediction.changeTheMinimumPurchaseCount(value);
    }

    @Test(priority = 3)
    public void verifyGoToSalesPage() {
        sales = customerChurnPrediction.salesLinkClick();
    }

    @Test(priority = 4)
    public void verifyGoToSegmentsPage() {
        segments = customerChurnPrediction.segmentLinkClick();
    }

    @Test(priority = 5)
    public void verifyGoToProductsPage() {
        products = customerChurnPrediction.productLinkClick();
    }

    @Test(priority = 6)
    public void verifyGoToTrendsPage() {
        trends = customerChurnPrediction.trendsLinkClick();
    }

    @Test(priority = 7)
    public void verifyGoToDemographicsPage() {
        demographic = customerChurnPrediction.demographicLinkClick();
    }

    @Test(priority = 8)
    public void verifyGoToTargetAudience() {
        targetAudience = customerChurnPrediction.targetAudienceLinkClick();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

