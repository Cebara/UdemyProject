package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class  DonesiHomePage extends BaseHelper
{
    @FindBy(className = "address-form-component-search-input")
    WebElement  searchAddress;
    @FindBy(xpath = "/html/body/div[2]/main/section[2]/section[1]/div/div[2]/div/div/div/div/div[2]/form/div[2]/div[1]/div[2]/button")
    WebElement orderButton;
    WebDriver driver;

    public DonesiHomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void navigateToDonesiHome(){
        driver.get("https://www.donesi.com/");
    }

    private void enterAddress(String adresa)
        {
            wdWait.until(ExpectedConditions.visibilityOf(searchAddress));
            searchAddress.sendKeys(adresa);
        }

        private void addressConfirm()
        {
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.p-5:nth-child(1) > span:nth-child(3) > span:nth-child(2)")));
            //pronalazenje prve adrese iz liste
            WebElement addressConfirm = driver.findElement(By.cssSelector("li.p-5:nth-child(1) > span:nth-child(3) > span:nth-child(2)"));
            //odabir prve adrese iz liste
            addressConfirm.click();
        }

        private void orderButtonClick ()
        {
            //klik na dugme narucite koriscenjem Javascrpit funkcije
            js.executeScript("arguments[0].click();" , orderButton);
        }

        public void addressChoser ()
        {
            navigateToDonesiHome();
            enterAddress("Beogradska 5");
            addressConfirm();
            orderButtonClick();
        }
    }         