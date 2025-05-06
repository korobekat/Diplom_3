import PageObjects.LoginPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования перехода из ЛК в Конструктор
 */
@RunWith(Parameterized.class)
public class FromAccountToTheConstructionTest {
    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private LoginPage loginPage;
    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/";

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
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public FromAccountToTheConstructionTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по клику на кнопку 'Конструктор'")
    public void testConstructorButtonFromPersonalCabinet() {
        loginPage.clickPersonalCabinetButton();
        loginPage.enterEmail("katja1@mail.ru");
        loginPage.enterPassword("8bmVHu%");
        loginPage.submitLogin();
        loginPage.clickPersonalCabinetButton();
        loginPage.clickConstructor();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void testConstructorButtonFromStellarBurgersLogo() {
        loginPage.clickPersonalCabinetButton();
        loginPage.enterEmail("katja1@mail.ru");
        loginPage.enterPassword("8bmVHu%");
        loginPage.submitLogin();
        loginPage.clickPersonalCabinetButton();
        loginPage.clickStellarBurgersLogo();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
