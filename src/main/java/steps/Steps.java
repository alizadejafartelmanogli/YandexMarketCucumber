package steps;


import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.*;

import java.util.List;

/**
 * клас с шагами теста
 */
public class Steps{


    @Step("открыть каталог {catalogName}")
    public static void goCatalog(YandexPage page, String catalogName){
        page.goCatalog(catalogName);
    }

    @Step("Открыть категорию {category} и {subCategory}")
    public static void goCategory(YandexMarketPage page, String category, String subCategory){
        page.goToCategory(category, subCategory);
    }

    @Step("Выбрать цену от {from} до {to}")
    public static void selectByPrice(SelectOnYandexMarketPage page, String from, String to){
        page.selectProductByPrice(from, to);
    }

    @Step("Выбрать тип фильтра {type} - {name}")
    public static void selectByName(SelectOnYandexMarketPage page, String type, List<String> consumerNames) {
        page.selectProductByParameter(type, consumerNames);
    }

    @Step("Выбрать {count} эдементов на странице")
    public static void selectCountElementsOnPage(SelectCountElementsOnPage page, String count){
        page.selectCountElementsOnPage(count);
    }

    @Step("Проверить что {count} элементов на странице")
    public static void checkCountElementsOnPage(SelectCountElementsOnPage page, String count){
        Assertions.assertTrue(page.checkCountResultsOnPage(count), "elements count on page not equals "+count);
    }

    @Step("первый элемент на странице")
    public static void searchElementOnMarket(SearchElementOnPage page){
        page.searchElement();
    }

    @Step("Проверить эелемент с первым элементом после поиска")
    public static void checkElementOnMarket(SearchElementOnPage page){
        Assertions.assertTrue(page.checkFinderElement(), "found element not equals");
    }
}
