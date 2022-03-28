package pages;

import helpers.Waits;
import helpers.Action;
import org.openqa.selenium.*;

import java.util.List;

/**
 * класс для работы с фильтрами при выборке товаров
 */

public class SelectOnYandexMarketPage extends YandexMarketPage {

    String selectorPriceFrom = "//input[@name='Цена от']";
    String selectorPriceTo = "//input[@name='Цена до']";
    String selectFilter = "//legend[text()='";
    String selectShowAll1 = "//button[text()='Показать всё']";


    public SelectOnYandexMarketPage(WebDriver driver) {
        super(driver);
    }

    /**
     * метод для фильтрации продукции по цене
     * @param from минимальное значения цены
     * @param to максимальное значения цены
     */
    public void selectProductByPrice(String from, String to){
        Waits.presenceOfElementLocated(selectorPriceFrom);
        WebElement priceFrom = driver.findElement(By.xpath(selectorPriceFrom));
        priceFrom.click();
        priceFrom.sendKeys(from);
        WebElement priceTo = driver.findElement(By.xpath(selectorPriceTo));
        priceTo.click();
        priceTo.sendKeys(to);
    }


    /**
     * метод возвращения локатора с именем типо фильтрации
     * @param type устанавливаемый тип фильтра
     * @return локатора с именем фильтра
     */
    public String getSearchType(String type){
        return selectFilter+type+"']/..";
    }

    /**
     * метод для развертывания всего списка
     * @param type тип фильтра
     * @return в зависисмости от наличия элемента возвращает null или элемент
     */
    public WebElement showAll(String type) {
        try {
            driver.findElement(By.xpath(getSearchType(type)+selectShowAll1));
        } catch (NoSuchElementException e){
            return null;
        }
        return driver.findElement(By.xpath(getSearchType(type)+selectShowAll1));
    }

    /**
     * метод для установления типа и характеристик при выборке
     * @param type тип фильтра
     * @param list характеристики
     */
    public void selectProductByParameter(String type, List<String> list) {
        if (showAll(type)!=null) showAll(type).click();
        Waits.presenceOfElementLocated("//ul[@class='_5rop']//li[3]");
        Action.moveToElement("//ul[@class='_5rop']//li[last()]", driver);
        for (String name : list){
            Action.moveToElement(selectFilter+type+"']/..//span[text()='"+name+"']", driver);
            Waits.presenceOfElementLocated(selectFilter+type+"']/..//span[text()='"+name+"']");
            driver.findElement(By.xpath(selectFilter+type+"']/..//span[text()='"+name+"']")).click();
        }
    }
}
