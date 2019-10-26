package TestBestBuy;

import HomepagePOM.BestBuyHomePage;
import HomepagePOM.SearchPage;
import bestbuy.HomePage;
import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class TestHomePage extends CommonAPI {

    BestBuyHomePage bestBuyHomePage;

    SearchPage searchPage;
    HomePage homePage;

    @BeforeMethod
    public void ininElements(){
        bestBuyHomePage = PageFactory.initElements(driver,BestBuyHomePage.class);
    }

    @BeforeMethod
    public void initElements(){
        searchPage= PageFactory.initElements(driver,SearchPage.class);
    }

    @BeforeMethod
    public void initElement(){
        homePage = PageFactory.initElements(driver,HomePage.class);
    }



    @Test@Ignore
    public void TestLogo(){
        bestBuyHomePage.ValidateBestbuyLogo();

    }

    @Test@Ignore
    public void TestSearchBar(){
        bestBuyHomePage.ClickOnSearchBarWebElements();

    }

    @Test(enabled = false)
    public void TestAllElementsFromProduct(){
        List<WebElement> elementList = bestBuyHomePage.getAllElementsFromProduct();
        System.out.println(elementList.size());
        for (int i=0;i<elementList.size();i++){
            System.out.println(elementList.get(i).getText());

        }
    }

    @Test@Ignore
    public void TestOnProductButtonWebeElements(){
        bestBuyHomePage.ClickOnProductButtonWebeElements();
    }




    @Test@Ignore
    public void testSearchBox(){
        searchPage.searchBox();
    }

    @Test@Ignore
    public void testSearchBoxFromDataSource() {
        searchPage.searchItems();
    }


    @Test@Ignore
    public void testAccountsButton(){
        bestBuyHomePage.getAccountButtonWebElements();
    }


    @Test@Ignore
    public void testAccountSignInWebElements(){
        bestBuyHomePage.getAccountSignInWebElements();
    }

    @Test@Ignore
    public void tetsTrackOrderButtonFromHomePageAccount(){
        bestBuyHomePage.getTrackOrderFromAcoountButtonWebElements();
    }

    @Test@Ignore
    public void testBestBuyCopyrightText(){
        bestBuyHomePage.bestBuyCopyrightText();
    }

    @Test@Ignore
    public void testHomePageScrolling(){
        bestBuyHomePage.homePageScrolling();
    }

    @Test@Ignore
    public void testAddShopingCartProduct(){
        bestBuyHomePage.clickOnSearchBarAndShopping();
    }

    @Test@Ignore
    public void testClickOnInternationalSiteElements(){
        homePage.getClickOnInternationalSiteElements();
    }

    @Test@Ignore
    public void testClickOnFeedbackElements(){
        homePage.getClickOnFeedbackElements();
    }

    @Test@Ignore
    public void testProductAndBrandsElements(){
        homePage.getProductsAndBrandElements();
    }

    @Test@Ignore
    public void testServicesElements(){
        homePage.getServicesElements();
    }

    @Test@Ignore
    public void testCreditCardsElements(){
        homePage.getClickCreditCards();
    }

    @Test@Ignore
    public void testDealOfTheDaysElements(){
        homePage.getDealOfTheDayElements();
    }


    @Test(enabled = false)
    public void testDealsPriceMatchGurenteeElements(){
        bestBuyHomePage.getDealsPriceMatchGurenteeElements();
    }

    @Test@Ignore
    public void testArrowButtonWebElements(){
        bestBuyHomePage.getArrowButtonWebElements();
    }

    @Test@Ignore
    public void testGiftIdeasWebElements(){
        bestBuyHomePage.getGiftIdeasWebElements();
    }

    @Test
    public void testMobileSiteElements(){
        bestBuyHomePage.getMobileSiteElements();
    }



}
