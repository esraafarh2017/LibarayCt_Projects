package libarayTest.login_function_testing;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_util.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Student_Login_Successful extends TestBase {
/*
 AC#2:
    Given student is on the loginPage
    Then verify that the URL is “https://library2.cybertekschool.com/login.html”
    When student enters valid email address and password
    And student click sign in button
    Then verify that there are 2 models on the page

 */

    @Test
    public void VerifyUrl(){
        driver.get("https://library2.cybertekschool.com/login.html");

        String expectedUrl="https://library2.cybertekschool.com/login.html";
        String currentUrl=driver.getCurrentUrl();
        assertEquals(expectedUrl,currentUrl);
    }



    @Test
    public void Verify2models() throws InterruptedException {
        driver.get("https://library2.cybertekschool.com/login.html");

        driver.findElement(By.id("inputEmail")).sendKeys("student60@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        List<WebElement> allItem=driver.findElements(By.className("title"));
        int actualResult=allItem.size();
        int expectedResult=2;
        assertTrue(actualResult==expectedResult);



    }

}



