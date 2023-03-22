package org.example.pageObjects.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

/**
 * The W3BasePage class represents a base page for W3Schools website that provides
 * methods for base elements that appear in all pages of the application.
 * This class extends the BasePage class and overrides the isOnPage() method.
 */
public class W3BasePage extends BasePage {
    public W3BasePage(WebDriver driver) {
        super(driver);
    }


    /**
     * Overrides the isOnPage() and checks if the base element appears on the page.
     *
     * @return true if the base element is present on the page, otherwise false
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage((WebElement) getMainTopicLinks());
    }


    /**
     * Gets the list of main topic links on the page.
     *
     * @return a list of WebElements representing main topic links on the page
     */
    public List<WebElement> getMainTopicLinks() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']//a"));
    }


    /**
     * Determines whether the given actual list of main topic links is equal to the expected list of main topic links.
     *
     * @param actualListTopic   the actual list of main topic links to compare
     * @param expectedListTopic the expected list of main topic links to compare
     * @return true if the actual list of main topic links is equal to the expected list of main topic links, otherwise false
     */
    public boolean equalMainTopicList(List<WebElement> actualListTopic, List<String> expectedListTopic) {
        List<String> newMainTopics = new ArrayList<>();

        for (int i = 0; i < actualListTopic.size(); i++) {
            newMainTopics.add(actualListTopic.get(i).getText());
        }

        return newMainTopics.equals(actualListTopic);
    }


    /**
     * Determines whether the given actual list of sub topic links is equal to the expected list of sub topic links.
     *
     * @param actualListSubTopic   the actual list of sub topic links to compare
     * @param expectedListSubTopic the expected list of sub topic links to compare
     * @return true if the actual list of sub topic links is equal to the expected list of sub topic links, otherwise false
     */
    public boolean equalSubTopicList(List<WebElement> actualListSubTopic, List<String> expectedListSubTopic) {
        List<String> newMainTopics = new ArrayList<>();

        for (int i = 0; i < actualListSubTopic.size(); i++) {
            newMainTopics.add(actualListSubTopic.get(i).getAttribute("innerHTML"));
        }

        return newMainTopics.equals(expectedListSubTopic);
    }


    /**
     * Looks for the topic in the left topic list and clicks on the link with the given name
     *
     * @param topic the name of the main topic link to click
     */
    public void clickMainTopicLink(String topic) {
        for (WebElement link : getMainTopicLinks()) {
            if (link.getText().equals(topic)) {
                link.click();
                break;
            }
        }
    }


    /**
     * Click the "Next" button on the page.
     */
    public void clickNextButton() {
        driver.findElement(By.linkText("Next ❯")).click();
    }


    /**
     * Click the "Previous" button on the page.
     */
    public void clickPreviousButton() {
        driver.findElement(By.linkText("❮ Previous")).click();
    }


    /**
     * Click on the main topic link in the navigation bar corresponding to the specified topic on the list
     *
     * @param topic the name of the topic to click on
     */
    public void clickTopicLink(String topic) {
        driver.findElement(By.xpath("//a[text()='" + topic + "']")).click();
    }

}
