package chase1;

import common.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends CommonAPI {

//    @FindBy(xpath = "//span[@class='chase-text']")
//    public static WebElement chaseLogo;
    @Test
    public static void logoTest(){
        clickOnElement("//span[@class='chase-text']");
        boolean flag =isElementDisplayed("//span[@class='chase-text']");
        Assert.assertEquals(flag,true);
        sleepFor(3);
    }
    @Test
    public static void sideMenu(){
        clickOnElement("//a[@id='skip-sidemenu']");
        isElementDisplayed("//div[@id='side-menu-header']");
        sleepFor(3);
    }
//    @Test
//    public static void specialOffers(){
//        isElementDisplayed("//div[@class='herolayer__content left top']");
//        clickOnElement("//a[@class='btn cta cta--primary cta--large']");
//        dismissAlert();
//        isElementDisplayed("//html[@xmlns='http://www.w3.org/1999/xhtml']");
//
//    }
   /* @Test
    public static void signUpWindow(){
        isElementDisplayed("//div[@class='signin jpui raised segment sigin-box']");
        clickOnElement("//a[@role='button'and@data-pt-name='unknwnlogin'and@data-src='https://{pod}/web/auth/dashboard']");
    }
    @Test(dependsOnMethods = {"signUpWindow"})
    public static void signin(){
        clickOnElement("id=\"signin-button\"");
    }
    @Test
    public static void signUpWindow(){
        typeOnElement("//input[@class='jpui input logon-xs-toggle'and@placeholder='Username']","ahmed");
        isElementDisplayed("//h2[@class='welcomeHeader']");
        clickOnElement("//a[@role='button'and@data-pt-name='unknwnlogin'and@data-src='https://{pod}/web/auth/dashboard']");
        typeOnElement("//div[@class='logon-xs-toggle'and@id=\"userId\"]","ahmed");
        clickOnElement("//button[@type='submit'and@id='signin-button']");
    }*/
    @Test
    public static void searchBar(){
        clickOnElement("//a[@class='header__section__item header__section--search icon-search']");
        typeOnElement("//input[@type='text'and@placeholder=\"Search\"and@class='header__section--search__bar--search-input']","new acccount");
        sleepFor(3);
    }
    @Test
    public static void mouseOverAccountDropDown(){
        mouseOver("//a[@class='header__section--dropdown__title__link chaseanalytics-track-link']");
        sleepFor(3);
    }

    @Test
    public static void atmLocator(){
        clickOnElement("//a[@href='https://locator.chase.com/?locale=en_US'and@class='chaseanalytics-track-link']");
        isElementDisplayed("//div[@class='Directory-hero Directory-hero--rb']");
        sleepFor(3);
    }


}
