package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_302_Muhammed extends DriverClass {
    /*
    AC02:
    1. I should successfully access the e-junkie demo site.
    2. Find the "Add Demo E-Book to Cart" button and click.
    3. Verify that the demo e-book is successfully added to the basket.
    4. Find the "Pay Using Debit Card" option and click on the basket page.
    5. There should be areas where email, name and debt card information (card number, expiration date, CVC) can be entered on the payment page.
    6. Leave the e-mail address and other fields blank on the payment page.
    7. Click the "Pay" button to complete the payment process.
    8. Verify that during the payment process, "Invalid email" and "Invalid Billing Name" errors are displayed at the same time.
     */

    @Test
    @Parameters({"email", "nameOnCard", "cardNumber", "expDate", "CVC"})
    void unSuccessfulAdding(@Optional("sjsjsj@gmail.com") String email,
                            @Optional("Susan Kate") String nameOnCard,
                            @Optional("252383739393") String cardNumber,
                            @Optional("1212") String expDate,
                            @Optional("567") String CVC) throws InterruptedException {

        WebElement addButton = driver.findElement(By.xpath("(//button[@class=\"view_product\"])[2]"));
        addButton.click();

        WebElement basketIcon = driver.findElement(By.id("basket-icon"));
        Assert.assertTrue(basketIcon.isDisplayed());

        WebElement debitCardOption = driver.findElement(By.xpath("//span[text()='Visa, AMEX, MasterCard, Maestro, Discover']"));
        debitCardOption.click();

        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement nameField = driver.findElement(By.cssSelector("input[type='email'][placeholder='Confirm Email']"));
        WebElement cardNumberField = driver.findElement(By.className("CardField"));
        System.out.println(cardNumberField.getText());
        WebElement expirationDateField = driver.findElement(By.name("exp-date"));
        WebElement cvcField = driver.findElement(By.name("cvc"));

        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(nameField.isDisplayed());
        Assert.assertTrue(cardNumberField.isDisplayed());
        Assert.assertTrue(expirationDateField.isDisplayed());
        Assert.assertTrue(cvcField.isDisplayed());

        WebElement payButton = driver.findElement(By.xpath("//button[@class='Pay-Button']"));
        payButton.click();

        WebElement invalidEmailError = driver.findElement(By.id("invalid-email-error"));
        WebElement invalidBillingNameError = driver.findElement(By.id("invalid-billing-name-error"));

        Assert.assertTrue(invalidEmailError.isDisplayed());
        Assert.assertTrue(invalidBillingNameError.isDisplayed());

        driver.quit();
    }
}
