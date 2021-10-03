package libarayTest.userGroup_function;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import test_util.TestBase;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class UserGroup extends TestBase {
    @Test
    public void verify3option() throws InterruptedException {
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


        WebElement userGroupDD = driver.findElement(By.xpath("//select[@id='user_groups']"));
        Select userGroupObjects = new Select(userGroupDD); //Dropdown object

        //Creating a List for the elements of the userGroupObjects
        List<WebElement> userGroupObjectList = userGroupObjects.getOptions();
        int actualResult= userGroupObjectList.size();
        System.out.println(actualResult);
        //Getting the size of the List userGroupObjectList to compare to "EXPECTED RESULT" which is 3
        assertEquals(3, actualResult);

    }
}
