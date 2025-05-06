import PageObjects.ConstructionPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования Конструктора
 */
@RunWith(Parameterized.class)
public class ConstructionTest {

    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private ConstructionPage consructionPage;
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        consructionPage = new ConstructionPage(driver);
        driver.get(URL);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public ConstructionTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Переход в раздел 'Соусы'")
    public void testSaucesSection() {
        consructionPage.clickSaucesSection();
        assertEquals("Соусы", consructionPage.getSaucesHeaderText());
    }

    @Test
    @Description("Переход в раздел 'Начинки'")
    public void testFillingsSection() {
        consructionPage.clickFillingsSection();
        assertEquals("Начинки", consructionPage.getFillingsHeaderText());
    }

    @Test
    @Description("Перехода в раздел 'Булки'")
    public void testBunsSection() {
        consructionPage.clickSaucesSection();
        consructionPage.clickBunsSection();
        assertEquals("Булки", consructionPage.getBunsHeaderText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
