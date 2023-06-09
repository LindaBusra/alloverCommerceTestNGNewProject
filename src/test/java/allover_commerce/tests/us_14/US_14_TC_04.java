package allover_commerce.tests.us_14;

import allover_commerce.pages.HomePageUS_12;
import allover_commerce.pages.LoginPageUS_12;
import allover_commerce.pages.StoreManagerPageUS_14;
import allover_commerce.pages.VendorMyAccountPageUS_12;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_14_TC_04 {

    //  US_14 "User should be able to see the options to add items as a Vendor #1.
    //        (My Account > Store Manager > Product > Add New)"

    // Acceptance Criteria : Vendor should be able to add a featured product Photo.

    //  TC_05 - Vendor should be able to add a featured product Photo.

    /*
    Given User should navigate to Allover Commerce url
    When Click on sign in button
    And Enter username into username/email box
    And Enter password into password box
    And Click on sign in button
    And Click on user icon to navigate My Account page
    And	Vendor should navigate to store manager url
    And	Click on Products option
    And	Click on Add New button
    And	Click on featured image display
    And	Select an image file from computer
    And	Click on select button to complete uploading image
    Then Verify image is displayed on the page
     */

    HomePageUS_12 homePageUS_12 = new HomePageUS_12();
    LoginPageUS_12 loginPageUS_12 = new LoginPageUS_12();

    VendorMyAccountPageUS_12 vendorMyAccountPageUS_12 = new VendorMyAccountPageUS_12();

    StoreManagerPageUS_14 storeManagerPageUS_14 = new StoreManagerPageUS_14();

    public void login() {
        //    User should navigate to Allover Commerce url https://allovercommerce.com/
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //    Click on sign in button
        homePageUS_12.singInButton.click();

        //    Enter username into username/email box
        loginPageUS_12.usernameInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_email2"));

        //    Enter password into password box
        loginPageUS_12.passwordInput.sendKeys(ConfigReader.getProperty("app_vendor_valid_password2"));

        //    Click on sign in button
        loginPageUS_12.signInButton.click();
    }

    @Test
    public void TC_04() {

        login();

        //  Click on user icon to navigate My Account page
        JSUtils.clickElementByJS(homePageUS_12.signOutButton);

        //  Click on Store Manager to navigate to store manager url
        JSUtils.clickElementByJS(vendorMyAccountPageUS_12.storeManager);

        //  Click on Products option
        JSUtils.clickElementByJS(storeManagerPageUS_14.productsOption);

        //  Click on Add New option
        JSUtils.clickElementByJS(storeManagerPageUS_14.addNewButton);

        //	Click on image display
        JSUtils.clickElementByJS(storeManagerPageUS_14.addDisplayPhotoIcon);

        //  Select an image file from computer
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Downloads\\ballimage.jpg";
        storeManagerPageUS_14.selectFilesButton.sendKeys(pathOfFile);

        //  Click on select button to complete uploading image
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(storeManagerPageUS_14.selectToUploadButton);

        // Verify image is displayed on the page
        Assert.assertTrue(storeManagerPageUS_14.removeImgButton.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
      //  Driver.closeDriver();
    }
}
