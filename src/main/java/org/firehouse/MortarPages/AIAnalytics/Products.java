package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class Products extends TestBase {
    public Products() {PageFactory.initElements(driver, this);}
    public String verifyProductsPageHeader() {return driver.getTitle();}


    }

