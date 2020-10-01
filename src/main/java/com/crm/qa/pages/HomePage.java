package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	@FindBy(xpath="//span[@class='user-display']")
	WebElement userName;
	
	@FindBy(xpath="//*[@id='main-nav']/a[3]/span")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[5]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[6]/span")
	WebElement tasksLink;
	
	//Initializing the page objects
    public HomePage() {//to initialize the pagefactory we have to create constructor of this page
        PageFactory.initElements(driver, this);//all the variables of this class will be initialized with driver
      //this means pointing to the current class object
        // instead of this, you can also write loginpage.class
     }

     //Now define the actions
    public String verifyPageTitlke() {
    	return driver.getTitle();
    	
    }
    public boolean verifyUsername() {
    	return userName.isDisplayed();
    
    }
    public ContactsPage clickOnContacts() {
    	contactsLink.click();
    	return new ContactsPage();
    }
     public DealsPage clickOnDeals() {
    	 dealsLink.click();
    	 return new DealsPage();
     }
     
     public TasksPage clickOnTasks() {
    	 tasksLink.click();
    	 return new TasksPage();
     }
    
	
	
	
	
	

}
