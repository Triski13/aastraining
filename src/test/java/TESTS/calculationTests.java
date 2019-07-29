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
            new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
            ;
            //driver.findElement(By.id("fundSelect"))
            //2. zadat sumu
            driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
            //3. pocet rokov
            driver.findElement(By.id("yearsInput")).sendKeys("35");
            //4. zadat email
            driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
            //5. overit buton
            Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
            driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty();

            //2. Overit ze totoal income nie je prazdny
            driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
            Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        }

        @Test
        public void itShouldCalculateInterestIncome() {

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        ;
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3. pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("35");
        //4. zadat email
        driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
//2. overit ze interest Incom nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
         Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        }

        @Test
        public void itShouldCalculateRisk () {

        //  1.Vybrat fond, zadat sumu, roky email
        //1. vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Batman's Cave Development");
        ;
        //driver.findElement(By.id("fundSelect"))
        //2. zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("2000");
        //3. pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("35");
        //4. zadat email
        driver.findElement(By.id("emailInput")).sendKeys("peter.pis@aas-slovakia.sk");
        //5. overit buton
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        // 2. overit ze risk nie je prazdny
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
    }


    @After
    public void tearDown() {
//            driver.close();
//           driver.quit();
    }
}
