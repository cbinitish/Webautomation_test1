package testPOMchase1;

import POMchase1.HomepageWebElement;
import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI {

    //HomepageWebElement homepageWebElement = new HomepageWebElement();
    HomepageWebElement homepageWebElement;
    @BeforeMethod
    public void initElements(){
        homepageWebElement = PageFactory.initElements(driver, HomepageWebElement.class);
    }
    @Test
    public void testChaseLogo(){
        //HomepageWebElement homepageWebElement = PageFactory.initElements(driver, HomepageWebElement.class);
        homepageWebElement.chaseLogo();
    }
    @Test
    public void openAnAccountDD(){
        homepageWebElement.mouseOverAccountDropDown();
    }
}
