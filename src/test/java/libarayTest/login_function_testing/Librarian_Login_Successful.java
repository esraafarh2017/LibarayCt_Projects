package libarayTest.login_function_testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_util.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Librarian_Login_Successful extends TestBase {


/*
AC #1:
Given librarian is on the loginPage
 Then verify that the title is “Login - Library”
 When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are 3 models on the page

 */

    @Test
    public void VerifyTitle(){
        driver.get("https://library2.cybertekschool.com/login.html");
        String expectedResult="Login - Library";
        String currentUrl=driver.getTitle();
        assertEquals(expectedResult,currentUrl);
    }



    @Test
    public void Verify3models() throws InterruptedException {
        driver.get("https://library2.cybertekschool.com/login.html");

            driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
            driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

            WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
            signInBtu.click();
            Thread.sleep(3000);

            List<WebElement> allItem=driver.findElements(By.className("title"));
            int actualResult=allItem.size();
            int expectedResult=3;
            assertTrue(actualResult==expectedResult);



        }

    }


