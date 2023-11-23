package utils;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

import static java.util.Objects.requireNonNullElseGet;

public class LocalDriverManager {

    private static final ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();

    public static ChromeDriver getInstance() {
        if (driver.get() == null) {
            driver.set(new ChromeDriver());
        }
        return driver.get();
    }

    public static void closeDriver() {
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
}
