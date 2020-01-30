package BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public WebDriver driver = null;
    @Parameters({"url"})
    @BeforeMethod
    public void setUp(@Optional("https://www.ncl.com/") String url) {
        System.setProperty("webdriver.chrome.driver", "../Driver/79.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
    @AfterMethod
    public void close() {
        driver.quit();
    }

    // Helper Methods
    public void listIteratior(List<WebElement> element, String text) {
        for (WebElement button :element) {
            if (button.getText().equalsIgnoreCase(text)) {
                button.click();
                break;
            }
        }
    }
    public void waitUntilVisible(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    element.isDisplayed();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
                catch (StaleElementReferenceException f ) {
                    return false;
                }
            }
        };
        wait.until(elementIsDisplayed);
    }
    public void javaScriptExe(String script, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript(script, element);
    }


}
