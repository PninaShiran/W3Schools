package org.example.pageObjects.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HtmlPage extends BasePage {

    @FindBy(tagName = "title")
    private WebElement title;

    public HtmlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOnPage() {
        return super.isOnPage(title);
    }

}
