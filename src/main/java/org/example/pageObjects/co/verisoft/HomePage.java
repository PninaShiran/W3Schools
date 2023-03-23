package org.example.pageObjects.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * The HomePage class represents the home page of a W3schools website.
 * It provides methods to verify the content of the home page.
 * This class extends the BasePage class and overrides the isOnPage() method.
 */
public class HomePage extends BasePage {
    @FindBy(id = "search2")
    private WebElement txt_search;

    @FindBy(tagName = "title")
    private WebElement title;

    @FindBy(xpath = "//div[@id='listofsearchresults']//a")
    private List<WebElement> listSearch;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    /**
     * Overrides the isOnPage() method inherited from the BasePage class to determine whether the current page is the home page.
     * This method checks whether the listSearch element appears on the current page
     * to determine if the current page is the home page.
     *
     * @return True if the current page is the home page according to the listSearch element, false otherwise
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(title);
    }


    /**
     * Inserts a value into the search input field on the home page.
     *
     * @param nameSubject the value to insert into the search input field
     */
    public void insertValue(String nameSubject) {
        this.txt_search.sendKeys(nameSubject);
    }


    /**
     * Checks whether the list of search results contains the specified keyword.
     *
     * @param keyWord the keyword to search for in the list of search results
     */
    public boolean checkListContainValue(String keyWord) {
        int i;
        for (i = 0; i < this.listSearch.size() && !this.listSearch.get(i).getText().contains(keyWord); i++) ;
        return this.listSearch.size() == i;

    }


    /**
     * Click on the specified topic in the list of search results.
     *
     * @param nameSubject the name of the topic to click on in the list of search results
     */
    public void clickTopic(String nameSubject) {
        for (WebElement subject : this.listSearch) {
            if (subject.getText().equals(nameSubject)) {
                subject.click();
                break;
            }
        }
    }

}

