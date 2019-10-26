package common;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver;
    public static ExtentReports extent;

    @Parameters({"platform", "url", "browser", "cloud", "browserVersion", "envName"})
    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, String browser,
                                        boolean cloud, String browserVersion, String envName) {
        if (cloud) {
            driver = getCloudDriver();
        } else {
            driver = getLocalDriver(browser, platform);
        }
        driver.get(url);
        return driver;
    }

    public static WebDriver getLocalDriver(String browser, String platform) {
        //chrome popup
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");

        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","/Users/iftakerahmed/IdeaProjects/frameworkByGroupOne/Generic/src/main/resources/Browser_Drivers/chromedriver 2");
            driver = new ChromeDriver(chromeOptions);
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mehedi\\IdeaProjects\\FrameworkGroup\\WebAutomationFrameWork_2019\\Generic\\src\\main\\resources\\Browser_Drivers\\chromedriver1.exe");
            driver = new ChromeDriver(chromeOptions);
        } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/Browser_Drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "../Generic/src/main/resources/Browser_Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getCloudDriver() {
        return driver;
    }

    //screenshot
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
            ;
        }
    }

    //reporting starts
//    @BeforeSuite
//    public void extentSetup(ITestContext context) {
//        ExtentManager.setOutputDirectory(context);
//        extent = ExtentManager.getInstance();
//    }
//
//    @BeforeMethod
//    public void startExtent(Method method) {
//        String className = method.getDeclaringClass().getSimpleName();
//        ExtentTestManager.startTest(method.getName());
//        ExtentTestManager.getTest().assignCategory(className);
//    }
//
//    protected String getStackTrace(Throwable t) {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        t.printStackTrace(pw);
//        return sw.toString();
//    }
//
//    @AfterMethod
//    public void afterEachTestMethod(ITestResult result) {
//        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
//        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
//        for (String group : result.getMethod().getGroups()) {
//            ExtentTestManager.getTest().assignCategory(group);
//        }
//
//        if (result.getStatus() == 1) {
//            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//        } else if (result.getStatus() == 2) {
//            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
//        } else if (result.getStatus() == 3) {
//            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
//        }
//
//        ExtentTestManager.endTest();
//        extent.flush();
//        if (result.getStatus() == ITestResult.FAILURE) {
//            captureScreenshot(driver, result.getName());
//        }
//    }
//
//    private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();
//    }
//
//    @AfterSuite
//    public void generateReport() {
//        extent.close();
//    }
    //reporting finish

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        sleepFor(3);
        driver.close();
        driver.quit();
    }

    public static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // commmon methods

//    public void clickOnElementByXpath(String locator) {  1
//        driver.findElement(By.xpath(locator)).click();
//    }


    //    public void clickOnElementById(String locator) { 2
//        driver.findElement(By.id(locator)).click();
//    }
    public static void clickOnElement(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.id(locator)).click();
            } catch (Exception e1) {
                try {
                    driver.findElement(By.className(locator)).click();
                } catch (Exception e2) {
                    try {
                        driver.findElement(By.cssSelector(locator)).click();
                    } catch (Exception e3) {
                        driver.findElement(By.linkText(locator)).click();
                    }
                }
            }
        }
    }

    //    public void typeOnElementByXpath(String locator, String value) {
//        driver.findElement(By.xpath(locator)).sendKeys(value);
//    }
//
//    public void typeOnElementById(String locator, String value) {
//        driver.findElement(By.id(locator)).sendKeys(value);
//    }
    public static void typeOnElement(String locator, String keys) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(keys,Keys.ENTER);
        } catch (Exception e) {
            try {
                driver.findElement(By.id(locator)).sendKeys(keys,Keys.ENTER);
            } catch (Exception e1) {
                try {
                    driver.findElement(By.className(locator)).sendKeys(keys,Keys.ENTER);
                } catch (Exception e2) {
                    try {
                        driver.findElement(By.cssSelector(locator)).sendKeys(keys,Keys.ENTER);
                    } catch (Exception e3) {
                        driver.findElement(By.linkText(locator)).sendKeys(keys,Keys.ENTER);
                    }
                }
            }
        }
    }

    //    public String getValueByXpath(String locator) {
//        return driver.findElement(By.xpath(locator)).getText();
//    }
    public static String getValue(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).getText();
        } catch (Exception e) {
            try {
                return driver.findElement(By.id(locator)).getText();
            } catch (Exception e1) {
                try {
                    return driver.findElement(By.className(locator)).getText();
                } catch (Exception e2) {
                    try {
                        return driver.findElement(By.cssSelector(locator)).getText();
                    } catch (Exception e3) {
                        return driver.findElement(By.linkText(locator)).getText();
                    }
                }
            }
        }
    }


    //    public boolean isElementDisplayed(String locator) {
