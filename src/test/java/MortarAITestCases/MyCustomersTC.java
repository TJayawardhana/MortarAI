package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyCustomersTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    MyCustomers myCustomers;
    BusinessOverview businessOverview;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        myCustomers = navigation.clickOnGoToMyCustomer();
    }

    @Test(priority = 1)
    public void verifyClickGoToMyCustomerPageTest() throws InterruptedException {
        MyCustomers myCustomers = navigation.clickOnGoToMyCustomer();
        System.out.println("Navigate to My Customer");
        Thread.sleep(2000);
    }


}
