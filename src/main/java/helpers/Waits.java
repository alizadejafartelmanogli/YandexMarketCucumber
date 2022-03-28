package helpers;


import drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * класс обертка для явных ожиданий
 */
public class Waits {

    /**
     * метод ждет появления элента в дом
     * @param webElement элемент который ожидаем
     */
    public static void presenceOfElementLocated(String webElement){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(webElement)));
    }

    /**
     * метод ждет когда появится и исчезнет невидимое окно
     * @param webElement элемент который ожидаем
     */
    public static void visibilityAndClickableOfElementLocated(String webElement){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(webElement)));
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(webElement)));

    }
}
