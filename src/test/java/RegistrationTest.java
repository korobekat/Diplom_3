import PageObjects.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Класс тестирования регистрации пользователя
 */
@RunWith(Parameterized.class)
public class RegistrationTest {

    /**
     * Веб-драйвер
     */
    private WebDriver driver;

    /**
     * Тип Браузера
     */
    private String browser;

    private RegistrationPage registrationPage;
    private final String URL = "https://stellarburgers.nomoreparties.site/";

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return new Object[][]{
                {"chrome"},
                {"yandex"}
        };
    }

    /**
     * Конструктор
     *
     * @param browser Браузер
     */
    public RegistrationTest(String browser) {
        this.browser = browser;
    }

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(browser);
        registrationPage = new RegistrationPage(driver);
        driver.get(URL);
    }

    @Test
    @Description("Проверка успешной регистрации пользователя")
    public void testSuccessfulRegistration() {
        registrationPage.clickLoginAccountButton();
        registrationPage.scrollToRegisterButton();
        registrationPage.clickRegisterButton();
        assertEquals("https://stellarburgers.nomoreparties.site/register", driver.getCurrentUrl());
        registrationPage.waitForNameInput();
        registrationPage.enterName("Test User");
        registrationPage.waitForEmailInput();
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.waitForPasswordInput();
        registrationPage.enterPassword("password123");
        registrationPage.clickRegisterButtonClick();
        assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }


    @Test
    @Description("Проверка регистрации с коротким паролем")
    public void testRegistrationWithShortPassword() {
        registrationPage.clickLoginAccountButton();
        registrationPage.scrollToRegisterButton();
        registrationPage.clickRegisterButton();
        assertEquals("https://stellarburgers.nomoreparties.site/register", driver.getCurrentUrl());
        registrationPage.waitForNameInput();
        registrationPage.enterName("Test User");
        registrationPage.waitForEmailInput();
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.waitForPasswordInput();
        registrationPage.enterPassword("12345");
        registrationPage.clickRegisterButtonClick();
        assertTrue(registrationPage.isPasswordErrorDisplayed());
        assertEquals("Некорректный пароль", registrationPage.getPasswordErrorText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
