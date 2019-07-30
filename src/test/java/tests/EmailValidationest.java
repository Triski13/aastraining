package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

public class EmailValidationest extends TestBase {


    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
                //zadam zly email
        calculatorPage.enterEmail("ewfsakk");
//overim ze atribut class obsahuje error
        System.out.println(driver.findElement(By.xpath("//div[input[@id='emailInput']]")).getAttribute("class"));
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]")).
                getAttribute("class")
                .contains("error"));

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='emailInput']/..")).
                getAttribute("class")
                .contains("error"));

    }
}
