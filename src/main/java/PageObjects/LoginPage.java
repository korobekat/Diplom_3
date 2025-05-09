package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Модель страницы Логина пользователя
 */
public class LoginPage {
    private  WebDriver driver;

    // локатор для поля Email
    private final By emailInput = By.xpath("//input[@type='text']");
    // локатор для кнопки войти во всех формах
    private final By loginButton = By.xpath("//button[text()='Войти']");
    // локатор для поля Пароль
    private final By passwordInput = By.xpath("//input[@type='password']");
    // локатор для кнопки Личный кабинет
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");
    // локатор для кнопки войти в форме регистрации
    private final By registerLoginButton = By.xpath("//a[text()='Войти']");
    // локатор для кнопки восстановить пароль
    private final By restorePasswordButton = By.xpath("//*[@id='root']/div/main/div/div/p[2]/a");
    // локатор для кнопки войти в форме восстановления пароля
    private final By restoreLoginButton = By.xpath("//*[@id='root']/div/main/div/div/p/a");
    // локатор для кнопки Выход
    private final By exitButton = By.xpath("//button[text()='Выход']");
    // локатор для кнопки Конструктор
    private final By constructionButton = By.xpath("//p[text()='Конструктор']");
    // локатор для кнопки Stellar Burgers
    private final By stellarBurgersButton = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");

    /**
     * Конструктор
     *
     * @param driver Веб-драйвер
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }
    // Методы для взаимодействия с элементами
    public void submitLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
    }

    public void clickRegisterLoginButton() {

        driver.findElement(registerLoginButton).click();
    }

    public void clickRestorePasswordButton() {

        driver.findElement(restorePasswordButton).click();
    }

    public void enterEmail(String email) {

        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickConstructor() {

        driver.findElement (constructionButton).click();
    }

    public void clickExit() {

        driver.findElement(exitButton).click();
    }

    public void clickStellarBurgersLogo() {
        driver.findElement(stellarBurgersButton).click();
    }

    public void clickLoginButtonInRestorePasswordPage() {
        driver.findElement(restoreLoginButton).click();
    }

    public void waitForEmailInput() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailInput));
    }
}
