package test_util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utility.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class TestBase {

 public WebDriver driver;

    @BeforeEach
    public void setUpBrowser(){
       driver= WebDriverFactory.get("chrome");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }
}
