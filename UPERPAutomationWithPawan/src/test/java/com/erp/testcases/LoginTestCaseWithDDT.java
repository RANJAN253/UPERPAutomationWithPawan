package com.erp.testcases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.erp.baseclass.BaseClass;
import com.erp.pages.LoginPage;
import com.erp.utilities.B_ReadExcel;
import junit.framework.Assert;

public class LoginTestCaseWithDDT extends BaseClass{
	
	LoginPage loginPage;

    // ─────────────────────────────────────────────────────────────
    // DataProvider → Excel se data read karega
    // ─────────────────────────────────────────────────────────────
    
    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {

        // Sheet name pass karo
        return B_ReadExcel.testData("login");
    }

    @Test(dataProvider = "LoginData")
    public void verifyLogin(String username, String password) throws InterruptedException, IOException {

        loginPage = new LoginPage(driver);

        logger.info("===== Login Test Started =====");

        // Login
        loginPage.enterUsername(username);
        logger.info("Entered Username");

        loginPage.enterPassword(password);
        logger.info("Entered Password");

        loginPage.clickLoginButton();
        logger.info("Clicked Login Button");

        Thread.sleep(3000);

        // Validation
        String actualTitle = driver.getTitle();
        System.out.println("Actual title:" + actualTitle);
        String expectedTitle = "Forest Corporation"; 
        // Apna actual title yaha change kar lena

        if (actualTitle.contains(expectedTitle)) {

            Assert.assertTrue(true);
            logger.info("Login Successful");

            // Logout
            loginPage.clickLogoutButton();
            logger.info("Logout Successful");

        } else {

            logger.error("Login Failed");
            captureScreenshot(driver, "verifyLogin");

            Assert.assertTrue(false);
        }

        logger.info("===== Login Test Finished =====");
    }

    // ─────────────────────────────────────────────────────────────
    // Browser Close
    // ─────────────────────────────────────────────────────────────
    
    @AfterMethod
    public void tearDownMethod() {

        driver.manage().deleteAllCookies();
    }
}