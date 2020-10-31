package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ScrapperLogin extends BaseHelper {


    private static void login(String username, String password)   {
        //definisanje promenljive url tipa string i dodela vrednosti "http://testing-ground.scraping.pro/login"
        String url = "http://testing-ground.scraping.pro/login";
        //metoda get() sluzi da nas odvede na trazenu stranicu i dodeljujemo joj promenljivu url
        driver.get(url);
        //definisanje web elementa username
        WebElement usernameBox = driver.findElement(By.id("usr"));
        //upisati "admin" u polje userName
        usernameBox.sendKeys(username);
        //definisanje web elementa password
        WebElement passwordBox = driver.findElement(By.id("pwd"));
        //upisati "12345" u polje password
        passwordBox.sendKeys(password);
        //definisanje web elementa loginButton
        WebElement loginButton = returnElementAttValue("type" , "submit");
        loginButton.click();
    }
    public static void positiveLogin() {
        login("admin", "12345");
    }
    public static void negativeTest() {
        login("asds", "fsdgfs");
    }
}