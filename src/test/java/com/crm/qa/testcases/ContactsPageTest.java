package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	EmailPage emailpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	NewContactPage newcontactpage;

	

	public ContactsPageTest(){
	    super();//calling the super class constructor. To initialize the properties
	    //it is compulsory to call TestBase class constructor
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
	    initialization();//before initioalization it will call the super class constructor
	    loginpage=new LoginPage();//creating loginpage class object so that i can access all the methods of loginpage class
	    testutil=new TestUtil();
	    contactspage=new ContactsPage();
	    newcontactpage=new NewContactPage();
	    Thread.sleep(5000);

	    emailpage= loginpage.loginclick();
	    Thread.sleep(5000);
	    homepage= emailpage.login(prop.getProperty("email"),prop.getProperty("password"));
		//testutil.switchToFrame();//you can write here instead inside method too

	    Thread.sleep(5000);

		contactspage=homepage.clickOnContacts();
	    Thread.sleep(5000);


	}
	
	@Test(priority=1)
	public void verifyContactsTest() throws InterruptedException {
		//testutil.switchToFrame();
		Boolean flag=contactspage.verfyContacts();
		System.out.println(flag);
		Assert.assertTrue(flag);
		//Assert.assertTrue(contactspage.verfyContacts());
		Thread.sleep(5000);
	}
//	@Test(priority=2)
//	public void selectsinglecontactsTest() {
//		contactspage.selectContacts("test 2 test 2");
//	}
//	@Test(priority=3)
//	public void selectmultiplecontactsTest() {
//		contactspage.selectContacts("test 2 test 2");
//		contactspage.selectContacts("ui uiii");
//
//		
//	}
	@Test(priority=2)
	public void verifyNewContact() {
		newcontactpage=contactspage.clickonNew();
		
	}

	

	@AfterMethod
	public void teardown() throws InterruptedException {
        driver.quit();
	}



}
