package HomepagePOM;

import common.CommonAPI;
import dataSource.DataSource;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.util.List;

public class SearchPage extends CommonAPI {
    BestBuyHomePage bestBuyHomePage = PageFactory.initElements(driver, BestBuyHomePage.class);

    @FindBy(how = How.XPATH, using = "//input[@id='gh-search-input']")
    public WebElement searchBox;
    @FindBy(how = How.XPATH, using = "//span[@class='header-search-icon']//img")
    public WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchBox() {
        return searchBox;
    }

    public void clickOnSearchButton() {
        getSearchButton().click();
    }

    public void searchFor(String value) {
        getSearchBox().sendKeys(value);
    }

    public void clearInput() {
        getSearchBox().clear();
    }

    public void searchBox() {
        bestBuyHomePage.PopUpBestBuy();
        sleepFor(3);
        clickOnSearchButton();
        sleepFor(3);
        searchFor("Shop Books");
        sleepFor(2);
        clickOnSearchButton();
        driver.navigate().back();

    }


    public void searchItems()  {
        List<String> itemList = DataSource.getItemValue();
        bestBuyHomePage.PopUpBestBuy();
        for (String list : itemList) {
            sleepFor(3);
            searchFor(list);
            sleepFor(3);
            clickOnSearchButton();
            //sleepFor(3);
            driver.navigate().back();
            //sleepFor(3);
            clearInput();
        }
    }
}
