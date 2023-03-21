package PageObjects.co.verisoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HtmlTablePage extends BasePage {

    public HtmlTablePage(WebDriver driver) {
        super(driver);
    }


    public String getContactForCompany(int index) {
        WebElement table = driver.findElement(By.id("customers"));
        WebElement row = table.findElements(By.tagName("tr")).get(index + 1);
        return row.findElements(By.tagName("td")).get(1).getText();
    }


    public String getCountryForCompany(int index) {
        WebElement table = driver.findElement(By.id("customers"));
        WebElement row = table.findElements(By.tagName("tr")).get(index + 1);
        return row.findElements(By.tagName("td")).get(2).getText();
    }


    public List<String> getColumnNames() {
        List<String> columnNames = new ArrayList<>();
        WebElement table = driver.findElement(By.id("customers"));
        List<WebElement> columns = table.findElements(By.tagName("th"));
        for (WebElement columnName : columns) {
            columnNames.add(columnName.getText());
        }
        return columnNames;
    }

}
