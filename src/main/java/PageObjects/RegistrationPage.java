package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Модель страницы Регистрации пользователя
 */
public class RegistrationPage {

    private  WebDriver driver;

    // локатор для кнопки войти в аккаунт
    private final By loginAccountButton = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    // локатор для кнопки Зарегистрироваться
    private final By registrationButton = By.className("Auth_link__1fOlj");
    // локатор для поля Имя
    private final By nameInput = By.xpath("//input[@name='name']");
    // локатор для поля Email
    private final By emailInput = By.xpath("//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");
    // локатор для поля Пароль
    private final By passwordInput = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");
    // локатор для сообщения об ошибки
    private final By errorMessage = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");

    /**
     * Конструктор
     *
     * @param driver Веб-драйвер
     */
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForNameInput() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(nameInput));
    }

    public void waitForEmailInput() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(emailInput));
    }

    public void waitForPasswordInput() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(passwordInput));
    }

    public void scrollToRegisterButton() {
        WebElement registerButton = driver.findElement(registrationButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", registerButton);
    }

    public void clickLoginAccountButton() {
        driver.findElement(loginAccountButton).click();
    }

    public void clickRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterButtonClick() {
        driver.findElement(registrationButton).click();
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getPasswordErrorText() {
        return driver.findElement(errorMessage).getText();
    }
}
