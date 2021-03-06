package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

public class SavingCalculatorTest extends TestBase {    /* trieda*/


    @Test
    public void itShouldDisplayTitle() {
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }
    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Hoggwart's Fund");
        driver.findElement(By.cssSelector("button.btn-block")).isEnabled();
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }
    @Test
    public void itShouldEnableApplyButton() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Hoggwart's Fund");
        //1. vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3. pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("35");
        //4. zadat email
        driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldNotSelecetAnyFundOnPage() {
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
        Assert.assertEquals("Select your fund",new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
    }


}
