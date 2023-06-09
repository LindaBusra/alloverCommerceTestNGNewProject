package allover_commerce.tests.us_01;

import allover_commerce.pages.HomePageUS_01;
import allover_commerce.pages.UserRegisterPageUS_01;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.ReusableMethods;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class US_01_TC_07 {
    /*
    Given User should navigate to Allover Commerce url
    When Click on the 'Register' option
    And Enter valid username
    And Enter valid email domain
    And Don't enter into Password field
    And Click "I agree to the privacy policy" box
    And Click on the "SIGN UP" button
    Then Verify  user see 'Please fill out this field' warning message
     */
    HomePageUS_01 homePageUS_01 = new HomePageUS_01();
    UserRegisterPageUS_01 userRegisterPage = new UserRegisterPageUS_01();
    Faker faker = new Faker();
    @Test
    public void TC_07(){
//        User should navigate to Allover Commerce url
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
//        Click on the 'Register' option
        homePageUS_01.registerButton.click();
//        Enter valid username
        userRegisterPage.regUserNameBox.sendKeys(faker.name().username());
//        Enter valid email domain
        userRegisterPage.regEmailBox.sendKeys(faker.internet().emailAddress());
//        Don't enter into Password field

//        Click "I agree to the privacy policy" box
        userRegisterPage.regPolicyCheckBox.click();
//        Click on the "SIGN UP" button
        userRegisterPage.regSignUpButton.click();
//        Verify  user see 'Please fill out this field' warning message
        ReusableMethods.waitFor(2);
        Assert.assertTrue(userRegisterPage.emptyPasswordWarningText.getText().contains("Please fill out this field"));
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}