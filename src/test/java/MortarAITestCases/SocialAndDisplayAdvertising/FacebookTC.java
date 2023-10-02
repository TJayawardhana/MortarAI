package MortarAITestCases.SocialAndDisplayAdvertising;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.firehouse.MortarPages.SocialAndDisplayAdvertising.Facebook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FacebookTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;

    Facebook facebook;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        facebook = businessOverview.clickOnGoToFacebookAdvertisingPage();
    }

    @Test(priority = 1)
    public void verifyClickGoToFacebookAdvertisingPageTest() {
//        testUtil.switchToFrame();
        navigation.clickOnOpenSubMenuNavSocialDisplayAdvertising();
        facebook = businessOverview.clickOnGoToFacebookAdvertisingPage();
        System.out.println("Navigate to Facebook Advertising");
    }
}
