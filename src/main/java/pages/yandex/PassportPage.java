package pages.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PassportPage extends PageObject {

    private final static By LOGIN_INPUT = By.xpath("//input[@name='login']");

    public PassportPage(WebDriver driver) {
        super(driver);
    }

    public void inputToLogin(String loginName){
        WebElement inputEmail = driver.findElement(LOGIN_INPUT);
        inputEmail.sendKeys(loginName);
    }
}
