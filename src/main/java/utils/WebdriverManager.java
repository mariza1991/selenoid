package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WebdriverManager {

    private WebDriver driver;

    private static final String PATH_TO_PROPERTIES = "properties/settings.properties";

    private static final String PROXY = PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "proxy");

    public WebDriver getDriver() {
        String browserName =
                PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "browser");
        if (driver == null) {
            switch (browserName) {
                case "chrome":
                    createChromeDriver(false);
                    break;
                case "chrome-headless":
                    createChromeDriver(true);
                    break;
                case "chrome-remote":
                    createChromeRemote();
                    break;
                case "chrome-selenoid":
                    createSelenoidRemote();
                    break;
                default:
                    createChromeDriver(false);
                    break;
            }
        }
        return driver;
    }

    private WebDriver createChromeDriver(Boolean headless){
        if (headless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private WebDriver createChromeRemote(){
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.3:4444/wd/hub"), //my hub address
                    DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private WebDriver createSelenoidRemote(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("latest");
            //    capabilities.setCapability("enableVNC", "true");

            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
