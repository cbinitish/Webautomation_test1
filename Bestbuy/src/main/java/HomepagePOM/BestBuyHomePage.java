package HomepagePOM;

import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

public class BestBuyHomePage extends CommonAPI {

    @FindBy(xpath = "//div[@class='bby-logo-lv']//a")
    public static WebElement bestbuyLogo;


    public void PopUpBestBuy() {
        clickOnElement("//button[@class='close']//span[contains(text(),'×')]");
    }

    public void ValidateBestbuyLogo() {

        //for pop up make another method
        //clickOnElement("//button[@class='close']//span[contains(text(),'×')]");
        //bestbuyLogo.click();
        PopUpBestBuy();
        clickOnElement("//img[@src='https://pisces.bbystatic.com/image2/BestBuy_US/Gallery/bby_logo-82846.png']");
        //Assert.assertEquals(bestbuyLogo.isDisplayed(),false);
    }

    @FindBy(xpath ="//input[@id='gh-search-input']")
    public static WebElement clickOnSearchBarWebElements;

    @FindBy(xpath = "//span[@class='header-search-icon']//img")
    public static WebElement SearchButtonWebElements;

    public void ClickOnSearchBarWebElements() {
        PopUpBestBuy();
        //sleepFor(4);
        waitUntilClickable("//input[@id='gh-search-input']",4);
        clickOnSearchBarWebElements.click();
        clickOnSearchBarWebElements.sendKeys("Shop Books");
        SearchButtonWebElements.click();
        driver.navigate().back();
        Assert.assertEquals(bestbuyLogo.isDisplayed(), true);

    }


    public List<WebElement> getAllElementsFromProduct() {
        PopUpBestBuy();
        return driver.findElements(By.xpath("//button[contains(text(),'Products')]"));
    }

    @FindBy(css = ".global-nav-list > li:nth-of-type(1) > .btn-unstyled.flyBtn.menuHeader")
    public static WebElement ProductButtonWebeElements;

    public void ClickOnProductButtonWebeElements() {
        PopUpBestBuy();
        sleepFor(3);
        ProductButtonWebeElements.click();
    }



    @FindBy(xpath = "//span[@class='flyBtn']")
    public static WebElement AccountButtonWebElements;

    public void getAccountButtonWebElements(){
        PopUpBestBuy();
        sleepFor(3);
        AccountButtonWebElements.click();
    }




    @FindBy(xpath = "//button[@class='lam-signIn__button btn btn-secondary']")
    public static WebElement AccountSignInButtonWebElements;

    @FindBy(xpath = "//input[@id='fld-e']")
    public static WebElement SignInEmailAdressButtonWebElements;

    @FindBy(xpath = "//input[@id='fld-p1']")
    public static WebElement SignInPasswordButtonWebElements;

    public void getAccountSignInWebElements(){
        getAccountButtonWebElements();
        sleepFor(3);
        AccountSignInButtonWebElements.click();
        SignInEmailAdressButtonWebElements.sendKeys("mehediux2x@yahoo.com",Keys.ENTER);
        sleepFor(2);
        SignInPasswordButtonWebElements.sendKeys("123456Test");

    }


    @FindBy(xpath = "//a[contains(text(),'Track Order')]")
    public static WebElement TrackOrderButtonFromAccount;

    @FindBy(xpath = "//input[@id='orderNumber-id']")
    public static WebElement getTrackOrderNumberWebElements;

    @FindBy(xpath = "//input[@id='lastName-id']")
    public static WebElement getTrackOrderLastNameWebElements;

    @FindBy(how = How.XPATH,using = "//input[@id='phoneNumber-id']")
    public static WebElement getTrackOrderPhoneNumberWebElements;


    public void getTrackOrderFromAcoountButtonWebElements(){

        getAccountButtonWebElements();
        TrackOrderButtonFromAccount.click();
        getTrackOrderNumberWebElements.sendKeys("7654321",Keys.DOWN);
        //getTrackOrderLastNameWebElements.click();
        getTrackOrderLastNameWebElements.sendKeys("hasan",Keys.DOWN);
        getTrackOrderPhoneNumberWebElements.sendKeys("6468761234",Keys.ARROW_DOWN);
        Assert.assertEquals(bestbuyLogo.isDisplayed(), true);

    }



                   //BestBuy CopyRight Starts -->

