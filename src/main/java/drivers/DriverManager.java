package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * класс для работы с драйвером
 */

public class DriverManager {

    private static WebDriver driver;

    /**
     *
     * @return возвращает драйвер
     */
    public static WebDriver getDriver() {
        return driver;
    }


    /**
     * метод для инициализации драйвера
     */
    public static void initChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
