package tc.AIAnalytics;


import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.AIAnalytics.CustomerChurnPrediction;
import org.firehouse.MortarPages.AIAnalytics.Sales;
import org.firehouse.MortarPages.AIAnalytics.Segments;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.firehouse.MortarPages.Navigation;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SegmentsTC extends TestBase {
    Login login;
    Navigation navigation;
    Dashboard dashboard;
    //ClientDashboard clientDashboard;
    BusinessOverview businessOverview;
    CustomerChurnPrediction customerChurnPrediction;
    Sales salesAIAnalytics;
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
        System.out.println("Title is match");
    }

//    @Test(priority = 2)
//    public void verifiedDownloadUnderlyingSalesData() throws InterruptedException, IOException {
//        Thread.sleep(15000);
//        segmentsAIAnalytics.clickOnExportUnderlyingSalesData();
//        Thread.sleep(5000);
//        checkDownloadedFiles(prop.getProperty("ExportUnderlyingSalesDataDownloadFileName"));
////        isFileDownloaded("Mortar_processed_sales_data",".csv",200);
//    }

    @Test(priority = 3)
    public void verifiedOneOffIsEnabled() {
        boolean isDisable = segments.checkOneOffIsDisable();
        Assert.assertFalse(isDisable, "One-Off is Disable");
        /*String isEnable = segmentsAIAnalytics.checkOneOffIsDisable();
        if(isEnable.equals("false")){
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.out.println(isEnable);
        System.err.println("One-Off is Disabled");*/

    }

    @Test(priority = 3)
    public void verifiedOneOffIsSelected() {
        boolean isSelected = segments.checkOneOffIsSelected();
        System.out.println(isSelected);
        Assert.assertTrue(isSelected, "One-Off is Not Selected");

    /*    String isEnable = segmentsAIAnalytics.checkOneOffIsSelected();
        if(isEnable.equals("false")){
            System.out.println(isEnable);
            System.out.println("One-Off is Enabled");
        }
        System.err.println("One-Off is Disabled");
    }*/
    }

    @Test(priority = 3)
    public void verifySelectOneOffWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkOneOffIsDisable();
        boolean isSelected = segments.checkOneOffIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnOneOffTab();
        } else if (isSelected) {
            System.out.println("One-Off is Already selected");
        } else if (isDisable) {
            System.err.println("One-Off is Disable");
        }

    }

    @Test(priority = 4)
    public void verifiedLapsedIsEnabled() {
        boolean isDisable = segments.checkLapsedIsDisable();
        Assert.assertFalse(isDisable, "Lapsed is Disable");
    }

    @Test(priority = 4)
    public void verifiedLapsedIsSelected() {
        boolean isSelected = segments.checkLapsedIsSelected();
        Assert.assertTrue(isSelected, "Lapsed is Not Selected");
    }

    @Test(priority = 4)
    public void verifySelectLapsedWhenNotSelectedAndEnabled() throws InterruptedException {
        boolean isDisable = segments.checkLapsedIsDisable();
        boolean isSelected = segments.checkLapsedIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnLapsedTab();
            Thread.sleep(5000);
        } else if (isSelected) {
            System.out.println("Lapsed is Already selected");
        } else if (isDisable) {
            System.err.println("Lapsed is Disable");
        }

    }

    @Test(priority = 5)
    public void verifiedDormantIsEnabled() {
        boolean isDisable = segments.checkDormantIsDisable();
        Assert.assertFalse(isDisable, "Dormant is Disable");
    }

    @Test(priority = 5)
    public void verifiedDormantIsSelected() {
        boolean isSelected = segments.checkDormantIsSelected();
        Assert.assertTrue(isSelected, "Dormant is Not Selected");
    }

    @Test(priority = 5)
    public void verifySelectDormantWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkDormantIsDisable();
        boolean isSelected = segments.checkDormantIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnDormantTab();
        } else if (isSelected) {
            System.out.println("Dormant is Already selected");
        } else if (isDisable) {
            System.err.println("Dormant is Disable");
        }

    }
    @Test(priority = 6)
    public void verifiedNewIsEnabled() {
        boolean isDisable = segments.checkNewIsDisable();
        Assert.assertFalse(isDisable, "New is Disable");
    }

    @Test(priority = 6)
    public void verifiedNewIsSelected() {
        boolean isSelected = segments.checkNewIsSelected();
        Assert.assertTrue(isSelected, "New is Not Selected");
    }

    @Test(priority = 6)
    public void verifySelectNewWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkNewIsDisable();
        boolean isSelected = segments.checkNewIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnNewTab();
        } else if (isSelected) {
            System.out.println("New is Already selected");
        } else if (isDisable) {
            System.err.println("New is Disable");
        }

    }

    @Test(priority = 7)
    public void verifiedCommittedIsEnabled() {
        boolean isDisable = segments.checkCommittedIsDisable();
        Assert.assertFalse(isDisable, "Committed is Disable");
    }

    @Test(priority = 7)
    public void verifiedCommittedIsSelected() {
        boolean isSelected = segments.checkCommittedIsSelected();
        Assert.assertTrue(isSelected, "Committed is Not Selected");
    }

    @Test(priority = 7)
    public void verifySelectCommittedWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkCommittedIsDisable();
        boolean isSelected = segments.checkCommittedIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnCommittedTab();
        } else if (isSelected) {
            System.out.println("Committed is Already selected");
        } else if (isDisable) {
            System.err.println("Committed is Disable");
        }
    }
    @Test(priority = 8)
    public void verifiedVIPIsEnabled() {
        boolean isDisable = segments.checkVIPIsDisable();
        Assert.assertFalse(isDisable, "VIP is Disable");
    }

    @Test(priority = 8)
    public void verifiedVIPIsSelected() {
        boolean isSelected = segments.checkVIPIsSelected();
        Assert.assertTrue(isSelected, "VIP is Not Selected");
    }

    @Test(priority = 8)
    public void verifySelectVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkVIPIsDisable();
        boolean isSelected = segments.checkVIPIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnVIPTab();
        } else if (isSelected) {
            System.out.println("VIP is Already selected");
        } else if (isDisable) {
            System.err.println("VIP is Disable");
        }

    }
    @Test(priority = 9)
    public void verifiedSporadicVIPIsEnabled() {
        boolean isDisable = segments.checkSporadicVIPIsDisable();
        Assert.assertFalse(isDisable, "Sporadic VIP is Disable");
    }

    @Test(priority = 9)
    public void verifiedSporadicVIPIsSelected() {
        boolean isSelected = segments.checkSporadicVIPIsSelected();
        Assert.assertTrue(isSelected, "Sporadic VIP is Not Selected");
    }

    @Test(priority = 9)
    public void verifySelectSporadicVIPWhenNotSelectedAndEnabled() {
        boolean isDisable = segments.checkSporadicVIPIsDisable();
        boolean isSelected = segments.checkSporadicVIPIsSelected();
        if (!isDisable && !isSelected) {
            segments.clickOnSporadicVIPTab();
        } else if (isSelected) {
            System.out.println("Sporadic VIP is Already selected");
        } else if (isDisable) {
            System.err.println("Sporadic VIP is Disable");
        }

    }


}

