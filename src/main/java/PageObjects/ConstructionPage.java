package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Модель страницы Конструктора
 */
public class ConstructionPage {

    private WebDriver driver;

    // конструктор для раздела Булки
    private final By bunsSection = By.xpath("//span[text()='Булки']");
    // конструктор для раздела Соусы
    private final By saucesSection = By.xpath("//span[text()='Соусы']");
    // конструктор для раздела Начинки
    private final By fillingsSection = By.xpath("//span[text()='Начинки']");
    // конструктор активного раздела Соусы
    private final By saucesHeaders = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[2]");
    // конструктор активного раздела Начинки
    private final By fillingsHeaders = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[3]");
    // конструктор активного раздела Булки
    private final By bunsHeaders = By.xpath("//*[@id='root']/div/main/section[1]/div[2]/h2[1]");

    /**
     * Конструктор
     *
     * @param driver Веб-драйвер
     */
    public ConstructionPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSaucesSection() {
        driver.findElement(saucesSection).click();
    }

    public String getSaucesHeaderText() {
        return driver.findElement(saucesHeaders).getText();
    }

    public void clickFillingsSection() {
        driver.findElement(fillingsSection).click();
    }

    public String getFillingsHeaderText() {
        return driver.findElement(fillingsHeaders).getText();
    }

    public void clickBunsSection() {
        driver.findElement(bunsSection).click();
    }

    public String getBunsHeaderText() {
        return driver.findElement(bunsHeaders).getText();
    }
}
