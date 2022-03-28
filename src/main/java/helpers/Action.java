package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * класс обертка над Action
 */

public class Action {

    /**
     * метод перемещает к элементу с переданным локатором
     * @param locator локатор элемента
     * @param driver драйвер
     */
    public static void moveToElement(String locator, WebDriver driver){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
    }
}
