package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;

public class NewSavingRequestTest extends TestBase {

    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestments("15000");
        calculatorPage.enterYears("35");
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");

        //precitat zo stranky total income
        String CalculatedIncome = calculatorPage.getTotalIncome();

        // vytvorit novy saving request - kliknutie na enablovany button
        calculatorPage.getFirstSavingDetail("button.btn-block").click();

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
                calculatorPage.getFirstSavingDetail("ul.saving-list > li div.amounts > p > span").getText());
    }

    @Test
    public void itShouldDisplayFundInNewRequest() {
        String selectedFundName = "Death Star real estate";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund(selectedFundName);
        calculatorPage.enterInvestments("15000");
        calculatorPage.enterYears("35");
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");
        calculatorPage.submitRequest();
        calculatorPage.selectFund(selectedFundName);
        calculatorPage.getFirstSavingDetail("button.btn-block").click();

        //Vytiahnem fond zo stranky
        String displayedFund = calculatorPage.getFirstSavingDetail("ul.saving-list > li >div.saving-detail")
                .findElement(By.cssSelector("p.fund-description")).getText();
//porovnam zadany fond s ten ktory som vytiahol zo stranky

        /* Assert.assertEquals(selectedFundName, displayedFund);*/
        Assert.assertEquals(selectedFundName,(calculatorPage.getFirstSavingDetail("ul.saving-list > li >div.saving-detail")
        .findElement(By.cssSelector("p.fund-description")).getText()));


    }


}
