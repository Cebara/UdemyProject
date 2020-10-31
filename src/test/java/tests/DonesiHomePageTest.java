package tests;

import helpers.DonesiHelper;
import helpers.DonesiHomePage;
import org.junit.Test;

public class DonesiHomePageTest extends BaseTest {
    @Test
    public void filterRestaurantTest() throws InterruptedException {
        DonesiHelper.filterRestaurant();
        Thread.sleep(4000);
    }

    @Test
    public void foodOrderTest() throws InterruptedException {
        DonesiHelper.foodOrder();
        Thread.sleep(4000);
    }

    @Test
    public void testPOM() throws InterruptedException {

        DonesiHomePage dhp = new DonesiHomePage(driver);
        dhp.addressChoser();
        Thread.sleep(4000);
    }
}
