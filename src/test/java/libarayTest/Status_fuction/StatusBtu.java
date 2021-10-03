package libarayTest.Status_fuction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusBtu  {

    @Test
    public void verify2status() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://library2.cybertekschool.com/login.html");
        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        WebElement userBtu = driver.findElement(By.xpath("//span[.='Users']"));
        userBtu.click();
        Thread.sleep(3000);

        WebElement userGroupBtu = driver.findElement(By.xpath("//span[.='Users']"));


        WebElement statusDD = driver.findElement(By.xpath("//select[@id='user_status']"));
        Select statusObjects = new Select(statusDD); //Dropdown object

        //Creating a List for the elements of the userGroupObjects
        List<WebElement> statusObjectList = statusObjects.getOptions();
        int actualResult= statusObjectList.size();
        System.out.println(actualResult);
        //Getting the size of the List userGroupObjectList to compare to "EXPECTED RESULT" which is 3
        assertEquals(2, actualResult);
        driver.quit();
    }
}
