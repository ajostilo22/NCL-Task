package TestShoreExcursion;

import WebPages.ShoreExcursionPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageFactoryClass extends ShoreExcursionPage {
    ShoreExcursionPage shoreExcursionPage;

    @BeforeMethod
    public void initElements() {
        shoreExcursionPage = PageFactory.initElements(driver, ShoreExcursionPage.class);
    }

    @Test
    public void testShoreExcursions() {
        shoreExcursions();
    }

}
