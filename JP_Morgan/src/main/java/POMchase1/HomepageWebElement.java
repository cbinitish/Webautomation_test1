package POMchase1;

import common.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class HomepageWebElement extends CommonAPI{

    @FindBy(xpath ="//span[@class='chase-text']")
    public static WebElement chaseLogoWebElement;
    @FindBy(xpath = "//a[@class='header__section--dropdown__title__link chaseanalytics-track-link']")
    public static WebElement openAnACoountDD;
    @FindBy(xpath = "//div[@id='icon1']")
    public static WebElement creditCard;
    @FindBy(xpath = "//div[@id='icon2']")
    public static WebElement checkingAccount;
    @FindBy(xpath = "//div[@class='header__section--dropdown__tiles row']//div[2]")
    public static WebElement savingAccount;
    @FindBy(xpath = "//div[@id='icon4']")
    public static WebElement CDS;
    @FindBy(xpath = "//div[@id='icon5']")
    public static WebElement carLones;
    @FindBy(xpath = "//div[@id='icon6']")
    public static WebElement homeMortgage;
    @FindBy(xpath = "//div[@id='icon7']")
    public static WebElement chaseForBusiness;
    @FindBy(xpath = "//div[@id='icon8']")
    public static WebElement commercialBanking;
    @FindBy(xpath = "//div[@id='icon9']")
    public static WebElement seeAllOption;


    public static WebElement getChaseLogoWebElement(){
        return chaseLogoWebElement;
    }

    public void chaseLogo(){
        getChaseLogoWebElement().click();
        //Assert.assertEquals(chaseLogo.isDisplayed(),true);
    }





    public static void mouseOverAccountDropDown(){
        mouseOver("//a[@class='header__section--dropdown__title__link chaseanalytics-track-link']");
        Assert.assertEquals(checkingAccount.isDisplayed(),true);
    }

    public void mouseOverValidate(){
        Assert.assertEquals(openAnACoountDD.isDisplayed(),true);
    }

    public void openAccDDmouseOver(){
       // mouseOver(openAnACoountDD);
    }



    public static void applyForCC(){
       openAnACoountDD.click();
       checkingAccount.click();
        //chaseLogo.click();
    }
    public static void openAccountDD(){

        WebElement element =driver.findElement(By.id("//a[@class='header__section--dropdown__title__link chaseanalytics-track-link']"));
        //WebElement element = openAnACoountDD;
        Select searchBar_Dropdown = new Select(element);
        searchBar_Dropdown.selectByIndex(1);
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cloths");
    }



}
