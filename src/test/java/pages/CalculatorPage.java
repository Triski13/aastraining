package pages;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CalculatorPage {


    private WebDriver pageDriver;

    public CalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public String getTotalIncome() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")
        ).getText();
    }

    public String getInterestIncome() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }

    public String getRisk() {
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }

    public void enterInvestments(String amountToEnter) {
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).clear();
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    public void enterYears(String yearsToEnter) {
        pageDriver.findElement(By.id("yearsInput")).clear();
        pageDriver.findElement(By.id("yearsInput")).sendKeys(yearsToEnter);
    }

    public void submitRequest() {
        pageDriver.findElement(By.cssSelector("button.btn-block")).click();
    }

    public void enterEmail(String yearsToEnter) {
        pageDriver.findElement(By.id("emailInput")).clear();
        pageDriver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");

    }

    public void selectFund(String fundToSelect) {  //viditelna metoda len pre tuto triedu
        //void - nevrati ziadnu hodnotu, len niekde  klikne...

        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    public WebElement getFirstSavingDetail(String s) {
        return pageDriver.findElement(By.cssSelector(s));
    }
}
