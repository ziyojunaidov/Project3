package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class US_306_Bakhodur extends DriverClass {
    @Test(dataProvider = "group2DataProvide")
    void communicationMessage(String name, String email, String subject, String message) {
        /*
        AC06:
        Find a contact form button like "Contact Us" on homepage and click.
        2. Fill in the following information in the contact form: Name, e-mail, subject, message.
        3. Try to send the contact form by clicking the "Send Message" button.
        4. Verify the "Recaptcha Didn't Match" alert.
        */
        POM_Bakhodur pom = new POM_Bakhodur();
        
        pom.contactUsPOM.click();
        
        pom.namePOM.sendKeys(name);
        pom.emailPOM.sendKeys(email);
        pom.subjectPOM.sendKeys(subject);
        pom.messagePOM.sendKeys(message);
        pom.send_message_buttonPOM.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "Recaptcha didn't match");
        alert.accept();
    }
    
    @DataProvider
    public Object[][] group2DataProvide() {
        return new Object[][]{{
                "Group2", "group2@gmail.com", "Project3", "Hello"
        }};
    }
}
