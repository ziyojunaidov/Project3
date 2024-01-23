package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_305_Bakhodur extends DriverClass {
    @Test
    @Parameters({"email", "name", "cardNumber", "expDate", "cvc"})
    void downloadEBook(@Optional("group2@gmail.com") String email, @Optional("Group2") String name, @Optional("4242 4242 4242 4242") String cardNumber, @Optional("12/24") String expDate, @Optional("000") String cvc) throws InterruptedException {
        /*
        As a customer, I would like to access the e-junkie demo site, then add the demo e-book to the basket and
        complete my payment process. I should be able to make a successful payment using the valid information
        during the payment process and download the e-book to my computer.
        AC04:
        1. Find the "Pay Using Debit Card" option and click on the basket page.
        2. On the payment page, there should be areas where email, name and debit card information on the card can be entered.
        3. Fill in compulsory areas (email, confirm email, name on card etc.) on the payment page.
        4. During the payment process as a valid credit card number "4242 4242 4242 4242", expiration date: 12/2024 and CVV: 000.
        5. Click the "Pay" button to complete the payment process.
        6. As a result of the payment process, "Your name, your order has been approved. Thank you!" Verify that the message is displayed.
        Note : Name and surname information must be included in "name on card"
        AC05:
        2. Payment process "Your Order is Confirmed. Thank You!" When completed with the message,
        verify that the total amount is the same as the price of the e-book (0.50 USD).
        3. Click the "Download" button to download the e-book to the computer.
        */
        
        WebElement demoBook = driver.findElement(By.cssSelector("[href=\"/product/1595015/Demo-eBook\"]"));
        String priceHomePage = demoBook.findElement(By.className("price")).getText();
        demoBook.findElement(By.tagName("button")).click();
        
        driver.switchTo().frame(4);
        WebElement debitCreditCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class=\"Payment-Button CC\"]")));
        debitCreditCard.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder=\"Email\"]"))).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Confirm Email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[placeholder=\"Name On Card\"]")).sendKeys(name);
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("#Stripe-Element>div>iframe")));
        driver.findElement(By.name("cardnumber")).sendKeys(cardNumber);
        driver.findElement(By.name("exp-date")).sendKeys(expDate);
        driver.findElement(By.name("cvc")).sendKeys(cvc);
        
        driver.switchTo().parentFrame();
        driver.findElement(By.cssSelector("button[class=\"Pay-Button\"]")).click();
        
        String confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("green_text_margin"))).getText();
        
        Assert.assertTrue(confirmation.contains("your order is confirmed"));
        Assert.assertEquals(driver.findElement(By.xpath("(//span[@class=\"usd\"])[2]")).getText(), priceHomePage);
        
        driver.findElement(By.cssSelector("span[class=\"download_btn top10\"]")).click();
    }
}
