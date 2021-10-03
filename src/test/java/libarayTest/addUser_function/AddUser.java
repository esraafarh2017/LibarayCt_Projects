package libarayTest.addUser_function;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import test_util.TestBase;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddUser extends TestBase {


    @Test
    public void addUser() throws InterruptedException {

        driver.get("https://library2.cybertekschool.com/login.html");

        driver.findElement(By.id("inputEmail")).sendKeys("librarian50@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");

        WebElement signInBtu=driver.findElement(By.xpath("//*[.='Sign in']"));
        signInBtu.click();
        Thread.sleep(3000);

        WebElement userCouBefore=driver.findElement(By.id("user_count"));
        String BeforeAddUser=userCouBefore.getText();
        int  countBeforeAdd=Integer.parseInt(BeforeAddUser);
        System.out.println(countBeforeAdd);



        WebElement userBtu = driver.findElement(By.xpath("//span[.='Users']"));
        userBtu.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("elan rtyu");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asdpof@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("123 m street md");

        Thread.sleep(3000);
       driver.findElement(By.xpath("//button[.='Save changes']")).click();
        Thread.sleep(3000);




        WebElement dashBoardBtu = driver.findElement(By.xpath("//span[.='Dashboard']"));
        dashBoardBtu.click();
        Thread.sleep(3000);
        WebElement userCouAfter=driver.findElement(By.id("user_count"));
        String AfterAddUser=userCouAfter.getText();
        System.out.println(AfterAddUser);
        int  countAfterAdd=Integer.parseInt(AfterAddUser);
        System.out.println(countAfterAdd);
       assertTrue(countAfterAdd-1==countBeforeAdd);





        Thread.sleep(2000);





    }


}
