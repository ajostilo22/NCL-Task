package WebPages;

import BaseClass.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ShoreExcursionPage extends CommonAPI {

    @FindBy(xpath = "//a[contains(text(),'Shore Excursions')]") public static WebElement shoreExcursionsButton;
    @FindBy(xpath = "//span[contains(text(),'Destination')]") public static WebElement destinationDropdown;
    @FindBy(className = "chosen-search-input") public static WebElement searchBar;
    @FindBy(xpath = "//div/ul[@id='ports']//li") public static List<WebElement> portsList;
    @FindBy(xpath = "//a[contains(text(),'Update Filter')]") public static WebElement updateFilterButton;
    @FindBy(xpath = "//div/ul[@class='filter-widget widget-right']//li") public static List<WebElement> portsFilter;
    @FindBy(xpath = "//div/ul[@class='filter-widget widget-right']//li") public static WebElement portsFilterWaitElement;
    @FindBy(xpath = "//h2[contains(text(),'Shore Excursions')]") public static WebElement portsFilterHeader;
    @FindBy(xpath = "//button[contains(text(),'FIND EXCURSIONS')]") public static WebElement findExcursionsButton;
    @FindBy(xpath = "//a[@title='Explore']") public static WebElement exploreButton;

    public void shoreExcursions() {
        exploreButton.click();
        shoreExcursionsButton.click();
        destinationDropdown.click();
        searchBar.sendKeys("Alaska Cruises", Keys.ENTER);
        javaScriptExe("arguments[0].click();", findExcursionsButton);
        waitUntilVisible(portsFilterWaitElement);
        listIteratior(portsFilter, "Port");
        listIteratior(portsList, "Victoria, British Columbia");
        javaScriptExe("arguments[0].click();", updateFilterButton);
        String text = portsFilterHeader.getText();
        Assert.assertEquals(text, "Shore Excursions");
    }
}
