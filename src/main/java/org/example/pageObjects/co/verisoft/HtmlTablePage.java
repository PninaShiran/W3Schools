package org.example.pageObjects.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * The HtmlTable class represents the HtmlTablePag page.
 * It provides methods to verify the content of the HtmlTable page.
 * This class extends the BasePage class and overrides the isOnPage() method.
 */
public class HtmlTablePage extends BasePage {
    @FindBy(tagName = "title")
    private WebElement title;

    @FindBy(id = "customers")
    private WebElement table;

    public HtmlTablePage(WebDriver driver) {
        super(driver);
    }


    /**
     * Overrides the isOnPage() method inherited from the BasePage class to determine whether the current page is the htmlTable page.
     * This method checks whether the table element appears on the current page
     * to determine if the current page is the table page.
     *
     * @return True if the current page is the home page according to the title element, false otherwise
     */
    @Override
    public boolean isOnPage() {
        return super.isOnPage(title);
    }


    /**
     * Gets the contact for a company at the specified index in the HTML table.
     *
     * @param index the index of the company to get the contact for
     * @return the contact for the company at the specified index
     */
    public String getContactForCompany(int index) {
        WebElement row = this.table.findElements(By.tagName("tr")).get(index + 1);
        return row.findElements(By.tagName("td")).get(1).getText();
    }


    /**
     * Gets the country for a company at the specified index in the HTML table.
     *
     * @param index the index of the company to get the country for
     * @return the country for the company at the specified index
     */
    public String getCountryForCompany(int index) {
        WebElement row = this.table.findElements(By.tagName("tr")).get(index + 1);
        return row.findElements(By.tagName("td")).get(2).getText();
    }


    /**
     * Gets the column names of the HTML table.
     *
     * @return a list of the column names of the HTML table
     */
    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        List<WebElement> columns = this.table.findElements(By.tagName("th"));
        for (WebElement columnName : columns) {
            columnNames.add(columnName.getText());
        }
        return columnNames;
    }

}
