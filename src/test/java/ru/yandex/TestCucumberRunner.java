package ru.yandex;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * класс запуста кукумбера
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/java/ru/yandex/features/featureFile.feature",
        glue = "ru.yandex.stepDef"
)
public class TestCucumberRunner {
}
