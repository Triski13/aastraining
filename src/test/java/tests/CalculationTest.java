package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {



    @Test
    public void itShouldCalculateTotalIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Hoggwart's Fund");


        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
                       //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        calculatorPage.enterInvestments("20");
        //3. pocet rokov
        calculatorPage.enterYears("20");
        //4. zadat email
        calculatorPage. enterEmail( "peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty();

        //2. Overit ze totoal income nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Hoggwart's Fund");

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond

        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        calculatorPage.enterInvestments( "20");
        //3. pocet rokov
        calculatorPage.enterYears("20");
        //4. zadat email
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
//2. overit ze interest Incom nie je prazdny
        Assert.assertFalse(calculatorPage.getInterestIncome().isEmpty());
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));

    }

    @Test
    public void itShouldCalculateRisk() {

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        calculatorPage.enterInvestments( "20");
        //3. pocet rokov
        calculatorPage.enterYears("20");
        //4. zadat email
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        // 2. overit ze risk nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
        Assert.assertFalse(calculatorPage.getRisk().isEmpty());
    }

@Test
public void iTShlouldCalculateTotalIncomeForEachFund (){

        String[] arayOfFunds = {"Fellowship investment group","Death Star real estate","Handelsbanken Aktiv 100"};
        //iterovanie - pre kazdy cyklus vykonam cast kodu pre kadzy item z pola
    for (String arayOfFund : arayOfFunds) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.enterInvestments( "20");
        calculatorPage.enterYears("20");
        calculatorPage.enterEmail("peter.pis@aas-slovakia.sk");
        Assert.assertFalse(calculatorPage.getTotalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getTotalIncome().contains("kr"));
    }
}




}
