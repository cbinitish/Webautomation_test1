package bestbuy;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {

    public void PopUpBestBuy() {
        clickOnElement("//button[@class='close']//span[contains(text(),'×')]");
    }


    public void getClickOnInternationalSiteElements(){
        PopUpBestBuy();
        sleepFor(5);
        clickOnElement("//a[contains(text(),'International Sites')]");
        clickOnElement("//h3[@class='title-headline v-fw-medium']//a[contains(text(),'Best Buy Canada')]");
    }

    public void getClickOnFeedbackElements(){
        PopUpBestBuy();
        sleepFor(5);
        clickOnElement("//button[@class='btn-unstyled feedback-link']");
    }

    public void getProductsAndBrandElements(){
        PopUpBestBuy();
        sleepFor(10);
        clickOnElement("//button[contains(text(),'Products')]");
        clickOnElement("//body[contains(@class,'size-l bby-ghp')]/div[@id='shop-header-f8ab7cd6-4310-43e2-b508-89d1b5e98b48']/div[contains(@class,'shop-header')]/div[@id='large-header']/header[@id='header-block']/div[contains(@class,'header-large')]/div[contains(@class,'fullbleed-wrapper')]/div[contains(@class,'navigation-container')]/nav[contains(@class,'global-navigation multi-column')]/ul[contains(@class,'global-nav-list')]/li/div[@id='menu_wrapper']/button[contains(@class,'btn-default-link menuCloseBtn')]/div[contains(@class,'flyBtn')]/*[1]");
        sleepFor(10);
        clickOnElement("//button[contains(text(),'Brands')]");
       clickOnElement( "//body[contains(@class,'size-l bby-ghp')]/div[@id='shop-header-f8ab7cd6-4310-43e2-b508-89d1b5e98b48']/div[contains(@class,'shop-header')]/div[@id='large-header']/header[@id='header-block']/div[contains(@class,'header-large')]/div[contains(@class,'fullbleed-wrapper')]/div[contains(@class,'navigation-container')]/nav[contains(@class,'global-navigation multi-column')]/ul[contains(@class,'global-nav-list')]/li/div[@id='menu_wrapper']/button[contains(@class,'btn-default-link menuCloseBtn')]/div[contains(@class,'flyBtn')]/*[1]");
    }

    public void getServicesElements(){
        PopUpBestBuy();
        sleepFor(10);
        clickOnElement("//button[contains(text(),'Services')]");
        clickOnElement("//a[contains(@class,'link')][contains(text(),'Customer Service')]");
        clickOnElement("//a[contains(text(),'Contact us')]");
        driver.navigate().back();
        driver.navigate().back();
    }

    public void getClickCreditCards(){
        PopUpBestBuy();
        sleepFor(5);
        clickOnElement("//a[@class='link'][contains(text(),'Credit Cards')]");
        clickOnElement("//a[@class='btn btn-secondary btn-lg primary-button']");
    }


    public void getDealOfTheDayElements(){
        PopUpBestBuy();
        sleepFor(10);
        clickOnElement("//a[contains(text(),'Deal of the Day')]");
        driver.navigate().back();
    }

}
