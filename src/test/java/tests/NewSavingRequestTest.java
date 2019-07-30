package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestments( "15000");
        calculatorPage.enterYears("35");
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");

        //precitat zo stranky totla income
        String CalculatedIncome = calculatorPage.getTotalIncome();

        // vytvorit novy saving request - kliknutie na enablovany button
        driver.findElement(By.cssSelector("button.btn-block")).click();

        //overit ze total incom sa zobrazi v requeste
       driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li/div"));
      //  System.out.println(driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li/div")).getText());

        System.out.println
                (driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li/div//div[contains(@class,'amounts')]/p/span")).getText());
        Assert.assertEquals(CalculatedIncome,
                driver.
                        findElement(By.xpath("//ul[contains(@class,'saving-list')]/li/div//div[contains(@class,'amounts')]/p/span"))
                        .getText());

        Assert.assertEquals(CalculatedIncome,
                driver.
                        findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span")).getText());
    }

    @Test
    public void itShouldDisplayFundInNewRequest() {


    }
}
