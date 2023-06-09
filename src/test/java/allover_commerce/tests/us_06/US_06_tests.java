package allover_commerce.tests.us_06;

import allover_commerce.pages.*;
import allover_commerce.utilities.ConfigReader;
import allover_commerce.utilities.Driver;
import allover_commerce.utilities.JSUtils;
import allover_commerce.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


//yasin yilmaz

public class US_06_tests {

    HomePageUS_06 homePage = new HomePageUS_06();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    OrderPage orderPage = new OrderPage();

    @Test
    public void tc_01() {
//        go to home page
        Driver.getDriver().get(ConfigReader.getProperty("ecommerce_url"));

//        user should be log in.
        homePage.useIcon.click();
        homePage.userName.sendKeys(ConfigReader.getProperty("yasin_username"));
        homePage.password.sendKeys(ConfigReader.getProperty("yasin_password"));
        homePage.signInSubmitButton.click();

//        click the search box
//        enter  “calculator”
        ReusableMethods.waitFor(5);
        String searchedProduct = ConfigReader.getProperty("search_product");
        homePage.searchBox.sendKeys(searchedProduct);

//        test that the product appears in the search box
        WebElement product = homePage.productSearch;
        Assert.assertTrue(product.isDisplayed());
//        click to product
        product.click();
//        test to compare product and search parameter
        Assert.assertTrue(Driver.getDriver().getTitle().contains(searchedProduct));
    }

    @Test
    public void tc_02() {

//        test to "add to cart" button visibility
        WebElement addToCart = productPage.addToCart;
        Assert.assertTrue(addToCart.isDisplayed());

//        click to "add to cart button
        addToCart.click();

//        check to  “calculator” has been added to your cart." message visibility
        String viewToCartAlert = " “calculator” has been added to your cart.";
        Assert.assertTrue(productPage.viewCartAlert.getText().contains(viewToCartAlert));

    }

    @Test
    public void tc_03() {

//        click to cart button
        productPage.cartButton.click();

//        test to compare added product name and product which visible in cart
        Assert.assertTrue(productPage.productInCartPopup.isDisplayed());

//        click view cart
        productPage.viewCartButton.click();

//        test to compare added product name and product which visible in cart
        Assert.assertEquals(ConfigReader.getProperty("search_product"), cartPage.productsInCartPage.get(0).getText());

    }

    @Test
    public void tc_04() {

//        increase the amount
        int productAmount = 6;
        for (int i = 1; i < productAmount; i++) {
            cartPage.increaseButton.click();
        }

//        click the update cart button
        cartPage.updateCartButton.click();

//        check the number of amount
        ReusableMethods.waitFor(5);
        String quantityValue = cartPage.quantity.getAttribute("value");
        System.out.println(quantityValue);
        Assert.assertEquals(String.valueOf(productAmount), quantityValue);

//        test whether the price increases with the quantity of the product
        double productPrice = Double.parseDouble(cartPage.productPrice.getText().replaceAll("\\$",""));
        double subtotalPrice = Double.parseDouble(cartPage.subtotalPrice.getText().replaceAll("\\$",""));
        Assert.assertEquals(productPrice * productAmount, subtotalPrice);


    }

    @Test
    public void tc_05() {

//        click to proceed to checkout button
        JSUtils.clickElementByJS(cartPage.proceedToCheckoutButton);

//        test that billing infos appears in checkout page
        Assert.assertTrue(checkoutPage.billingDetail.isDisplayed());

//        test that Wire transfer/EFT method selected
//        Click to "Pay at the door" door
//        test that Pay at the door method can be selected
        if (checkoutPage.EFTRadioButton.isSelected()){
            JSUtils.clickElementByJS(checkoutPage.payAtDoorRadioButton);
        }else {
            JSUtils.clickElementByJS(checkoutPage.EFTRadioButton);
        }

    }
    @Test
    public void tc_06(){

        //        click to place order button
        JSUtils.clickElementByJS(checkoutPage.placeOrder);

        //        Test that "Your order has been received" message is visible
        Assert.assertTrue(orderPage.tick.isDisplayed());

    }

    @AfterClass
    public void tearDown(){
        Driver.getDriver().quit();
    }


}
