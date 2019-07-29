package TESTS;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class calculationTests {
    WebDriver driver;

    @Before /*anotacia*/
    public void setUp() {  /*metoda*/
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/ta-mentor-program-playground-master/savingscalculator.php");
    }

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
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().contains("kr"));

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
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
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
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());

    }


    private void selectFund(String fundToSelect) {  //viditelna metoda len pre tuto triedu
                                 //void - nevrati ziadnu hodnotu, len niekde  klikne...
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    private void enterInvestments(String amountToEnter) {
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("20");
    }

    private void enterYears(String yearsToEnter) {
        driver.findElement(By.id("yearsInput")).sendKeys("35");
    }

    private void enterEmail(String yearsToEnter) {
        driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
    }



    @After
    public void tearDown() {
//            driver.close();
//           driver.quit();
    }
}