    @FindBy (how = How.CSS,using = "footer#large-footer > .disclaimer")
    public static WebElement bestBuyCopyrightTextWebElement;


    public static WebElement getBestBuyCopyrightTextWebElement()
    {
        return bestBuyCopyrightTextWebElement;
    }

    public void bestBuyCopyrightText(){
        PopUpBestBuy();
        sleepFor(3);

        String text = getBestBuyCopyrightTextWebElement().getText();
        System.out.println(text);
        Assert.assertEquals(text,"" +"Prices and offers are subject to change. © 2019 Best Buy. All rights reserved. BEST BUY, the BEST BUY logo, the tag design, MY BEST BUY, and BESTBUY.COM are trademarks of Best Buy and its affiliated companies.");

    }

    //  End <---

    public void homePageScrolling() {
        PopUpBestBuy();
        sleepFor(3);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,2000)");
        sleepFor(3);
    }


    @FindBy(xpath = "//div[@id='shop-sku-list-item-7fa19040-bf93-42f9-a212-b62132028779']//img[@class='product-image']")
    public static WebElement shoppingImageClickAddWebElements;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button']")
    public static WebElement shoppingCartClickAddWebElements;

    public void clickOnSearchBarAndShopping() {
        PopUpBestBuy();
        //sleepFor(4);
        waitUntilClickable("//input[@id='gh-search-input']",4);
        clickOnSearchBarWebElements.click();
        clickOnSearchBarWebElements.sendKeys("apple watch series 5");
        SearchButtonWebElements.click();
        sleepFor(3);
        shoppingImageClickAddWebElements.click();
        shoppingCartClickAddWebElements.click();
       // driver.navigate().back();
        //Assert.assertEquals(bestbuyLogo.isDisplayed(), true);

    }


    @FindBy(xpath ="//button[contains(text(),'Deals')]")
    public static WebElement clickOnDealsWebElements;
    @FindBy(xpath = "//a[@class='link'][contains(text(),'Price Match Guarantee')]")
    public static WebElement clickOnPriceMatchGuranteeElements;

    public void getDealsPriceMatchGurenteeElements(){
        PopUpBestBuy();
        sleepFor(10);
        clickOnDealsWebElements.click();
        clickOnPriceMatchGuranteeElements.click();
        driver.navigate().to("https://www.bestbuy.com");

    }

    @FindBy(xpath = "//a[@class='link'][contains(text(),'Top Deals')]")
    public static WebElement clickOnTopDealElements;
    @FindBy(xpath = "//div[@class='flex-carousel-arrow-right isVisible']//button[contains(@class,'btn-unstyled')]")
    public static WebElement clickOnRightArrowButtonWebElements;
    @FindBy(xpath = "//div[@class='flex-carousel-arrow-left isVisible']//button[contains(@class,'btn-unstyled')]")
    public static WebElement clickOnLeftArrowWebElements;

    public void getArrowButtonWebElements(){
        PopUpBestBuy();
        sleepFor(5);
       clickOnTopDealElements.click();
       sleepFor(5);
       clickOnRightArrowButtonWebElements.click();
       clickOnLeftArrowWebElements.click();
       Assert.assertEquals(bestbuyLogo.isDisplayed(), true);

    }

    @FindBy(xpath = "//a[contains(text(),'Gift Ideas')]")
    WebElement clickOnGiftIdeaElements;
    @FindBy(xpath = "//div[contains(text(),'Gifts for her')]")
    public static WebElement clickOnGiftForHerWebElements;

    public void getGiftIdeasWebElements(){
        PopUpBestBuy();
        sleepFor(7);
        clickOnGiftIdeaElements.click();
        clickOnGiftForHerWebElements.click();
        sleepFor(3);
        driver.navigate().to("https://www.bestbuy.com");

    }

   @FindBy(xpath = "//button[@class='btn-unstyled device-redirect-link']")
    public static WebElement clickMobileSiteWebeElements;
    @FindBy(xpath = "//input[@id='gh-search-input']")
    public static WebElement clickMobileSiteSearchBarWebeElements;

    public void getMobileSiteElements(){
        PopUpBestBuy();
        sleepFor(7);
        clickMobileSiteWebeElements.click();
        sleepFor(5);
        clickMobileSiteSearchBarWebeElements.click();
        sleepFor(5);
        driver.navigate().to("https://www.bestbuy.com");
    }



}


