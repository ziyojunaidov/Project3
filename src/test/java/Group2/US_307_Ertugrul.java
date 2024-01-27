package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class US_307_Ertugrul extends DriverClass {


            //1. Find the "E-Commerce By E-Junkie" link on homepage and click.
            //2. Click the e-junkie logo at the top left on the opened page.
                //3. Verify that URL is "https://www.e-junkie.com/".

    @Test
    void  EJunkieTest(){
        driver.findElement(By.linkText("E-commerce by E-junkie")).click();

        driver.findElement(By.xpath("//div[@class='column is-2-desktop is-4-tablet is-4-mobile']/a")).click();


        String currentUrl = driver.getCurrentUrl();


        String expectedUrl = "https://www.e-junkie.com/";


        Assert.assertEquals(currentUrl, expectedUrl, "URL validation failed.");
    }



    }


