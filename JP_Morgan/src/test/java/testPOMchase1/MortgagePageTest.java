package testPOMchase1;

import POMchase1.HomepageWebElement;
import POMchase1.Mortgage;
import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MortgagePageTest extends CommonAPI {

    Mortgage mortgage;
    @BeforeMethod
    public void initElements(){
        mortgage = PageFactory.initElements(driver, Mortgage.class);
    }
    @Test
    public void checkingMortgageRate(){
        mortgage.checkMortgageRate();
    }
    @Test
    public void playingVideo(){
        mortgage.MortgagePageVideo();
    }

}
