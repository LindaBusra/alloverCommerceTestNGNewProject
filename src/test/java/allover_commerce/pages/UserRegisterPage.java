package allover_commerce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import allover_commerce.utilities.Driver;

public class UserRegisterPage {
    public UserRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //---------------- USER REGISTER ----------------
    @FindBy(id = "reg_username")
    public WebElement inputRegisterUsername;

    @FindBy(id = "reg_email")
    public WebElement inputRegisterEmail;

    @FindBy(id = "reg_password")
    public WebElement inputRegisterPassword;

    @FindBy(id = "register-policy")
    public WebElement chkRegisterPolicy;

    @FindBy(xpath = "//button[@name='register']")
    public WebElement btnRegisterSignUp;

    @FindBy(xpath = "//*[contains(@class,'woocommerce-password-strength')]")
    public WebElement msgPasswordStrengh;

    @FindBy(xpath = "(//p[@class='submit-status'])[1]")
    public WebElement msgPasswordStrenghPopup;

    @FindBy(xpath = "(//p[@class='submit-status'])[2]")
    public WebElement msgRegisteredError;

    //*[@id="signup"]/form/p[6]
    //*[@id="signup"]/form/p[@class="submit-status"]
    //(//p[@class="submit-status"])[2]

}
