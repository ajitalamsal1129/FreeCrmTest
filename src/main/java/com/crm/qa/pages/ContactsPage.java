package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactslists;
	
	@FindBy(xpath="//a[@href='/contacts/new']")
	WebElement newcontact;
	
	public ContactsPage() {//to initialize the pagefactory we have to create constructor of this page
        PageFactory.initElements(driver, this);//all the variables of this class will be initialized with driver
      //this means pointing to the current class object
	}
	
	
	public boolean verfyContacts() {
		return contactslists.isDisplayed();
		
	}
//	public void selectContacts(String name) {
//		driver.findElement(By.xpath("//a(text()='"+name+"']parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
//		//instead of @FindBy, we created a separate method to click because if rows position changes in future,it will be easy
//		//also we can click on multiple rows easily by creating a method
//		
//	}
	public NewContactPage clickonNew() {
		newcontact.click();
		return new NewContactPage();
		
	}
	
	


}