//        return driver.findElement(By.xpath(locator)).isDisplayed();
//    }
    public static boolean isElementDisplayed(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (Exception e) {
            try {
                return driver.findElement(By.id(locator)).isDisplayed();
            } catch (Exception e1) {
                try {
                    return driver.findElement(By.className(locator)).isDisplayed();
                } catch (Exception e2) {
                    try {
                        return driver.findElement(By.cssSelector(locator)).isDisplayed();
                    } catch (Exception e3) {
                        return driver.findElement(By.linkText(locator)).isDisplayed();
                    }
                }
            }
        }
    }


    //    public boolean isElementEnabled(String locator) {
//        boolean flag = true;
//        flag = driver.findElement(By.xpath(locator)).isEnabled();
//        return flag;
//    }
    public static boolean isElementEnabled(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isEnabled();
        } catch (Exception e) {
            try {
                return driver.findElement(By.id(locator)).isEnabled();
            } catch (Exception e1) {
                try {
                    return driver.findElement(By.className(locator)).isEnabled();
                } catch (Exception e2) {
                    try {
                        return driver.findElement(By.cssSelector(locator)).isEnabled();
                    } catch (Exception e3) {
                        return driver.findElement(By.linkText(locator)).isEnabled();
                    }
                }
            }
        }
    }

    //    public boolean isElementSelected(String locator) {
//        boolean flag = true;
//        flag = driver.findElement(By.xpath(locator)).isSelected();
//        return flag;
//    }
    public static boolean isElementSelected(String locator) {
        try {
            return driver.findElement(By.xpath(locator)).isSelected();
        } catch (Exception e) {
            try {
                return driver.findElement(By.id(locator)).isSelected();
            } catch (Exception e1) {
                try {
                    return driver.findElement(By.className(locator)).isSelected();
                } catch (Exception e2) {
                    try {
                        return driver.findElement(By.cssSelector(locator)).isSelected();
                    } catch (Exception e3) {
                        return driver.findElement(By.linkText(locator)).isSelected();
                    }
                }
            }
        }
    }

    //    public WebElement getElement(String locator) {
//        WebElement element = driver.findElement(By.xpath(locator));
//        return element;
//    }
//}
    public static WebElement getElement(String locator) {
        try {
            return driver.findElement(By.xpath(locator));
        } catch (Exception e) {
            try {
                return driver.findElement(By.xpath(locator));
            } catch (Exception e1) {
                try {
                    return driver.findElement(By.xpath(locator));
                } catch (Exception e2) {
                    try {
                        return driver.findElement(By.xpath(locator));
                    } catch (Exception e3) {
                        return driver.findElement(By.xpath(locator));
                    }
                }
            }
        }

    }

    public WebElement getElementByLinkText(String locator) {
        return driver.findElement(By.linkText(locator));
    }


    public void dragNdropByXpaths(String fromLocator, String toLocator) {
        Actions actions = new Actions(driver);
        WebElement from = getElement(fromLocator);
        WebElement to = getElement(toLocator);
        actions.dragAndDrop(from, to).build().perform();
    }

    public void scrollIntoView(String locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getElementByLinkText(locator));
    }

    public static void mouseOver(String locator) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(locator));
        action.moveToElement(element).perform();
    }

    public static void playVideo(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //javascriptExecutor("driver.getEle")
    }


    public static List<String> getListOfString(List<WebElement> list){    // not getting any value from locator
        List<String> items = new ArrayList<String>();
        for (WebElement element : list){
            items.add(element.getText());
        }
        return items;

    }
    public static List<WebElement> getListOfString(String locator){  //returning the list of webElement
        List<WebElement> element = new ArrayList<WebElement>();
        element = driver.findElements(By.xpath(locator));
//        for (int i=0;i<element.size();i++){
//            System.out.println(element.get(i));
//        }
        return element;

    }
    public static List<String> getTextFromWebElement(String locator){  // return a list of string from webElement
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.xpath(locator));
        for (WebElement web : element){
            String st = web.getText();
            text.add(st);
        }
        return text;

    }
    // create a method to select one value from webElement list. something like dropDwon bar will work.
    public static void getElementFromWebElementList(String locator, int num){
        WebElement element =driver.findElement(By.xpath(locator));
        Select select = new Select(element);
        select.selectByIndex(num);
    }
    public static void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void dismissAlert(){
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    public static void navBack(){
        driver.navigate().back();
    }
    public static void navForward(){
        driver.navigate().forward();
    }

    // Explicit Wait
    public void waitExplicitlyByXpath(String locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.visibilityOf(getElement(locator)));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
        public void waitExplicitlyBy(String locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }


    public void waitUntilSelectable(String locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.elementToBeSelected(getElement(locator)));
    }

    public void waitUntilClickable(String locator, int seconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    //getLink
    public String getAllLink() {
        return driver.findElement(By.tagName("a")).getText();
    }

    public List<String> getAllLinks() {
        List<WebElement> webElementsList = driver.findElements(By.tagName("a"));
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < webElementsList.size(); i++) {
            stringList.add(webElementsList.get(i).getText());
        }
        return stringList;
    }
    public void uploadFileByXpath(String path, String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(path);
    }

    public void clearFieldByXpath(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    public void typeEnterByXpath(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }

    public Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }



}