package org.example.pageObjects.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * The JavaTutorialPage class represents a web page that contains tutorials.
 * It provides methods to verify the content of the  JavaTutorial page.
 * This class extends the BasePage class and overrides the isOnPage() method.
 */
public class JavaTutorialPage extends BasePage {

    public JavaTutorialPage(WebDriver driver) {
        super(driver);
    }


    /**
     * Overrides the isOnPage() method inherited from the BasePage class to determine whether the current page is the Java Tutorial page.
     * This method checks whether the table element appears on the current page
     * to determine if the current page is the Java Tutorial page.
     *
     * @return True if the current page is the Java Tutorial page according to the JavaOutputList element, false otherwise
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage((WebElement) getJavaOutputList());
    }


    /**
     * Gets the list of Java variables on the Java tutorial page.
     *
     * @return a list of WebElements representing Java variables on the Java tutorial page
     */
    public List<WebElement> getJavaVariableList() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/div[2]/a"));
    }


    /**
     * Gets the list of Java output sections on the Java tutorial page.
     *
     * @return a list of WebElements representing Java output sections on the Java tutorial page
     */
    public List<WebElement> getJavaOutputList() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/div[1]/a"));
    }

}
