package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class US_308_AccessToInformationVideo_Ziyo extends DriverClass {
//1.Find the "See How it works" button on Sell Downloads | E-junkie  home page.
//2.Verify that URL is "Sell Downloads | E-junkie ".
//3.Start to play the video in the YouTube window that opens.
//4.Turn off the window after 10 sec.

//Note: You can use ROBOT or ACTION Class Tab/Shift+Tab/Space Etc.
    @Test
    void Test() throws InterruptedException, AWTException {
        driver.findElement(By.linkText("E-commerce by E-junkie")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("e-junkie"));

        driver.findElement(By.linkText("See how it works")).click();

        Thread.sleep(2000);

        WebElement iframe = driver.findElement(By.xpath("//iframe[@src=\"https://www.youtube.com/embed/kODFTdj9Ifc\"]"));
        driver.switchTo().frame(iframe);

       WebElement button =  driver.findElement(By.xpath("//button[@aria-label=\"Play\"]"));
        button.click();
        Thread.sleep(12000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

    }
}
