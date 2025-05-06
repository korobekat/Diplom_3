import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Статический класс получения драйвера в зависимости от параметров теста
 */
public class WebDriverFactory {

    /**
     * Получение драйвера
     * @param browser тип браузера
     * @return WebDriver
     */
    public static WebDriver getDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\practicum\\Diplom\\chromedriver\\chromedriver.exe");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\practicum\\Diplom\\yandexdriver\\yandexdriver.exe");
                ChromeOptions yandexOptions = new ChromeOptions();
                yandexOptions.setBinary("C:\\Program Files (x86)\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(yandexOptions);
            default:
                throw new IllegalArgumentException("Unknown browser: " + browser);
        }
    }
}
