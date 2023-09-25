package tc;

import org.firehouse.Base.TestBase;
import org.firehouse.MortarPages.BusinessOverview;
import org.firehouse.MortarPages.Dashboard;
import org.firehouse.MortarPages.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTC extends TestBase {
    Login login;
    Dashboard dashboard;
    BusinessOverview businessOverview;

    private static final Logger logger = LoggerFactory.getLogger(LoginTC.class);

    public LoginTC() {
        super();
    }

    @Parameters({"browser.name"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        initialization(browser);
        login = new Login();
    }

    int x = 1;

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = login.verifyLoginPageHeader();
        Assert.assertEquals(title, "Sign in to mortar", "Title is wrong");
    }

    @Test(priority = 2)
    public void verifyLoginPageHeader(){
        boolean header = login.verifyLogInPageHeader();
        Assert.assertTrue(header,"Login page header title is not available");
    }

    @Test(priority = 3)
    public void verify (){
        Assert.assertTrue(login.verifyLoginUserNameVisibility(),"UserName Field is Not Visible");
    }
    @Test(priority = 4)
    public void verifyPasswordInputFieldIsVisible(){
        Assert.assertTrue(login.verifyLoginPasswordVisibility(),"Password Field is Not Visible");
    }
    @Test(priority = 5)
    public void verifyLoginButtonIsVisible(){
        Assert.assertTrue(login.verifyLoginButton(),"Password Field is Not Visible");
    }
    @Test(priority = 6)
    public void verifyLoginButtonClickable(){
        login.verifyLoginButtonClickable();
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Login failed! Please check your username and password and try again.");
    }
    @Test(priority = 7)
    public void accountManagerLoginWithValidCredentialsTest() {
        dashboard = login.login(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));}

    @Test(priority = 8)
    public void accountManagerLoginWithInvalidEmailCredentials() {
        String invalidEmail = "Sankaw233@dmk";
        login.login(invalidEmail, prop.getProperty("AdminPassword"));
      /*  loginPage.getErrorMessage();
        System.out.println("Login Error");*/
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
//        Assert.assertTrue(loginPage.getErrorMessage(),"Login failed! Please check your username and password and try again.");
    }

    @Test(priority = 9)
    public void accountManagerLoginWithInvalidPasswordCredentials() {
        String invalidPassword = "Sankaw233@dmk";
        login.login(prop.getProperty("AdminUsername"), invalidPassword);
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");

    }

    @Test(priority = 10)
    public void businessOwnerLoginWithValidCredentials() throws InterruptedException {
        businessOverview = login.loginAsUser(prop.getProperty("Username"), prop.getProperty("Password"));
        Thread.sleep(5000);
        boolean popupVerify = businessOverview.verifyUserVerificationPopup();
        Assert.assertTrue(popupVerify,"User verify Popup didn't Showed");

    }

    @Test(priority = 11)
    public void businessOwnerLoginWithInvalidPasswordCredentials() {
        String invalidPassword = "Sankaw233@dmk";
        businessOverview = login.loginAsUser(prop.getProperty("Username"), invalidPassword);
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg,"Error Message not popped up");
    }

    @Test(priority = 12)
    public void businessOwnerLoginWithInvalidEmailCredentials() {
        String invalidEmail = "Sankaw233@dmk";
        businessOverview = login.loginAsUser(prop.getProperty("Username"), invalidEmail);
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }

    @Test(priority = 13)
    public void loginWithEmptyEmailCredentials() {
        String invalidEmail = "";
        businessOverview = login.loginAsUser(invalidEmail, prop.getProperty("Password"));
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");

    }

    @Test(priority = 14)
    public void loginWithEmptyPasswordCredentials() {
        String invalidPassword = "";
        businessOverview = login.loginAsUser(prop.getProperty("Username"), invalidPassword);
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }

    @Test(priority = 15)
    public void loginWithEmptyCredentials() {
        String invalidEmail = "";
        String invalidPassword = "";
        businessOverview = login.loginAsUser(invalidEmail, invalidPassword);
        boolean errorMsg = login.getErrorMessage();
        Assert.assertTrue(errorMsg, "Error Message not popped up");
    }


    @AfterMethod
    public void tearDown() {
        logger.info("All the test cases of LoginPageTest.class have been executed");
        driver.close();
    }
}

