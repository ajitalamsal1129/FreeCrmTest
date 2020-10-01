package com.crm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactsPageTest extends TestBase {
	LoginPage loginpage;
	EmailPage emailpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	NewContactPage newcontactpage;
	String sheetName="Contacts";

	

	public NewContactsPageTest(){
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
	    newcontactpage=contactspage.clickonNew();
	    Thread.sleep(5000);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validatenewcontactpage(String firstname,String lastname,String email){
		//contactsPage.createNewContact("Ajita.", "Lamsal", "ajita7@gmail.com");

		newcontactpage.createNewContact(firstname, lastname, email);
		

	}
	

	@AfterMethod
	public void teardown() {
        driver.quit();
	}


	    



	}
	




