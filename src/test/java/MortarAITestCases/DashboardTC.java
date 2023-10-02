package MortarAITestCases;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class DashboardTC extends TestBase {
    Login loginPage;
    Dashboard dashboardPage, dashboardPage1;
    TestUtil testUtil;
    BusinessOverview businessOverview;

    public DashboardTC() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod

    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        testUtil = new TestUtil();
        businessOverview = new BusinessOverview();
        loginPage = new Login();
        dashboardPage = loginPage.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
    }

    @Test(priority = 1)
    public void verifyDashboardPageTitleTest() {
        String title = dashboardPage.verifyMortarTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Wrong Home Page Header ");
    }

    @Test(priority = 2)
    public void verifyDashboardTextTest() {
//        testUtil.switchToFrame();
        Assert.assertTrue(dashboardPage.verifyDashboardText());
    }

    @Test(priority = 3)
    public void verifySearchABrandTest() {
        dashboardPage.searchABrand("B&M-SankaXYZ2");
    }

    @Test(priority = 4)
    public void verifyClickGoToBrandDashboardTest() {
//        testUtil.switchToFrame();
        businessOverview = dashboardPage.clickOnGoToClientsBusinessOverView();
    }

    @Test(priority = 5)
    public void verifySearchABrandAndGoToBrandDetails() {

        dashboardPage.searchABrand(prop.getProperty("brandName"));
        String searchedUser = dashboardPage.verifySearchedBrand();
        Assert.assertEquals(searchedUser, prop.getProperty("brandName"), "Wrong searched brand");
    }


    @Test(priority = 6)
    public void verifyStatusFilterSelectAllIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.selectAllIsSelected(), "Select All button is Not Selected");
    }

    @Test(priority = 7)
    public void verifyStatusFilterSetupRequiredIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Setup Required button is Not Selected");
    }

    @Test(priority = 8)
    public void verifyStatusFilterActiveIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.activeIsSelected(), "Active button is Not Selected");
    }

    @Test(priority = 9)
    public void verifyStatusFilterInactiveIsSelected() {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Inactive button is Not Selected");
    }

    @Test(priority = 10)
    public void verifyStatusFilterSelectAllTheSelectAllValues() throws InterruptedException {
        dashboardPage.clickStatusFilter();
        Assert.assertTrue(dashboardPage.selectAllIsSelected(), "Select All button is Not Selected");
        boolean selectAllStatus = dashboardPage.selectAllIsSelected();
        if (selectAllStatus) {
            Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Setup Required button is Not Selected");
            Assert.assertTrue(dashboardPage.activeIsSelected(), "Active button is Not Selected");
            Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Inactive button is Not Selected");
        }
    }
    @Test(priority = 11)
    public void verifyStatusFilterSelectAllDeselect() throws InterruptedException {
        dashboardPage.clickStatusFilter();
        boolean selectAllStatus = dashboardPage.selectAllIsSelected();
        if (selectAllStatus) {
            dashboardPage.clickOnSelectAllCheckBox();
            Assert.assertFalse(dashboardPage.selectAllIsSelected(), "Successfully Deselected the Select All CheckBox");
            Assert.assertFalse(dashboardPage.setupRequiredIsSelected(), "Successfully Deselected the Setup Required CheckBox");
            Assert.assertFalse(dashboardPage.activeIsSelected(), "Successfully Deselected the Active Checkbox");
            Assert.assertFalse(dashboardPage.inactiveIsSelected(), "Successfully Deselected the Inactive Checkbox");
        }
    }
    @Test(priority = 12)
    public void verifyStatusFilterOnlySetupRequiredDeselect() {
        dashboardPage.clickStatusFilter();
        boolean setupRequiredStatus = dashboardPage.setupRequiredIsSelected();
        if (setupRequiredStatus) {
            dashboardPage.clickOnSetupRequiredCheckbox();
            Assert.assertFalse(dashboardPage.selectAllIsSelected(), "Successfully Deselected the Select All CheckBox");
            Assert.assertFalse(dashboardPage.setupRequiredIsSelected(), "Successfully Deselected the Setup Required CheckBox");
            Assert.assertTrue(dashboardPage.activeIsSelected(), "Successfully Deselected the Active Checkbox");
            Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Successfully Deselected the Inactive Checkbox");
        }
    }
    @Test(priority = 13)
    public void verifyStatusFilterOnlyActiveDeselect() {
        dashboardPage.clickStatusFilter();
        boolean activeStatus = dashboardPage.activeIsSelected();
        if (activeStatus) {
            dashboardPage.clickOnActiveCheckbox();
            Assert.assertFalse(dashboardPage.selectAllIsSelected(), "Selected the Select All CheckBox");
            Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Selected the Setup Required CheckBox");
            Assert.assertFalse(dashboardPage.activeIsSelected(), "Selected the Active Checkbox");
            Assert.assertTrue(dashboardPage.inactiveIsSelected(), "Selected the Inactive Checkbox");
        }
    }
    @Test(priority = 14)
    public void verifyStatusFilterOnlyInactiveDeselect() {
        dashboardPage.clickStatusFilter();
        boolean inactiveStatus = dashboardPage.inactiveIsSelected();
        if(inactiveStatus){
            dashboardPage.clickOnInactiveCheckbox();
            Assert.assertFalse(dashboardPage.selectAllIsSelected(),"Selected the Select All CheckBox");
            Assert.assertTrue(dashboardPage.setupRequiredIsSelected(), "Selected the Setup Required CheckBox");
            Assert.assertTrue(dashboardPage.activeIsSelected(), "Selected the Active Checkbox");
            Assert.assertFalse(dashboardPage.inactiveIsSelected(), "Selected the Inactive Checkbox");
        }
    }

    @Test(priority = 15)
    public void verifiedPreviousDisableWhenLoggedIntoDashboard() throws InterruptedException {
        Thread.sleep(10000);
        try {
            boolean isUnclickable = dashboardPage.verifyPreviousButtonIsDisableInDashboardForFirstTime();
            Assert.assertTrue(isUnclickable, "Not in the first page when logged in the first time");
        }catch (Exception e){
            System.err.println("Not in the first page when logged in the first time");
        }
    }

    @Test(priority = 16)
    public void verifyNextButtonIsClickableWhenMultiplePagesAreAvailable() {
        boolean isUnclickable = dashboardPage.verifyNextButtonIsDisableInDashboardsLastPage();
        Assert.assertTrue(isUnclickable, "Next Button is not clickable ");
        dashboardPage.clickOnNextButtonOnPagination();
    }

    @Test(priority = 17)
    public void verifyNextButtonIsClickable() {
        dashboardPage.clickOnNextButtonOnPagination();

    }
    @Test(priority = 18)
    public void verifiedNavigateToAllPagesFromNavigation() throws InterruptedException {
        dashboardPage.verifyNavigateToAllAvailablePages();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}

