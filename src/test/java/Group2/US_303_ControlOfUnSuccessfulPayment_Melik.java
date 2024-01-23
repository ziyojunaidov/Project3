package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_303_ControlOfUnSuccessfulPayment_Melik extends DriverClass {

    @Test
    @Parameters({"email", "nameOnCard", "cardNumber", "expDate", "cvc"})
    void unSuccessfulPayment(@Optional("asdasd@gmail.com") String email,
                             @Optional("John Murdock") String nameOnCard,
                             @Optional("2222222222222222") String cardNumber,
                             @Optional("0129") String expDate,
                             @Optional("123") String cvc) throws InterruptedException {

        driver.findElement(By.xpath("(//button[@class=\"view_product\"])[2]")).click();
        WebElement iframe1 = driver.findElement(By.cssSelector("iframe[class=\"EJIframeV3 EJOverlayV3\"]"));
        driver.switchTo().frame(iframe1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class=\"Payment-Button CC\"]")));
        driver.findElement(By.cssSelector("button[class=\"Payment-Button CC\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder=\"Email\"]")));
        driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]")).sendKeys(nameOnCard);

        WebElement iframe3 = driver.findElement(By.xpath("(//iframe[@role=\"presentation\"])[2]"));
        driver.switchTo().frame(iframe3);

        driver.findElement(By.name("cardnumber")).sendKeys(cardNumber);
        driver.findElement(By.name("exp-date")).sendKeys(expDate);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        driver.switchTo().parentFrame();

        driver.findElement(By.cssSelector("button[class=\"Pay-Button\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SnackBar")));

        WebElement snackBar = driver.findElement(By.id("SnackBar"));

        Assert.assertTrue(snackBar.isDisplayed(), "Test has failed");
    }
}
