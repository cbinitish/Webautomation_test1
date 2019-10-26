package POMchase1;

import common.CommonAPI;
import pomDataSource.DataSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonAPI {

//    @FindBy(className = "header__section__item header__section--search icon-search")
//    public static WebElement searchIcon;

    @FindBy(how = How.XPATH, using = "//a[@class='header__section__item header__section--search icon-search']")
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


    public WebElement getSearchButton() {
        return searchIcon;
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }

    public void clearInput() {
        getSearchBox().clear();
    }

    public void searchBox(String accountName) {
        clickOnSearchButton();
        searchFor(accountName);
        submitButton();
        driver.navigate().back();
    }


















    public static List<String> accounts = new ArrayList<>();

    public void searchItemsAndSubmitButton() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = DataSource.insertDataIntoDB();
        for (int i = 0; i < list.size(); i++) {
            searchFor(list.get(i));
            clickOnSearchButton();
            driver.navigate().back();
            clearInput();
        }

    }

    public void searchItems() throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> itemList = DataSource.searchForAccount();
        for (String st : itemList) {
            searchFor(st);
            clickOnSearchButton();
            driver.navigate().back();
            clearInput();
            //validate items
        }

    }
}
