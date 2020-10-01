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
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	EmailPage emailpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest(){
	    super();//calling the super class constructor. To initialize the properties
	    //it is compulsory to call TestBase class constructor
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
	    initialization();//before initioalization it will call the super class constructor
	    loginpage=new LoginPage();//creating loginpage class object so that i can access all the methods of loginpage class
	    testutil=new TestUtil();
	    contactspage=new ContactsPage();
	    Thread.sleep(5000);

	    emailpage= loginpage.loginclick();
	    Thread.sleep(5000);
	    homepage= emailpage.login(prop.getProperty("email"),prop.getProperty("password"));
	    Thread.sleep(5000);

	}
	@Test(priority=1)
	public void verfityHomePageTitleTest() {
		String homepagetitle=homepage.verifyPageTitlke();
		System.out.println(homepagetitle);
		AssertJUnit.assertEquals(homepagetitle, "Cogmento CRM","homepage title did not match");//message dispalys if assertion is false
	}
	
	@Test(priority=2)
	public void verifyusernameTest() {
		Boolean name=homepage.verifyUsername();
		System.out.println(name);
        Assert.assertTrue(name);
		//or
		//testutil.switchToFrame();--if there is any frame.but in this page we dont have any frame
//		Assert.assertTrue(homepage.verifyUsername());
//		
	}
	
	@Test(priority=3)
	public void verifycontactsLink() throws InterruptedException {
	  // testutil.switchToFrame();

		Thread.sleep(5000);
		contactspage=homepage.clickOnContacts();
	}
	
	@AfterMethod
	public void teardown() {
        driver.quit();
	}

	}


