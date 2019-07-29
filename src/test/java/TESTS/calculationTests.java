package TESTS;

import Base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class calculationTests extends TestBase {



    @Test
    public void itShouldCalculateTotalIncome() {
        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        selectFund("Hoggwart's Fund");
                //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        enterInvestments("20");
        //3. pocet rokov
        enterYears("20");
        //4. zadat email
        enterEmail( "peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty();

        //2. Overit ze totoal income nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        selectFund("Hoggwart's Fund");
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        enterInvestments( "20");
        //3. pocet rokov
        enterYears("20");
        //4. zadat email
        enterEmail("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
//2. overit ze interest Incom nie je prazdny
        Assert.assertFalse(getInterestIncome().isEmpty());
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));

    }

    @Test
    public void itShouldCalculateRisk() {

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        selectFund("Hoggwart's Fund");
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        enterInvestments( "20");
        //3. pocet rokov
        enterYears("20");
        //4. zadat email
        enterEmail("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        // 2. overit ze risk nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
        Assert.assertFalse(getRisk().isEmpty());
    }

@Test
public void iTShlouldCalculateTotalIncomeForEachFund (){
        String[] arayOfFunds = {"Fellowship investment group","Death Star real estate","Handelsbanken Aktiv 100"};
        //iterovanie - pre kazdy cyklus vykonam cast kodu pre kadzy item z pola
    for (String arayOfFund : arayOfFunds) {
        selectFund(arayOfFund);
        enterInvestments( "20");
        enterYears("20");
        enterEmail("peter.pis@aas-slovakia.sk");
        Assert.assertFalse(getTotalIncome().isEmpty());
        Assert.assertTrue(getTotalIncome().contains("kr"));
    }
}
    private String getTotalIncome() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")
        ).getText();
    }
        private String getInterestIncome() {
          return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();

    }
    private String getRisk() {
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }

    private void selectFund(String fundToSelect) {  //viditelna metoda len pre tuto triedu
                                 //void - nevrati ziadnu hodnotu, len niekde  klikne...
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }
    private void enterInvestments(String amountToEnter) {
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("20");
    }
    private void enterYears(String yearsToEnter) {
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys("35");
    }
    private void enterEmail(String yearsToEnter) {
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
    }




}
