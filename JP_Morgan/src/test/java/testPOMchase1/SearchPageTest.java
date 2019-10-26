package testPOMchase1;

import POMchase1.SearchPage;
import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchPageTest extends CommonAPI{

    //SearchPage searchPage = new SearchPage();
   //SearchPage searchPage = PageFactory.initElements(CommonAPI.driver,SearchPage.class);

    SearchPage searchPage;
    @BeforeMethod
    private void initElements(){
        searchPage =PageFactory.initElements(driver,SearchPage.class);
    }

    @Test
    public void TestSearchBox(){
        searchPage.searchBox("saving account");
    }

}
