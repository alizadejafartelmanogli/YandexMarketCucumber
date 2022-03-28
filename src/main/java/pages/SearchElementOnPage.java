package pages;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * класс для сравнения первого элемента результатов выборки с ожидаемым
 */


public class SearchElementOnPage extends SelectCountElementsOnPage {
    String resultElementLocator = "//div[@data-zone-name='snippetList']//article//h3[@data-zone-name='title']//a";
    String searchInputLocator = "//input[@id='header-search']";
    String searchButtonLocator = "//button//span[text()='Найти']";

    public SearchElementOnPage(WebDriver driver) {
        super(driver);
    }


    /**
     * возвращает тайтлы элементов поиска на странице
     * @param number порядковый номер элемента поиска
     * @return тектс элемента
     */
    public String getTitleOfElement(int number){
        List<WebElement> titles = driver.findElements(By.xpath(resultElementLocator));
        return titles.get(number).getAttribute("title");
    }

    /**
     * метод ищет в поисковой строке элемент и возвращает первый элемент после поиска
     * @return возвращает первый элемент после поиска
     */
    public String searchElement(){
        WebElement searchInput = driver.findElement(By.xpath(searchInputLocator));
        searchInput.click();
        searchInput.sendKeys(getTitleOfElement(0));
        driver.findElement(By.xpath(searchButtonLocator)).click();
        Waits.presenceOfElementLocated(resultElementLocator);
        return getTitleOfElement(0);
    }

    /**
     * метод сравнивает первый элемент до и после поиска
     * @return возвращает булево значение
     */
    public boolean checkFinderElement(){
        String element = driver.findElement(By.xpath(searchInputLocator)).getAttribute("value");
        return element.equals(getTitleOfElement(0));
    }
}