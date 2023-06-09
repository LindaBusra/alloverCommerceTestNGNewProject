package allover_commerce.tests.us_09;

import allover_commerce.pages.HomePageUS_09;
import allover_commerce.pages.VendorRegistrationPageUS_09;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class US_09_TC_11 {

/*
    US_09 : User should be able to register to the website as Vendor. (Vendor Registration)

    It should be possible to log in using the "Become a Vendor" link on the Sign Up screen.
    User should enter email address.
    "Verification code sent to your email: abc@abc.com." should be visible.
    The code received via email should be entered in the verification code text box.
    Password should be entered and it should contain uppercase, lowercase, digit and special char.
    User should enter password again.
    Registration as a Vendor should be completed by clicking on the Register button.
    The message "This Email already exists. Please login to the site and apply as vendor." should appear if the user tries to register using a registered email address.  */



    VendorRegistrationPageUS_09 vendorRegistrationPageUS_09 = new VendorRegistrationPageUS_09();
    HomePageUS_09 homePageUS_09 = new HomePageUS_09();
    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test_US_09_TC_11() throws IOException {

        // STEP: User should enter password again.

        //User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        String alloverCommerceWebSite = Driver.getDriver().getWindowHandle();

        //Click on "Sign In" button
        homePageUS_09.singInButton.click();


        //Click on "Sign up"
        homePageUS_09.singUpButton.click();

        //Click on "Become a Vendor" to navigate Vendor Registration Page
        homePageUS_09.becomeAVendorButton.click();

        //Enter a valid email address
        vendorRegistrationPageUS_09.registrationEmail.sendKeys(ConfigReader.getProperty("registration_valid_email"));

        //Click on Re-Send Code
        vendorRegistrationPageUS_09.reSendCodeButton.click();

        //Enter valid Re-Send Code in "Verification Code" box.
        vendorRegistrationPageUS_09.reSendCodeInput.sendKeys(ConfigReader.getProperty("re_send_valid_code"));

        //Enter valid password in "Password" text box
        vendorRegistrationPageUS_09.password.sendKeys(ConfigReader.getProperty("good_password"));

        //Enter the password again in the  "Confirm Password" text box
        vendorRegistrationPageUS_09.confirmPassword.sendKeys(ConfigReader.getProperty("good_password"));
        vendorRegistrationPageUS_09.registerButton.click();

        //Verify "Confirm Password: This field is required." text is not visible
        Assert.assertFalse(vendorRegistrationPageUS_09.errorMessage.getText().contains("Confirm Password: This field is required."));
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("test_US_09_TC_11");

        Driver.getDriver().close();
    }


}


