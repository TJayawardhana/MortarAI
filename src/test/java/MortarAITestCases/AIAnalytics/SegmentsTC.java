package MortarAITestCases.AIAnalytics;


import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.AIAnalytics.Segments;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SegmentsTC extends TestBase {
    Login login;
    Dashboard dashboard;
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
    }

    @Test(priority = 1)
    public void segmentPageTitleTest() {
        String title = segments.verifyPageTitle();
        Assert.assertEquals(title, "Mortar - Web Portal", "Title is wrong");
        System.out.println("Correct Page Header");
    }

    @Test(priority = 2)
    public void verifiedOneOffIsEnabled() {
        boolean isDisable = segments.checkOneOffIsDisable();
        Assert.assertFalse(isDisable, "One-Off segment is Disable");

    }

    @Test(priority = 3)
    public void verifiedOneOffIsSelected() {
        boolean isSelected = segments.checkOneOffIsSelected();
        System.out.println(isSelected);
        Assert.assertTrue(isSelected, "One-Off segment is Not Selected");

    }

    @Test(priority = 4)
    public void verifySelectOneOffWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkOneOffIsDisable();
        boolean isSelected = segments.checkOneOffIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnOneOffTab();
        } else if (isSelected) {
            System.out.println("One-Off segment is Already selected");
        } else if (isDisable) {
            System.err.println("One-Off segment is Disable");
        }

    }

    @Test(priority = 5)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = segments.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed segment is Disable");
    }

    @Test(priority = 6)
    public void verifiedLapsedIsSelected() {
        boolean isSelected = segments.checkLapsedIsSelected();
        Assert.assertTrue(isSelected, "Lapsed segment is Not Selected");
    }

    @Test(priority = 7)
    public void verifySelectLapsedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segments.checkLapsedIsDisable();
        boolean isSelected = segments.checkLapsedIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnLapsedTab();
            Thread.sleep(5000);
        } else if (isSelected) {
            System.out.println("Lapsed segment is Already selected");
        } else if (isDisable) {
            System.err.println("Lapsed segment is Disable");
        }

    }

    @Test(priority = 8)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = segments.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant segment is Disable");
    }

    @Test(priority = 9)
    public void verifiedDormantIsSelected() {
        boolean isSelected = segments.checkDormantIsSelected();
        Assert.assertTrue(isSelected, "Dormant segment is Not Selected");
    }

    @Test(priority = 10)
    public void verifySelectDormantWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkDormantIsDisable();
        boolean isSelected = segments.checkDormantIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnDormantTab();
        } else if (isSelected) {
            System.out.println("Dormant segment is Already selected");
        } else if (isDisable) {
            System.err.println("Dormant segment is Disable");
        }

    }
    @Test(priority = 11)
    public void verifiedNewIsEnabled() {
        boolean isDisable = segments.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New segment is Disable");
    }

    @Test(priority = 12)
    public void verifiedNewIsSelected() {
        boolean isSelected = segments.checkNewIsSelected();
        Assert.assertTrue(isSelected, "New segment is Not Selected");
    }

    @Test(priority = 13)
    public void verifySelectNewWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkNewIsDisable();
        boolean isSelected = segments.checkNewIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnNewTab();
        } else if (isSelected) {
            System.out.println("New segment is Already selected");
        } else if (isDisable) {
            System.err.println("New segment is Disable");
        }

    }

    @Test(priority = 14)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = segments.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed segment is Disable");
    }

    @Test(priority = 15)
    public void verifiedCommittedIsSelected() {
        boolean isSelected = segments.checkCommittedIsSelected();
        Assert.assertTrue(isSelected, "Committed segment is Not Selected");
    }

    @Test(priority = 16)
    public void verifySelectCommittedWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkCommittedIsDisable();
        boolean isSelected = segments.checkCommittedIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnCommittedTab();
        } else if (isSelected) {
            System.out.println("Committed segment is Already selected");
        } else if (isDisable) {
            System.err.println("Committed segment is Disable");
        }
    }
    @Test(priority = 17)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = segments.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP segment is Disable");
    }

    @Test(priority = 18)
    public void verifiedVIPIsSelected() {
        boolean isSelected = segments.checkVIPIsSelected();
        Assert.assertTrue(isSelected, "VIP segment is Not Selected");
    }

    @Test(priority = 19)
    public void verifySelectVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkVIPIsDisable();
        boolean isSelected = segments.checkVIPIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnVIPTab();
        } else if (isSelected) {
            System.out.println("VIP segment is Already selected");
        } else if (isDisable) {
            System.err.println("VIP segment is Disable");
        }

    }
    @Test(priority = 20)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = segments.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP segment is Disable");
    }

    @Test(priority = 21)
    public void verifiedSporadicVIPIsSelected() {
        boolean isSelected = segments.checkSporadicVIPIsSelected();
        Assert.assertTrue(isSelected, "Sporadic VIP segment is Not Selected");
    }

    @Test(priority = 22)
    public void verifySelectSporadicVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkSporadicVIPIsDisable();
        boolean isSelected = segments.checkSporadicVIPIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnSporadicVIPTab();
        } else if (isSelected) {
            System.out.println("Sporadic VIP segment is Already selected");
        } else if (isDisable) {
            System.err.println("Sporadic VIP segment is Disable");
        }

    }


}

