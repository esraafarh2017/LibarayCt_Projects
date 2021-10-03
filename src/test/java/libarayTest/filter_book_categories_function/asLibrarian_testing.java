package libarayTest.filter_book_categories_function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class asLibrarian_testing {

    @Test
    public void verify21option() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://library2.cybertekschool.com/login.html");
        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        WebElement userBtu = driver.findElement(By.xpath("//span[.='Books']"));
        userBtu.click();
        Thread.sleep(3000);



        WebElement filterDD = driver.findElement(By.xpath("//select[@id='book_categories']"));
        Select filterObjects = new Select(filterDD); //Dropdown object

        //Creating a List for the elements of the userGroupObjects
        List<WebElement> filterObjectList = filterObjects.getOptions();
        int actualResult= filterObjectList.size();
        System.out.println(actualResult);
        //Getting the size of the List userGroupObjectList to compare to "EXPECTED RESULT" which is 3
        assertEquals(21, actualResult);

        driver.quit();


    }

    @Test
    public void selectedDramaOption() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://library2.cybertekschool.com/login.html");
        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        WebElement userBtu = driver.findElement(By.xpath("//span[.='Books']"));
        userBtu.click();
        Thread.sleep(3000);



        WebElement filterDD = driver.findElement(By.xpath("//select[@id='book_categories']"));
        Select filterObjects = new Select(filterDD); //Dropdown object

        filterObjects.selectByVisibleText("Drama");

        WebElement optionDrama= driver.findElement(By.xpath("//option[@value='6']"));
        optionDrama.isSelected();



        assertTrue( optionDrama.isSelected());

        driver.quit();

    }
}
