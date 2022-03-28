package ru.yandex.stepDef;


import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import drivers.DriverManager;
import helpers.SwitchWindow;
import org.openqa.selenium.WebDriver;
import pages.*;
import steps.Steps;


import java.util.List;

/**
 * класс с шагами для feature файла
 */

public class StepDefinition{

    WebDriver driver;

    @Before
    public void before(){
        DriverManager.initChromeDriver();
        driver = DriverManager.getDriver();
    }

    @Given("Открыть страницу {string}")
    public void openPage(String url){
        driver.get(url);
    }


    @When("Перейти в {string}")
    public void openMarket(String catalog){
        YandexPage page = new YandexPage(driver);
        page.goCatalog(catalog);
        SwitchWindow.switchToTheNewWindow(driver);
    }

    @And("Перейти в {string}, {string}")
    public void openCategory(String category, String subCategory){
        YandexMarketPage page = new YandexMarketPage(driver);
        Steps.goCategory(page, category, subCategory);
    }

    @And("Выбираем фильтры цена от {string} до {string}, {string} - list:")
    public void setFilters(String priceFrom, String priceTo,
                           String type, List<String> list){
        SelectOnYandexMarketPage page = new SelectOnYandexMarketPage(driver);
        Steps.selectByPrice(page, priceFrom, priceTo);
        Steps.selectByName(page, type, list);
    }

    @And("Выводим на экран по {string} элементов")
    public void setCountOfElement(String count){
        SelectCountElementsOnPage page = new SelectCountElementsOnPage(driver);
        Steps.selectCountElementsOnPage(page, count);
    }

    @Then("Проверить что на экран выводится по {string} значений")
    public void checkCountElementOnPage(String count){
        SelectCountElementsOnPage page = new SelectCountElementsOnPage(driver);
        Steps.checkCountElementsOnPage(page, count);
    }

    @When("В результатах поиска взять название первого товара, найти его через поиск")
    public void getFirstElementFromResultPage(){
        SearchElementOnPage page = new SearchElementOnPage(driver);
        Steps.searchElementOnMarket(page);
    }

    @Then("Сравнить имя первого продукта результата поиска с нашим")
    public void checkElementOnPage(){
        SearchElementOnPage page = new SearchElementOnPage(driver);
        Steps.checkElementOnMarket(page);
    }
}
