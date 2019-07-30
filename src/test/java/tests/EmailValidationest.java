package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailValidationest extends TestBase {


    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() throws FileNotFoundException {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        //zadam zly email
        for (String invalidEmail : readInvalidEmails()) {
            calculatorPage.enterEmail(invalidEmail);

            Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]")).
                    getAttribute("class")
                    .contains("error"));



            }

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

        private List<String> readInvalidEmails () throws FileNotFoundException
        {
            //nacitam file
            FileReader invalidEmailTxt = new FileReader(new File("src/test/resources/invalid_emails.txt"));
            //vytvorim prazdny list do ktoreho budem ukladat riadky
            List<String> invalidEmailList = new ArrayList<>();
            //do vytvoreneho listu priradim vsetky riadky ktore som nasiel
            invalidEmailList = new BufferedReader(invalidEmailTxt).lines().collect(Collectors.toList());
            return invalidEmailList;
        }
    }
