import PageObjects.LoginPage;
import PageObjects.RegistrationPage;
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

import static org.junit.Assert.assertEquals;

/**
 * Класс тестирования выхода из ЛК
 */
@RunWith(Parameterized.class)
public class LogoutTest {

    private final String URL = "https://stellarburgers.nomoreparties.site/";
    private final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";
    private final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private RegistrationPage registrationPage;
    private LoginPage loginPage;

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
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        driver.get(URL);
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public LogoutTest(String browser) {
        this.browser = browser;
    }

    @Test
    @Description("Выход из аккаунта по кнопке «Выйти» в личном кабинете")
    public void testExitButton() {
        registrationPage.clickLoginAccountButton();
        loginPage.enterEmail("katja1@mail.ru");
        loginPage.enterPassword("8bmVHu%");
        loginPage.submitLogin();
        loginPage.clickPersonalCabinetButton();
        WebDriverWait wait = new WebDriverWait(driver, 10); // 10 секунд ожидания
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Профиль']")));
        loginPage.clickExit();
        WebDriverWait wait1 = new WebDriverWait(driver, 10); // 10 секунд ожидания
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/main/div/h2")));
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
