package tests;

import helpers.UdemyLoginHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UdemyLoginTest extends BaseTest {
    @Test
    public void positiveLoginTest() throws InterruptedException {
        UdemyLoginHelper.positiveLogin();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("udlite-container")));
        WebElement results = driver.findElement(By.className("udlite-container"));
        System.out.println(results.getText());
        Assert.assertTrue( results.getText().contains("learn"));
        // sleep je ostavljen da bi se vizuelno video rezultat testa
        Thread.sleep(3000);
    }

    @Test
    public void negativeLoginTest() throws InterruptedException {
        UdemyLoginHelper.negativeLogin();
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("login-form"), "Log In to Your Udemy Account!"));
        WebElement results = driver.findElement(By.id("login-form"));
        System.out.println(results.getText());
        Assert.assertTrue(results.getText().contains("problem"));
        // sleep je ostavljen da bi se vizuelno video rezultat testa
        Thread.sleep(3000);
    }

    @Test
    public void SpanishLanguage() throws InterruptedException {
        UdemyLoginHelper.SpanishLanguage();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dark-background-inner-text-container")));
        WebElement wishbutton = driver.findElement(By.className("dark-background-inner-text-container"));
        System.out.println(wishbutton.getText());
        Assert.assertTrue(wishbutton.getText().contains("Spanish"));
        // sleep je ostavljen da bi se vizuelno video rezultat testa
        Thread.sleep(5000);?
    }

    @Test
    public void FrenchLanguage() throws InterruptedException {
        UdemyLoginHelper.FrenchLanguage();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-success-title")));
        WebElement cartlist = driver.findElement(By.id("cart-success-title"));
        System.out.println(cartlist.getText());
        Assert.assertTrue(cartlist.getText().contains("Added to cart"));
        // sleep je ostavljen da bi se vizuelno video rezultat testa
        Thread.sleep(3000);
    }

    @Test
    public void GermanLanguage() throws InterruptedException {
        UdemyLoginHelper.GermanLanguage();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div/div/header/h1")));
        WebElement shownresults = driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div/div/header/h1"));
        System.out.println(shownresults.getText());
        Assert.assertTrue(shownresults.getText().contains("german"));
        // sleep je ostavljen da bi se vizuelno video rezultat testa
        Thread.sleep(5000);
    }
}

