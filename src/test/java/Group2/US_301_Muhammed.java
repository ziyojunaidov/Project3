package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_301_Muhammed extends DriverClass {
    /*
    AC01
    1. User-friendly URL should be able to go to the e-junkie demo site.
    2. Find the "Add Demo E-Book to Cart" button and click.
    3. Verify that the demo e-book is successfully added to the basket.
    4. Click to "Add Promo Code" button.
    5. Enter an invalid (random) promotional code in the specified area.
    6. Click to "Apply" button
    7. Verify the "invalid promotional code" warning message is displayed.
     */

    @Test
    @Parameters({"PromoCode"})
    void unSuccessfulAdding(@Optional("1234") String PromoCode,
                            @Optional("5674") String PromoCode1) throws InterruptedException {

        WebElement addButton = driver.findElement(By.xpath("(//button[@class=\"view_product\"])[2]"));
        addButton.click();

        WebElement basketElement = driver.findElement(By.id("basket"));
        Assert.assertTrue(basketElement.getText().contains("Demo E-Book"));

        WebElement addPromoCodeButton = driver.findElement(By.xpath("//button[@class=\"Apply-Button Show-Promo-Code-Button\"]"));
        addPromoCodeButton.click();

        WebElement promoCodeInput = driver.findElement(By.xpath("//button[@class=\"Promo-Code-Value\"]"));
        promoCodeInput.sendKeys("InvalidPromoCode123");

        WebElement applyButton = driver.findElement(By.xpath("//button[@class=\"Promo-Apply\"]"));
        applyButton.click();

        WebElement errorMessage = driver.findElement(By.id("error-message"));
        Assert.assertTrue(errorMessage.getText().contains("Invalid promotional code"));

        driver.quit();
    }
}
