package chase1;

import common.CommonAPI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchBarTestFromList extends CommonAPI {

    public static List<String> accounts = new ArrayList<>();

//    @FindBy(className = "header__section__item header__section--search icon-search")
//    public static WebElement searchIcon;

    @FindBy(how = How.XPATH, using = "//a[@class='header__section__item header__section--search icon-search']//")
    public static WebElement searchIcon;

    @FindBy(xpath = "//button[@class='header__section--search__bar--search-icon icon-search chaseanalytics-track-link']")
    public static WebElement submitButtonWebElement;

    @FindBy(how =How.CLASS_NAME, using = "header__section--search__bar--search-input")
    public static WebElement searchBarWebElement;

    public WebElement getSearchBox(){
        return searchBarWebElement;
    }

    public void searchFor(String value){
        getSearchBox().sendKeys(value);
    }

    public WebElement getSubmitButtonWebElement(){
        return submitButtonWebElement;
    }

    public void submitButton(){
        getSubmitButtonWebElement().click();
    }



    public static List<String> searchForAccount(){
        accounts.add("checking account");
        accounts.add("saving account");
        accounts.add("commercial account");
        accounts.add("student account");
        accounts.add("credit card");

        return accounts;
    }

    @Test
    public void searchAccount(){
        searchIcon.click();

        List<String> account = searchForAccount();
        for(String acc : account){
            searchIcon.click();
            searchFor(acc);
            submitButton();
            navBack();
        }
    }

//    @Test
//    public void searchItem(){
//        List<String> searchForAcc = searchForAccount();
//        for (int i = 0; i<searchForAcc.size();i++){
//
//            searchFor(searchForAcc.get(i));
//            submitSearchButton();
//            clearInput();
//        }
//    }


    @Test@Ignore
    public static void search(){
        typeOnElement("//a[@class='header__section__item header__section--search icon-search']","saving");
        sleepFor(10);
    }
//    @Test
//    public static void searchForAccountt(){
//        for (int i = 0; i<accounts.size();i++){
//            List<String> searchFor = searchForAccount();
//            //typeOnElement("//a[@class='header__section__item header__section--search icon-search']");
//            searchIcon.click();
//            String list = accounts.get(i);
//            //SearchingFor(list.get(i));
//            typeOnElement("//a[@class='header__section__item header__section--search icon-search']",list);
//            submitButton.click();
//
//            //typeOnElement("//a[@class='header__section__item header__section--search icon-search']",list);
//            sleepFor(10);
//        }
//
//    }
//    List<String> dataList = new ArrayList<String>();
//
//    @Test(priority = 1)
//    public void searchBarTest(){
//        System.out.println("***********");
////        List<String> dataList = new ArrayList<String>();
//        List<WebElement> elements = getAllElementFromList();
//        int j = elements.size();
//        for (int i=0;i<j;i++){
//            String item = elements.get(i).getText();
//            System.out.println(item);
//            dataList.add(item);
//        }
//        System.out.println("**********");
//        System.out.println(dataList);
//        //return dataList;



}
