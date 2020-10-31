package tests;

import helpers.ScrapperLogin;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ScrapperLoginTest extends BaseTest {
    @Test
    public void positiveLoginTest() throws InterruptedException
    {
        ScrapperLogin.positiveLogin();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("case_login"), "Please, login"));
        WebElement results = driver.findElement(By.id("case_login"));
        System.out.println(results.getText());

        Assert.assertTrue(results.getText().contains("WELCOME :)"));
        Assert.assertTrue(results.getText().contains("GO BACK"));
        Thread.sleep(3000);
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        ScrapperLogin.negativeTest();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("case_login"), "Please, login"));
        WebElement results = driver.findElement(By.id("case_login"));
        System.out.println(results.getText());
        Assert.assertTrue(results.getText().contains("ACCESS DENIED!"));
        Thread.sleep(3000);
        //ScrapperLogin objekatScraper = new ScraperLogin();
        //objekatScraper.loginZaObjekat("efsf", "ssffsf);
    }
}
