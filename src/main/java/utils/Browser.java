package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

/**
 * Class which will build web browser and open an specific website.
 *
 * @author N Z Angelov
 */
public class Browser {
    public static WebDriver driver;

    /**
     * Setting web browser
     * It opens entered browser and maximizing the window
     *
     * @param url accepting an website to open in the newly set browser
     */

    public static void openPage(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
}

    /**
     * Quiting the web browser
     */
    public static void quitBrowser() {
        driver.quit();
    }

    /**
     * Closing only the currently opened page
     */
    public static void closePage() {
        driver.close();
    }
}
