package base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase  {
  protected  WebDriver driver;
    @Before /*anotacia*/
    public void setUp() {  /*metoda*/
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/ta-mentor-program-playground-master/savingscalculator.php");
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
