import PageObjects.LoginPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования Личного кабинета
 */
@RunWith(Parameterized.class)
public class AccountLoginTest {

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
    private final String LOGIN_URL2 = "https://stellarburgers.nomoreparties.site/account/profile";

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
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public AccountLoginTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Переход в личный кабинет по клику на «Личный кабинет»")
    public void testLoginViaButtonPersonalCabinetIntoPersonalCabinet() {
        loginPage.clickPersonalCabinetButton();
        loginPage.enterEmail("katja@mail.ru");
        loginPage.enterPassword("1111111");
        loginPage.submitLogin();
        loginPage.clickPersonalCabinetButton();
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 секунд ожидания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Профиль']")));
        assertEquals(LOGIN_URL2, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
