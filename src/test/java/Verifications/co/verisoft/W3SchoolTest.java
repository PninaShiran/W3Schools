package Verifications.co.verisoft;

import co.verisoft.fw.utils.Asserts;
import org.example.pageObjects.co.verisoft.*;
import org.example.util.co.verisoft.UtilFile;
import co.verisoft.fw.extentreport.ExtentReport;
import co.verisoft.fw.selenium.drivers.factory.DriverCapabilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static co.verisoft.fw.utils.Asserts.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtentReport
//@ExtendWith({DriverInjectionExtension.class, SeleniumLogExtesion.class})
public class W3SchoolTest {

    HomePage homePage;

    ChromeDriver driver;

    JavaTutorialPage javaTutorialPage;

    W3BasePage basePage;

    HtmlPage htmlPage;

    IntroductionJava introductionJava;

    HtmlTablePage htmlTablePage;

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

        introductionJava = new IntroductionJava(driver);

        htmlTablePage = new HtmlTablePage(driver);

        htmlPage = new HtmlPage(driver);

        basePage = new W3BasePage(driver);

        driver.get("https://www.w3schools.com/#gsc.tab=0");
    }


    @Test
    public void w3SchoolsTest() throws InterruptedException {
        assertTrue(homePage.isOnPage());

        homePage.insertValue("java");
        assertTrue(homePage.checkListContainValue("java"), "value not Appears");
        homePage.clickTopic(UtilFile.getData("JAVA Tutorial"));

        assertTrue(basePage.equalMainTopicList(basePage.getMainTopicLinks(), UtilFile.getListFromXml("expectedTopics")), "Main topic not as expected");

        assertTrue(basePage.equalSubTopicList(javaTutorialPage.getJavaOutputList(), UtilFile.getListFromXml("JavaOutput")), "SubTopic not as expected");
        assertTrue(basePage.equalSubTopicList(javaTutorialPage.getJavaVariableList(), UtilFile.getListFromXml("JavaVariables")), "SubTopic not as expected");

        assertTrue(javaTutorialPage.isOnPage());
        basePage.clickNextButton();

        assertTrue(introductionJava.isOnPage());
        basePage.clickPreviousButton();

        assertTrue(javaTutorialPage.isOnPage());

        assertTrue(htmlPage.isOnPage());
        basePage.clickTopicLink("HTML");

        assertTrue(javaTutorialPage.isOnPage());

        basePage.clickMainTopicLink("HTML Tables");

        assertEquals(htmlTablePage.getColumnNames(), UtilFile.getListFromXml("nameColumn"), "Column names not as expected");

        assertEquals(htmlTablePage.getContactForCompany(0), UtilFile.getData("MariaAnders"), "Contact not as expected");
        assertEquals(htmlTablePage.getContactForCompany(1), UtilFile.getData("FranciscoChang"), "Contact not as expected");

        assertEquals(htmlTablePage.getCountryForCompany(0), UtilFile.getData("Germany"), "Country not as expected");
        assertEquals(htmlTablePage.getCountryForCompany(1), UtilFile.getData("Mexico"), "Country not as expected");
    }


    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

}
