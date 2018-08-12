package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class YandexSimpleTest extends BaseTest {

    @Test
    public void simpleTest(){
        driver.get("http://yandex.ru");
        WebElement enterToEmail = driver.findElement(By.xpath("//a[contains(@class,'login-enter')]"));
        enterToEmail.click();
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='login']"));
        inputEmail.sendKeys("some@test.com");
    }
}
