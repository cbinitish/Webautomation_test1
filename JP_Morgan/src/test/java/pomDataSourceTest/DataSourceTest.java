package pomDataSourceTest;

import common.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pomDataSource.DataSource;

public class DataSourceTest extends CommonAPI {

    DataSource dataSource;

    @BeforeMethod
    public void pageFactory(){
        dataSource = PageFactory.initElements(driver,DataSource.class);
    }

    @Test
    public void testinsertDataIntoDB(){
        dataSource.insertDataIntoDB();
    }
}
