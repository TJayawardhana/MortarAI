package org.firehouse.MortarPages.AIAnalytics;

import org.firehouse.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales extends TestBase {
    //Graphs
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(1) [class='m-0 p-3 text-left dis-block']")
    WebElement averageHourlySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(2) [class='m-0 p-3 text-left dis-block']")
    WebElement averageDailySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(3) [class='m-0 p-3 text-left dis-block']")
    WebElement averageMonthlySalesGraphHeader;
    @FindBy(css = "[class] [class='col-xl-6 mb-4 ng-star-inserted']:nth-of-type(4) [class='m-0 p-3 text-left dis-block']")
    WebElement yearlySalesByQuarter;
    //Yearly Sales by Quarter Years Checkbox
    @FindBy(id = "year-2020")
    WebElement year2020CheckboxValue;
    @FindBy(id = "year-2021")
    WebElement year2021CheckboxValue;
    @FindBy(id = "year-2022")
    WebElement year2022CheckboxValue;
    @FindBy(id = "year-2023")
    WebElement year2023CheckboxValue;
    //    @FindBy(xpath = "(//span[@class='check__marked'])[1]")
    @FindBy(css = ".custom__checkboxes:nth-child(1)")
    WebElement year2020Checkbox;
    @FindBy(id = "year-2021")
    WebElement year2021Checkbox;
    @FindBy(id = "year-2022")
    WebElement year2022Checkbox;
    @FindBy(id = "year-2023")
    WebElement year2023Checkbox;
    public Sales() {
        PageFactory.initElements(driver, this);
    }
    public String verifyMortarTitleSalesTab() {
        return driver.getTitle();
    }
    public boolean verifyAverageHourlySalesGraphHeader(){
        return averageHourlySalesGraphHeader.isDisplayed();
    }
    public boolean verifyAverageDailySalesGraphHeader(){
        return averageDailySalesGraphHeader.isDisplayed();
    }
    public boolean verifyAverageMonthlySalesGraphHeader(){
        return averageMonthlySalesGraphHeader.isDisplayed();
    }
    public boolean verifyYearlySalesByQuarter(){
        return yearlySalesByQuarter.isDisplayed();
    }
    public String verifyValueYear2020InYearlySalesByQuarter(){
        return year2020CheckboxValue.getAttribute("value");
    }
    public String verifyValueYear2021InYearlySalesByQuarter(){
        return year2021CheckboxValue.getAttribute("value");
    }
    public String verifyValue2022InYearlySalesByQuarter(){
        return year2022CheckboxValue.getAttribute("value");
    }
    public String verifyValue2023InYearlySalesByQuarter(){
        return year2023CheckboxValue.getAttribute("value");
    }
    //
    public void verifySelectYear2020InYearlySalesByQuarter(){
        year2020Checkbox.click();
    }
    public void verifySelectYear2021InYearlySalesByQuarter(){
        year2021Checkbox.click();
    }
    public void verifySelect2022InYearlySalesByQuarter(){
        year2022Checkbox.click();
    }
    public void verifySelect2023InYearlySalesByQuarter(){
        year2023Checkbox.click();
    }
}
