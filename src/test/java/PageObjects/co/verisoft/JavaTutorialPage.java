package PageObjects.co.verisoft;

import Util.co.verisoft.UtilFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class JavaTutorialPage extends BasePage {
    public JavaTutorialPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getJavaVariableList() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/div[2]/a"));
    }


    public List<WebElement> getJavaOutputList() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/div[1]/a"));
    }

}
