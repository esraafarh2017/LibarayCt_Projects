package libarayTest.login_function_testing;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_util.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class login_unSuccessful extends TestBase {

/*
AC #3 [negative]:
Given user is on the loginPage
When user enters invalid email address or password
And student click sign in button
Then verify the error message “Sorry, Wrong Email or Password”

 */

    @Test
    public void unSuccessfulLogin() throws InterruptedException {
        driver.get("https://library2.cybertekschool.com/login.html");

        driver.findElement(By.id("inputEmail")).sendKeys("50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("S2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        WebElement loginFailedMsg = driver.findElement(By.xpath("/html/body/form/div[2]/div"));
        String actualResult=loginFailedMsg.getText();
        System.out.println(actualResult);
        String expectedResult="Sorry, Wrong Email or Password";
        assertEquals(actualResult,expectedResult);



    }
}
