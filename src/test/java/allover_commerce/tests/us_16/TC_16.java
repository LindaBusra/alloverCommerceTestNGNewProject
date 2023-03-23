package allover_commerce.tests.us_16;

import allover_commerce.pages.HomePage;
import allover_commerce.pages.MyAccountPage;
import allover_commerce.pages.StoreManagerPage;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import com.aventstack.extentreports.gherkin.model.ScenarioOutline;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_16 {
    /*
        Given
            User goes to "https://allovercommerce.com/"
        When
            Click on "Sign In" section
        And
            Vendor types his/her username or email
        And
            Vendor types his/her password
        And
            Click on "Remember Me" button
        And
            Click on "Sign In" button
        And
            Click on "My Account" button
        And
            Click on "Store Manager" section
        And
            Click on "Products" section
        And
            Click on "Add New" section
        And
            Vendor choose "Simple Product" from dropdown
        And
            Vendor choose "Virtual" and "Downloadable" checkboxes
        And
            Vendor types "Product Title"
        And
            Vendor types "Price"
        And
            Vendor types "Sale Price"
        And
            Vendor adds product picture
        And
            Vendor add gallery picture
        And
	        Vendor choose "Categories"
        And
	        Vendor choose "Downloadable" section
	    And
	        Vendor types "Name"
	    And
	        Vendor types "File"
	    And
	        Vendor choose "Submit" button
	    Then
	        Verify "Product successfully published"
	*/

    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Select select;

    @Test
    public void testCase16(){
        // User goes to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

        // Click on "Sign In" section
        homePage.signInButton.click();
        ReusableMethods.waitFor(2);

        // Vendor types his/her username or email
        homePage.username.sendKeys("mtkama2010@gmail.com");
        ReusableMethods.waitFor(1);

        // Vendor types his/her password
        homePage.password.sendKeys("km6476458gy");
        ReusableMethods.waitFor(1);

        // Click on "Remember Me" button
        homePage.rememberMe.click();
        ReusableMethods.waitFor(1);

        // Click on "Sign In" button
        homePage.signInSubmitButton.click();
        ReusableMethods.waitFor(1);

        // Click on user icon section
        JSUtils.clickElementByJS(homePage.myAccountSection);
        ReusableMethods.waitFor(1);

        // Click on "Store Manager" section
        myAccountPage.storeManager.click();
        ReusableMethods.waitFor(2);

        // Click on "Products" section
        JSUtils.clickElementByJS(storeManagerPage.productsSection);
        ReusableMethods.waitFor(2);

        // Click on "Add New" section
        storeManagerPage.addNewButton.click();
        ReusableMethods.waitFor(2);

        // Vendor choose "Simple Product" from dropdown
        select = new Select(storeManagerPage.productType);
        select.selectByVisibleText("Simple Product");
        ReusableMethods.waitFor(2);

        // Vendor choose "Virtual" and "Downloadable" checkboxes
        storeManagerPage.virtualCheckBox.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.downloadableCheckBox.click();
        ReusableMethods.waitFor(2);

        // Vendor types "Product Title"
        storeManagerPage.productTitle.sendKeys("Education");
        ReusableMethods.waitFor(2);

        // Vendor types "Price"
        storeManagerPage.price.sendKeys("1000");
        ReusableMethods.waitFor(2);

        // Vendor types "Sale Price"
        storeManagerPage.salePrice.sendKeys("1500");
        ReusableMethods.waitFor(2);

        // Vendor adds product picture
        storeManagerPage.picture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.mediaLibrary.click();
        ReusableMethods.waitFor(3);

        storeManagerPage.choosePicture.click();
        ReusableMethods.waitFor(3);

        JSUtils.clickElementByJS(storeManagerPage.selectSubmitButton);
        ReusableMethods.waitFor(2);

        // Vendor add gallery picture
        storeManagerPage.galeryPicture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.chooseGalleryPicture.click();
        ReusableMethods.waitFor(2);

        storeManagerPage.addGaleryButton.click();
        ReusableMethods.waitFor(3);

        // Vendor choose "Categories"
        JSUtils.clickElementByJS(storeManagerPage.categories);
        ReusableMethods.waitFor(1);

        // Vendor choose "Downloadable" section
        JSUtils.clickElementByJS(storeManagerPage.downloadableSection);
        ReusableMethods.waitFor(1);

        // Vendor types "Name"
        storeManagerPage.nameInput.sendKeys("marcel");
        ReusableMethods.waitFor(1);


        JSUtils.clickElementByJS(storeManagerPage.uploadButton);
        ReusableMethods.waitFor(1);
        System.out.println( "1");

        JSUtils.clickElementByJS(storeManagerPage.menuItemUploadButton);
        ReusableMethods.waitFor(1);
        System.out.println( "2");

        // Vendor types "File"
//        storeManagerPage.selectItems.click();
        String userHOME=System.getProperty("user.home");
        String pathOfFile = userHOME + "\\Desktop\\logo.jpeg";
        storeManagerPage.fileInput.sendKeys(pathOfFile);
        ReusableMethods.waitFor(3);
        System.out.println("3");


        storeManagerPage.selectToUpload.click();
        ReusableMethods.waitFor(10);
        System.out.println("4");


        // Vendor choose "Submit" button
        JSUtils.clickElementByJS(storeManagerPage.submitSectionButton);
        ReusableMethods.waitFor(5);
        System.out.println("5");


        // Verify "Product successfully published"
        ReusableMethods.verifyElementDisplayed(storeManagerPage.publishedSection);
        System.out.println("6");
    }
}
