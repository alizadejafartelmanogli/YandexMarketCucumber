package pages;

import helpers.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * класс главной страницы яндекс маркета
 */

public class YandexMarketPage {

    String openCatalogSelector = "//button[@id='catalogPopupButton']";
    String catalogSelector1 = "//div[@data-apiary-widget-name='@MarketNode/HeaderCatalog']//ul[@class='_2OFlF']//span[text()='";
    String catalogSelector2 = "//ul[@data-autotest-id='subItems']//a[text()='";

    WebDriver driver;


    public YandexMarketPage(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * медот для выбора категории товара на маркете
     * @param category категория продукта
     * @param subCategory подкатегория продукта
     */
    public void goToCategory(String category, String subCategory){
        WebElement element1 = driver.findElement(By.xpath(openCatalogSelector));
        element1.click();
        Waits.presenceOfElementLocated(catalogSelector1+category+"']/..");
        WebElement element2 = driver.findElement(By.xpath(catalogSelector1+category+"']/.."));
        element2.click();
        Waits.presenceOfElementLocated(catalogSelector2+subCategory+"']");
        WebElement element3 = driver.findElement(By.xpath(catalogSelector2+subCategory+"']"));
        element3.click();
    }
}

