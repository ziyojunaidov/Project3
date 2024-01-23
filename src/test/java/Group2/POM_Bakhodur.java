package Group2;

import Utilities.DriverClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Bakhodur {
    
    public POM_Bakhodur(){
        PageFactory.initElements(DriverClass.driver,this);
    }
    
    //For US_306_Bakhodur
    @FindBy(linkText = "Contact Us")
    public WebElement contactUsPOM;
    
    @FindBy(id = "sender_name")
    public WebElement namePOM;
    
    @FindBy(id = "sender_email")
    public WebElement emailPOM;
    
    @FindBy(id = "sender_subject")
    public WebElement subjectPOM;
    
    @FindBy(id = "sender_message")
    public WebElement messagePOM;
    
    @FindBy(id = "send_message_button")
    public WebElement send_message_buttonPOM;
}
