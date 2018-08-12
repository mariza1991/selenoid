package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.yandex.PassportPage;
import pages.yandex.YandexSearchPage;
import testData.XssCheatSheet;

import java.io.IOException;

public class YandexSequrityTest extends BaseTest {

    @Test(dataProvider = "xssTests", enabled = true)
    public void test(String xssQuery){
        System.out.println(xssQuery);
        driver.get("http://yandex.ru");
        YandexSearchPage mainPage = new YandexSearchPage(driver);
        PassportPage passportPage = mainPage.clickOnEnterToEmailButton();
        passportPage.inputToLogin(xssQuery);
    }

    @DataProvider(name = "xssTests")
    protected Object[][] xssDataProvider() throws IOException {
        String[] lines = XssCheatSheet.myArr;
        Object[][] cheatsheet = new Object[lines.length][1];
        int count = 0;
        for (String line : lines) {
            cheatsheet[count][0] = line;
            count++;
        }
        return cheatsheet;
    }
}
