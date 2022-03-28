package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * класс стартовой страницы яндекса
 */

public class YandexPage {

    private String selector = "//div[@class='container container__services container__line']//div[@class='services-new__item-title' and text()='";
    protected WebDriver driver;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * метод кликает на выбранную услугу на главной странице яндекса
     * @param clickElement имя выбранной услуги
     */
    public void goCatalog(String clickElement) {
        WebElement element = driver.findElement(By.xpath(selector+clickElement+"']/.."));
        element.click();
    }
}
