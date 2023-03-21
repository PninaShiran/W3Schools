package PageObjects.co.verisoft;


import Verifications.co.verisoft.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class HomePage extends Base {

    @FindBy(id = "search2")
    private WebElement txt_search;

    @FindBy(xpath = "//div[@id='listofsearchresults']/a")
    private List<WebElement> listSearch;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void insertValue(String nameSubject) {
        this.txt_search.sendKeys(nameSubject);
    }


    public void checkListContainValue(String keyWord) {
        int i;
        for (i = 0; i < this.listSearch.size() && !this.listSearch.get(i).getText().contains(keyWord); i++) ;
        if (this.listSearch.size() == i)
            System.out.println("The value Appears at listSearch ");
        else System.out.println("The value not Appears ");
    }


    public void clickTopic(String nameSubject) {
        for (WebElement subject : this.listSearch) {
            if (subject.getText().equals(nameSubject)) {
                subject.click();
                break;
            }
        }
    }

}

