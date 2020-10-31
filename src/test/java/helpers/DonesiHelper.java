package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DonesiHelper extends BaseHelper
{
    public static void reachRestaurantChosePage() throws InterruptedException
    {
       // odlazak na sajt donesi.com
        driver.get("https://www.donesi.com/");
       // pronalazenje polja Unesite vasu adresu
        WebElement searchAddress = driver.findElement(By.className("address-form-component-search-input"));
        // Unosenje adrese Beogradska 5 u prethodno polje
        searchAddress.sendKeys("Beogradska 5");
        // cekanje da se pojavi lista ponudjenih adresa
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.p-5:nth-child(1) > span:nth-child(3) > span:nth-child(2)")));
        // pronalazenje prve adrese iz liste
        WebElement addressConfirm = driver.findElement(By.cssSelector("li.p-5:nth-child(1) > span:nth-child(3) > span:nth-child(2)"));
       // odabir prve adrese iz liste
        addressConfirm.click();
        // pronalazenje dugmeta Narucite
        WebElement orderButton = driver.findElement(By.xpath("/html/body/div[2]/main/section[2]/section[1]/div/div[2]/div/div/div/div/div[2]/form/div[2]/div[1]/div[2]/button"));
        // klik na dugme narucite koriscenjem Javascript funkcije
        js.executeScript("arguments[0].click();", orderButton );
        // Cekanje dugmeta Nastavite na mapi
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("button-map-submit")));
       // pronalazenje dugmeta Nastavite
        WebElement continueButton = driver.findElement(By.className("button-map-submit"));
        // klik na dugme Nastavite jer su sva polja popunjena (ako nisu trebaju se prvo popuniti)
        continueButton.click();
    }

    private static List<WebElement> italianFoodChoser()
    {
       // cekanje da se pojavi checkbox Italijanska hrana
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("Италијанска_храна")));
        // pronalezenje elementa koji u sebi sadzi broj restorana u reci Pronasli smo <broj> restorana
        WebElement restaurantCounter = driver.findElement(By.className("shops-listing-counter"));
        // zapamtimo taj broj u promenjljivoj counterText
        String counterText = restaurantCounter.getText();
        // odstampamo u konzoli poruku Trenutni broj restorana: i taj broj
        System.out.println("Trenutni broj restorana:"+counterText);
        // pronalazenje checkboxa Italijanska hrana
        WebElement italianFoodCheckBox = driver.findElement(By.id("Италијанска_храна"));
        // klik na taj checkbox koristeci JS funkciju
        js.executeScript("arguments[0].click();", italianFoodCheckBox );
        // cekanje da se broj pronadjenih restorana promeni, tacnije da nestane broj koji smo prethodno zapamtili
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("shops-listing-counter"),counterText));
        // preuzimanje novog broja restorana posle filtera
        counterText = restaurantCounter.getText();
        // stampanje novog broja restorana
        System.out.println("Novi broj restorana:"+counterText);
        // pretvaranje String promenljive counterText u INt iliti broj kojem smo dali ime restaurantNumber
        int restaurantNumber = Integer.parseInt(counterText);
        // stampanje int promenjljive
        System.out.println("int:"+restaurantNumber);
        // stavljanje svih restorana u listu restaurants
        List<WebElement> restaurants = driver.findElements(By.className("shops-listings-shops-list-item"));
        // validacija da je velicina liste jednaka broju koji smo zapamtili iz poruke Nasli smo ...
        Assert.assertEquals("Counters are not equal",restaurants.size(),restaurantNumber);
        // posto metoda nije void nego List<WebElement> vracamo listu kao rezultat
        return restaurants;
    }

    public static void filterRestaurant() throws InterruptedException
    {
        // pozivanje interne metode koja nas dovodi na listu restorana
        reachRestaurantChosePage();
        // pozivanje metode koja odabere Italijansku hranu i proverava broj restorana
        italianFoodChoser();
    }

    public static void foodOrder() throws InterruptedException
    {
        // pozivanje interne metode koja nas dovodi na listu restorana
        reachRestaurantChosePage();
        // u listu restaurants ubacujemo restoran sa ITA hranom tako sto pozovemo metodu italianFoodChoser()
        List<WebElement> restaurants = italianFoodChoser();
        // izabrani restoran je 12ti iz liste jer indeksi krecu od 0
        WebElement chosenRestaurant = restaurants.get(11);
        // stampanje teksta sa elementa sa restoranom
        System.out.println(chosenRestaurant.getText());
        // skrolovanje do elementa koristeci JS funkciju
        js.executeScript("arguments[0].scrollIntoView();", chosenRestaurant );
        // sleep ostavljen da vidite da je odskrolovao
        Thread.sleep(4000);
        // pronalazenje dugmeta Narucite pored imena restorana
        WebElement orderButton = chosenRestaurant.findElement(By.className("btn-lg"));
        // klik na narucite pored imena restorana
        js.executeScript("arguments[0].click();", orderButton );
        // ovde sad treba da se napisu koraci za ubacivanje u korpu i proveru
    }

}
