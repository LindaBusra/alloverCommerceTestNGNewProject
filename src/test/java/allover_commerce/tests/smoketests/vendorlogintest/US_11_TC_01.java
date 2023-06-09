package allover_commerce.tests.smoketests.vendorlogintest;

import allover_commerce.pages.HomePageUS_09;
import allover_commerce.pages.VendorMyAccountPageUS_11;
import allover_commerce.pages.VendorRegistrationPageUS_09;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class US_11_TC_01 {

/*
    US_11 : User should be able to sign in as a Vendor. (Vendor Sign in)
    Email and password should be entered as 'Vendor' and My Accout should be visible.
    Orders, Downloads, addresses, account details,whislist ve Logout should be visible.
    Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out should be visible in Dashboard.  */


    VendorRegistrationPageUS_09 vendorRegistrationPageUS_09 = new VendorRegistrationPageUS_09();
    HomePageUS_09 homePageUS_09 = new HomePageUS_09();
    VendorMyAccountPageUS_11 vendorMyAccountPageUS_11 = new VendorMyAccountPageUS_11();
    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void test_US_11_TC_01() throws IOException {

    // STEP: Email and password should be entered as 'Vendor' and My Account should be visible.

    //User should navigate to Allover Commerce url
    Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

    //Click on "Sign In" button
    homePageUS_09.singInButton.click();

    //Click on username text box and enter an exist username
    vendorRegistrationPageUS_09.existVendorUsername.sendKeys(ConfigReader.getProperty("exist_vendor_email"));

    //Click on password text box and enter a valid password
    vendorRegistrationPageUS_09.existVendorPassword.sendKeys(ConfigReader.getProperty("exist_vendor_password"));

    //Click on "Sign In" Button
    vendorRegistrationPageUS_09.existVendorSignInButton.click();

    //Click on "Sign Out" Button
    homePageUS_09.signOut.click();

    //Verify "My Account" text is visible
    Assert.assertTrue(vendorMyAccountPageUS_11.myAccountText.isDisplayed());
    ReusableMethods.getScreenshot("test_US_11_TC_01");

    Driver.getDriver().close();

    }



}