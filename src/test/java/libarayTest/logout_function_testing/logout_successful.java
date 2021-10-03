package libarayTest.logout_function_testing;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test_util.TestBase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class logout_successful extends TestBase {

    @Test
    public void logout() throws InterruptedException {
        driver.get("https://library2.cybertekschool.com/login.html");

        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@role='button']")).click();



        Thread.sleep(1000);
        driver.findElement(By.linkText("Log Out")).click();

        Thread.sleep(2000);
        String expectedUrl="https://library2.cybertekschool.com/login.html";
        String actualUrl= driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);



    }
}
