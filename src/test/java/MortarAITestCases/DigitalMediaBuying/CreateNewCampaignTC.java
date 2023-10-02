package MortarAITestCases.DigitalMediaBuying;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.DigitalMediaBuying.CreateNewCampaign;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateNewCampaignTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    BusinessOverview businessOverview;

    CreateNewCampaign createNewCampaign;

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws InterruptedException {
        initialization(browser);
        login = new Login();
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
        businessOverview = dashboard.searchABrandAndGoToBusinessOverview(prop.getProperty("brandName"));
    }

    @Test(priority = 1)
    public void verifyClickGoToCreateACampaignPageTest() {
//        testUtil.switchToFrame();
        navigation.clickOnNavDigitalMediaBuying();
        createNewCampaign = navigation.clickOnGoToCreateNewCampaignPage();
        System.out.println("Navigate to Create New CampaignPage");
    }

}
