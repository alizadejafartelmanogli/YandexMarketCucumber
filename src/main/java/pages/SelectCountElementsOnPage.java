package pages;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * класс для установления количества элементов выводимых на страницу и проверки сколько вывелось
 */


import java.util.List;

public class SelectCountElementsOnPage extends SelectOnYandexMarketPage {
    String searchElementLocator = "//span[contains(text(),'Показывать по')]/../..";
    String countElementsLocator = "//button[text()='Показывать по ";
    String searchResultsLocator = "//div[@data-zone-name='snippetList']//article";
    String visibilityAndClickableOfElementLocator = "//div[@class='_8v6CF _2KV_b']";


    public SelectCountElementsOnPage(WebDriver driver) {
        super(driver);
    }


    /**
     * метод выбора количества выводимых на страницу элементов
     * @param count количества выводимых на страницу элементов
     */
    public void selectCountElementsOnPage(String count){
        Waits.visibilityAndClickableOfElementLocated(visibilityAndClickableOfElementLocator);
        Waits.presenceOfElementLocated(searchElementLocator);
        driver.findElement(By.xpath(searchElementLocator)).click();
        driver.findElement(By.xpath(countElementsLocator+count+"']")).click();
    }

    /**
     * дял проверки сколько вывелось эелементов на странице и сколько должно было
     * @param count количества выводимых на страницу элементов
     * @return возвращает булево значения при совпадении ожидаемого количества с актуальным
     */
    public boolean checkCountResultsOnPage(String count){
        Waits.visibilityAndClickableOfElementLocated(visibilityAndClickableOfElementLocator);
        List<WebElement> elementList = driver.findElements(By.xpath(searchResultsLocator));
        return elementList.size() == Integer.parseInt(count);
    }
}