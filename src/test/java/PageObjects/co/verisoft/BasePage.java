package PageObjects.co.verisoft;

import Util.co.verisoft.UtilFile;
import Verifications.co.verisoft.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends Base {
    public BasePage(WebDriver driver) {
        super(driver);
    }


    public List<WebElement> getMainTopicLinks() {
        return driver.findElements(By.xpath("//div[@id='leftmenuinnerinner']/a"));
    }


    public boolean equalMainTopicList(List<WebElement> expectedListMainTopic, List<String> actualListMainTopic) {
        List<String> newMainTopics = new ArrayList<>();

        for (int i = 0; i < expectedListMainTopic.size(); i++) {
            newMainTopics.add(expectedListMainTopic.get(i).getText());
        }

        return newMainTopics.equals(actualListMainTopic);
    }


    public boolean equalSubTopicList(List<WebElement> expectedListMainTopic, List<String> actualListMainTopic) {
        List<String> newMainTopics = new ArrayList<>();

        for (int i = 0; i < expectedListMainTopic.size(); i++) {
            newMainTopics.add(expectedListMainTopic.get(i).getAttribute("innerHTML"));
        }
        return newMainTopics.equals(actualListMainTopic);
    }


    public void clickMainTopicLink(String topic) {
        for (WebElement link : getMainTopicLinks()) {
            if (link.getText().equals(topic)) {
                link.click();
                break;
            }
        }
    }


    public List<WebElement> getSubtopicDivs(String mainTopic) {
        return driver.findElements(By.xpath("div[@id='leftmenuinnerinner']/a[text()='" + mainTopic + "']/div/a"));
    }


    public void clickNextButton() {
        driver.findElement(By.linkText("Next ❯")).click();
    }


    public void clickPreviousButton() {
        driver.findElement(By.linkText("❮ Previous")).click();
    }


    public void clickTopicLink(String topic) {
        driver.findElement(By.xpath("//a[text()='" + topic + "']" )).click();
    }

}
