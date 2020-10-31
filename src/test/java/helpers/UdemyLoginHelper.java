package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UdemyLoginHelper extends BaseHelper {
    private static void login(String email, String password) throws InterruptedException {
        String url = "https://www.udemy.com/";
        driver.get(url);
        WebElement LogInButton = driver.findElement(By.className("header--gap-auth-button--7KoL0"));
        LogInButton.click();
        WebElement EmailField = driver.findElement(By.id("email--1"));
        EmailField.sendKeys(email);
        WebElement PasswordField = driver.findElement(By.id("id_password"));
        PasswordField.sendKeys(password);
        WebElement LogInSubmit = driver.findElement(By.name("submit"));
        LogInSubmit.click();

    }

    public static void positiveLogin() throws InterruptedException {
        login("nikola.cebic+19@gmail.com", "nikceb123");
    }

    public static void negativeLogin() throws InterruptedException {
        login("nikola.cebic+19@gmail.com", "caocao");
    }

    public static void SpanishLanguage() throws InterruptedException {
        positiveLogin();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement SearchField = driver.findElement(By.name("q"));
        SearchField.sendKeys("Spanish");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("course-card--image-wrapper--Sxd90")));
        WebElement Result = driver.findElement(By.className("course-card--image-wrapper--Sxd90"));
        Result.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div[1]/div[3]/div/div/div[4]/div/div[2]/div/div/div[1]/div/div/button")));
        WebElement wishButton = driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div[1]/div[3]/div/div/div[4]/div/div[2]/div/div/div[1]/div/div/button"));
        System.out.println("Wish:" + wishButton.getText());
        js.executeScript("arguments[0].click();", wishButton);

    }

    public static void FrenchLanguage() throws InterruptedException {
        positiveLogin();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement SearchField = driver.findElement(By.name("q"));
        SearchField.sendKeys("French");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("course-card--image-wrapper--Sxd90")));
        WebElement result = driver.findElement(By.className("course-card--image-wrapper--Sxd90"));
        result.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[4]/div/button")));
        WebElement cart = driver.findElement(By.xpath("//*[@id=\"udemy\"]/div[2]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div[1]/div[2]/div/div[1]/div/div[4]/div/button"));
        cart.click();
    }

    public static void GermanLanguage() throws InterruptedException {
        positiveLogin();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement SearchField = driver.findElement(By.name("q"));
        SearchField.sendKeys("German");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("udlite-toggle-input-container")));
        WebElement filter = driver.findElement(By.className("udlite-toggle-input-container"));
        filter.click();
        
    }
}