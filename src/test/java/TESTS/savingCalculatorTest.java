package TESTS;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class savingCalculatorTest {    /* trieda*/

    WebDriver driver;

    @Before /*anotacia*/
    public void setUp() {  /*metoda*/
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/ta-mentor-program-playground-master/savingscalculator.php");
    }
    @Test
    public void itShouldDisplayTitle() {
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }
    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {
        driver.findElement(By.cssSelector("button.btn-block")).isEnabled();
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }
    @Test
    public void itShouldEnableApplyButton() {
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
    }

    @Test
    public void itShouldNotSelecetAnyFundOnPage() {
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
        Assert.assertEquals("Select your fund",new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
    }

    @After
    public void tearDown() {
//            driver.close();
//            driver.quit();
    }
}
