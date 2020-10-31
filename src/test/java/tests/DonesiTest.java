package tests;

import helpers.DonesiHelper;
import org.junit.Test;

public class DonesiTest extends BaseTest
{
    @Test
    public void filterRestaurantTest() throws InterruptedException
    {
        DonesiHelper.filterRestaurant();
        Thread.sleep(4000);
    }

    @Test
    public void foodOrderTest() throws InterruptedException
    {
        DonesiHelper.foodOrder();
        Thread.sleep(9000);
    }
}
