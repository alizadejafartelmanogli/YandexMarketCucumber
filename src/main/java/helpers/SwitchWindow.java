package helpers;

import drivers.DriverManager;
import org.openqa.selenium.WebDriver;

/**
 * вспомогательный класс для переключения окна в браузере
 */

public class SwitchWindow {

    /**
     * метод для переключения окна в браузере
     * @param driver драйвер
     */
    public static void switchToTheNewWindow(WebDriver driver){
        String originalWindow = DriverManager.getDriver().getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
