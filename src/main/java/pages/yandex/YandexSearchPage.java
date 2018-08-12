package pages.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YandexSearchPage extends PageObject {

    public YandexSearchPage(WebDriver driver) {
        super(driver);
    }

    private final static By EMAIL_BLOCK = By.xpath("//div[@role='form']");

    private final static By ENTER_TO_EMAIL_BUTTON = By.xpath("./a[contains(@class,'login-enter')]");

    public PassportPage clickOnEnterToEmailButton(){
        WebElement enterToEmail = getRootElement().findElement(ENTER_TO_EMAIL_BUTTON);
        enterToEmail.click();
        return new PassportPage(driver);
    }

    public WebElement getRootElement(){
        return driver.findElement(EMAIL_BLOCK);
    }
}
