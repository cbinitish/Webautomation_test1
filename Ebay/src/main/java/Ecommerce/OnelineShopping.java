package Ecommerce;

import common.CommonAPI;
import org.testng.annotations.Test;

public class OnelineShopping extends CommonAPI {


    @Test
    public static void logoTest() {
        clickOnElement("//a[@href='https://www.ebay.com/deals']");
    }


}
