package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
    EmailPage emailpage;

    public LoginPageTest(){
        super();//calling the super class constructor. To initialize the properties
        //it is compulsory to call TestBase class constructor
    }
    
    //test cases should be separated-independent with each other
    //before each test case-lauch the browser and log in
    //@execute test case
    //after each test case--close the browser
    
    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();//before initioalization it will call the super class constructor
        loginPage=new LoginPage();//creating loginpage class object so that i can access all the methods of loginpage class
        Thread.sleep(5000);

    }
    @Test(priority=1)
    public void LoginPageTitleTest() throws InterruptedException {
        String title=loginPage.validateLoginPageTitle();
        AssertJUnit.assertEquals(title,"#1 Free CRM customer relationship management software cloud");
        Thread.sleep(5000);

    }

    @Test(priority=2)
    public void crmLogoImageTest() throws InterruptedException {
        boolean flag=loginPage.validateCRMimage();
        AssertJUnit.assertTrue(flag);//if flag is true assertion will be passed
        Thread.sleep(5000);
    }
    @Test(priority=3)
    public void clicklogInbtn() throws InterruptedException {
    	emailpage=loginPage.loginclick();
    	Thread.sleep(5000);

   }
    
     @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
