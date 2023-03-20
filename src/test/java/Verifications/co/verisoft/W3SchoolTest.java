package Verifications.co.verisoft;

import PageObjects.co.verisoft.*;
import Util.co.verisoft.UtilFile;
import co.verisoft.fw.extentreport.ExtentReport;
import co.verisoft.fw.selenium.drivers.factory.DriverCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static co.verisoft.fw.utils.Asserts.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtentReport
//@ExtendWith({DriverInjectionExtension.class, SeleniumLogExtesion.class})
public class W3SchoolTest {
    HomePage homePage;

    ChromeDriver driver;

    JavaTutorialPage javaTutorialPage;

    BasePage basePage;

    HtmlPage htmlPage;

    HtmlTablePage htmlTablePage;

    @DriverCapabilities
    DesiredCapabilities capabilities = new DesiredCapabilities();
    {
        capabilities.setBrowserName("chrome");
    }


    @BeforeEach
    public void openBrowser() throws InterruptedException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        homePage = new HomePage(driver);

        javaTutorialPage = new JavaTutorialPage(driver);

        htmlPage = new HtmlPage(driver);

        htmlTablePage = new HtmlTablePage(driver);

        basePage = new BasePage(driver);

        driver.get("https://www.w3schools.com/#gsc.tab=0");
    }


    @Test
    public void w3SchoolsTest() throws InterruptedException {
        assertTrue(driver.getTitle().equals("W3Schools Online Web Tutorials"));

        homePage.insertValue("java");
        homePage.checkListContainValue("java");
        homePage.clickTopic("JAVA Tutorial");

        assertTrue(basePage.equalMainTopicList(basePage.getMainTopicLinks(), UtilFile.getListFromXml("expectedTopics")), "Main topic not as expected");

        assertTrue(basePage.equalSubTopicList(javaTutorialPage.getJavaOutputList(), UtilFile.getListFromXml("JavaOutput")), "SubTopic not as expected");
        assertTrue(basePage.equalSubTopicList(javaTutorialPage.getJavaVariableList(), UtilFile.getListFromXml("JavaVariables")), "SubTopic not as expected");

        assertTrue(driver.getTitle().equals("Java Tutorial"));
        basePage.clickNextButton();
        assertTrue(driver.getTitle().equals("Introduction to Java"));
        basePage.clickPreviousButton();
        assertTrue(driver.getTitle().equals("Java Tutorial"));


        basePage.clickTopicLink("HTML");
        Thread.sleep(20);
        assertTrue(driver.getTitle().equals("HTML Tutorial"));

        basePage.clickMainTopicLink("HTML Tables");

        assertEquals(htmlTablePage.getColumnNames(), UtilFile.getListFromXml("nameColumn"), "Column names not as expected");

        assertEquals(htmlTablePage.getContactForCompany(0), "Maria Anders", "Contact not as expected");
        assertEquals(htmlTablePage.getContactForCompany(1), "Francisco Chang", "Contact not as expected");

        assertEquals(htmlTablePage.getCountryForCompany(0), "Germany", "Country not as expected");
        assertEquals(htmlTablePage.getCountryForCompany(1), "Mexico", "Country not as expected");
    }


    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
