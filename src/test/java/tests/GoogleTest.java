package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleTest extends BaseTest
{
    @Test
        public void googleSearchTest() throws InterruptedException
        {

            String url = "https://www.google.com/";
           // metoda get() sluzi da nas odvede na trazenu stranicu
            driver.get(url);

           // definisanje elementa searchField
            WebElement searchField = driver.findElement(By.name("q"));
            //upisati "Comtrade" u searchField
            searchField.sendKeys("Comtrade");

            //definisanje web elementa SearchButton
            WebElement searchButton = driver.findElement(By.name("btnK"));

            //kliknuti na Search Button
            wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();

            //definisanje elementa sa rezultatima
            WebElement results = driver.findElement(By.id("rcnt"));

            //stampaj text sa elementa results
            System.out.println(results.getText());

            //provera da li postoji pojam na elementu
            Assert.assertTrue("Comtrade is not found on result page",results.getText().contains("Comtrade"));

            // sleep je ostavljen da bi se vizuelno video rezultat testa
            Thread.sleep(5000);


        }

    }

