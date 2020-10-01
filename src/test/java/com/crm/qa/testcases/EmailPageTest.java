package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class EmailPageTest extends TestBase{
	EmailPage emailpage;
	HomePage homepage;
	LoginPage loginpage;

public EmailPageTest(){
    super();//calling the super class constructor. To initialize the properties
    //it is compulsory to call TestBase class constructor
}

@BeforeMethod
public void setup() throws InterruptedException {
    initialization();//before initioalization it will call the super class constructor
    loginpage=new LoginPage();//creating loginpage class object so that i can access all the methods of loginpage class
    emailpage= loginpage.loginclick();
    Thread.sleep(5000);

}
@Test
public void EmailTest() throws InterruptedException {
   homepage= emailpage.login(prop.getProperty("email"),prop.getProperty("password"));
   //login method is returning homepage class object
  // HomePage homePage=new Homepage();
  // loginpage is returning the object of homepage class so we can store in homepage class reference
   Thread.sleep(5000);
}

@AfterMethod
public void teardown(){
    driver.quit();
}

}