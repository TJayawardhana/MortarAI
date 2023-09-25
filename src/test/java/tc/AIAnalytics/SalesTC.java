package tc.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.AIAnalytics.Sales;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.testng.Assert;
import org.testng.annotations.*;

public class SalesTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPrediction customerChurnPrediction;
    Sales sales;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        customerChurnPrediction = businessOverview.clickOnGoToCustomerChurnPredictionAIAnalytics();
        sales = customerChurnPrediction.salesLinkClick();
    }

    @Test(priority = 1)
    public void verifySalesAIAnalyticsTitle() {
        String title = sales.verifyMortarTitleSalesTab();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifiedAverageHourlySalesGraphHeader() {
        boolean isDisplaying = sales.verifyAverageHourlySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Hourly Sales Graph is not available");
    }

    @Test(priority = 3)
    public void verifiedAverageDailySalesGraphHeader() {
        boolean isDisplaying = sales.verifyAverageDailySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Daily Sales Graph is not available");
    }

    @Test(priority = 4)
    public void verifiedAverageMonthlySalesGraphHeader() {
        boolean isDisplaying = sales.verifyAverageMonthlySalesGraphHeader();
        Assert.assertTrue(isDisplaying, "Average Monthly sales graph is not available");
    }

    @Test(priority = 5)
    public void verifiedYearlySalesByQuarter() {
        boolean isDisplaying = sales.verifyYearlySalesByQuarter();
        Assert.assertTrue(isDisplaying, "Yearly Sales By Quarter graph is not available");
    }

    @Test(priority = 6)
    public void verifiedSelectedYear2020InYearlySalesByQuarter() throws InterruptedException {
        String value = sales.verifyValueYear2020InYearlySalesByQuarter();
        Thread.sleep(10000);
        Assert.assertEquals(value, "true", "Not selected 2020");
    }

    @Test(priority = 6)
    public void verifiedSelectedYear2021InYearlySalesByQuarter() {
        String value = sales.verifyValueYear2021InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2021");
    }

    @Test(priority = 6)
    public void verifiedSelectedYear2022InYearlySalesByQuarter() {
        String value = sales.verifyValue2022InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2022");
    }

    @Test(priority = 6)
    public void verifiedSelectedYear2023InYearlySalesByQuarter() {
        String value = sales.verifyValue2023InYearlySalesByQuarter();
        Assert.assertEquals(value, "true", "Not selected 2023");
    }

    @Test(priority = 7)
    public void verifiedSelectYear2020InYearlySalesByQuarterIfNotSelected() {
        String value = sales.verifyValueYear2020InYearlySalesByQuarter();
        if (value.equals("false")) {
            sales.verifySelectYear2020InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2020");
            System.out.println("Already selected 2020 in graph");
        }
    }

    @Test(priority = 7)
    public void verifiedSelectYear2021InYearlySalesByQuarterIfNotSelected() {
        String value = sales.verifyValueYear2021InYearlySalesByQuarter();
        if (value.equals("false")) {
            sales.verifySelectYear2021InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2021");
            System.out.println("Already selected 2021 in graph");
        }
    }

    @Test(priority = 7)
    public void verifiedSelectYear2022InYearlySalesByQuarterIfNotSelected() {
        String value = sales.verifyValue2022InYearlySalesByQuarter();
        if (value.equals("false")) {
            sales.verifySelect2022InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2022");
            System.out.println("Already selected 2022 in graph");
        }
    }

    @Test(priority = 7)
    public void verifiedSelectYear2023InYearlySalesByQuarterIfNotSelected() throws InterruptedException {
        String value = sales.verifyValue2023InYearlySalesByQuarter();
        if (value.equals("false")) {
            sales.verifySelect2023InYearlySalesByQuarter();
        } else {
            Assert.assertEquals(value, "true", "Not selected 2023");
            System.out.println("Already selected 2023 in graph");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
