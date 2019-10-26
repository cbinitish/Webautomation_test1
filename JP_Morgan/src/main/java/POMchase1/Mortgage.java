package POMchase1;

import common.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mortgage extends CommonAPI {

    @FindBy(xpath = "//img[@src='https://sites.chase.com/content/services/structured-image/image.desktop.jpg/XCRT/Flexible-Templates/Triplets/2018/HomeFinance/52761_IC18-365_IconTrip_384x280_Desktop_FNL.jpg']")
    WebElement chaseMortgageWebElement;
    public WebElement getChaseMortgagePage(){
        return chaseMortgageWebElement;
    }
    public void chaseMortgage(){
        getChaseMortgagePage().click();
    }

    @FindBy(css = "body.topic.hybrid.system-disabled:nth-child(2) div.home__body:nth-child(1) div.layouts:nth-child(7) main.main-content div.main-content__inner div.main-content--dropzone:nth-child(4) div.module-container.scroll-tracking.module-tracked:nth-child(5) div.hero.hero-version-2.left.neutral div.row.feature-container div.hero__inner.col-xs-12 div.hero__img.col-sm-5.bottom-aligned-image > a.video--play-btn.small.icon-play-video.videoLink.chaseanalytics-track-link:nth-child(2)")
    WebElement mortgageVideoButtonWebelement;
    public WebElement getChaseMortgageWebElement(){
        return mortgageVideoButtonWebelement;
    }
    public void playmortgageVideo(){
        getChaseMortgageWebElement().click();
    }

    @FindBy(xpath = "//input[@id='zipCodeInput']")
    WebElement checkRateWithZip;
    public WebElement getCheckRateWithZip() {
        return checkRateWithZip;
    }
    public void checkRateWithZip(String zipCode){
        getCheckRateWithZip().sendKeys(zipCode);
    }

    @FindBy(css = "#zipcodeSubmit")
    WebElement submitZipCode;
    public WebElement getSubmitZipCode(){
        return submitZipCode;
    }
    public void submitZipCode(){
        getSubmitZipCode().click();
    }




    public void checkMortgageRate(){
        chaseMortgage();
        checkRateWithZip("11416");
        submitZipCode();

    }




    public void MortgagePageVideo() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        chaseMortgage();
        js.executeScript("window.scrollBy(0,500)");
        playmortgageVideo();
        //sleepFor(20);

//        Webdriver Element = driver.findElement(By.Id("Id of the frame"));
//        Switch into the frame driver.switchTo().frame(Element);
//        driver.findElement(By.Id("Element of of play button"))
        //js.executeScript("document.getElementByxpath(\"//div[@class='hero__img col-sm-5 bottom-aligned-image']//img\").play()");
    }
}
