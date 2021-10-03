package libarayTest.addBook_function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddBook {

    @Test
    public void addBook() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://library2.cybertekschool.com/login.html");
        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();

        Thread.sleep(3000);

        WebElement bookCouBefore=driver.findElement(By.id("book_count"));
        String BeforeAddBook=bookCouBefore.getText();
        int  countBeforeAdd=Integer.parseInt(BeforeAddBook);
        System.out.println(countBeforeAdd);



        WebElement userBtu = driver.findElement(By.xpath("//span[.='Books']"));
        userBtu.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();

        Thread.sleep(3000);
        driver.findElement(By.name("name")).sendKeys("hello word");
        Thread.sleep(3000);
        driver.findElement(By.name("isbn")).sendKeys("9876");
        Thread.sleep(1000);
        driver.findElement(By.name("year")).sendKeys("2021");//year accepts characters and letters.
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/main/section[3]/div[2]/div/div/div/div/form/div[1]/div/div[2]/div[1]/div/input")).sendKeys("Stark, rty");
        Thread.sleep(1000);
        driver.findElement(By.id("description")).sendKeys("Here lies the description of the book hello word");
        Thread.sleep(1000);

        WebElement dropDown = driver.findElement(By.name("book_category_id"));
        Select dropDownObj = new Select(dropDown);

        dropDownObj.selectByVisibleText("Drama");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#add_book_form > div.modal-footer > button.btn.btn-primary")).submit();
        Thread.sleep(3000);

        WebElement dashBoardBtu = driver.findElement(By.xpath("//span[.='Dashboard']"));
        dashBoardBtu.click();
        Thread.sleep(3000);
        WebElement bookCouAfter=driver.findElement(By.id("book_count"));
        String AfterAddBook=bookCouAfter.getText();
        System.out.println(AfterAddBook);
        int  countAfterAdd=Integer.parseInt(AfterAddBook);
        System.out.println(countAfterAdd);
        assertTrue(countAfterAdd-1==countBeforeAdd);



        driver.quit();
    }
}
