package org.firehouse.MortarPages;


import org.firehouse.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends TestBase {
    //Page Factory - OR:
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    //    @FindBy(xpath = "//button[@type='submit']")
    @FindBy(id = "kc-login")
    WebElement loginBtn;
    @FindBy(id = "kc-page-title")
    WebElement loginPageTitle;
    @FindBy(xpath = "//h3[contains(text(),'Sign In')]")
    WebElement signUpText;

    @FindBy(xpath = "//img[contains(@class,'ui header ellipsis')]")
    WebElement mortarLogo;
    @FindBy(id = "input-error")
    WebElement spanErrorMessage;

    //Initializing Page Objects
    public Login() {
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String verifyLoginPageHeader() {
        return driver.getTitle();
    }

    public boolean verifyLogInPageHeader() {
        return loginPageTitle.isDisplayed();
    }

    public boolean verifyLoginPageLogo() {
        return mortarLogo.isDisplayed();
    }

    public boolean verifyLoginUserNameVisibility() {
        return username.isDisplayed();
    }

    public boolean verifyLoginPasswordVisibility() {
        return password.isDisplayed();
    }

    public boolean verifyLoginButton() {
        return loginBtn.isDisplayed();
    }

    public void verifyLoginButtonClickable() {
        loginBtn.click();
    }

    public Dashboard login(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return new Dashboard();
    }

    public BusinessOverview loginAsUser(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();
        return new BusinessOverview();
    }

    public boolean getErrorMessage() {
        return spanErrorMessage.isDisplayed();
    }


}

