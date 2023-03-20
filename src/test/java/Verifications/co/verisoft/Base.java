package Verifications.co.verisoft;

import co.verisoft.fw.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class Base extends BasePage {
    public Base(WebDriver driver) {
        super(driver);
    }


    @Override
    public boolean isOnPage() {
        return false;
    }

}
