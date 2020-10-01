package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page factory-Object repository(OR);
	@FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[2]")
	//@Catchelookup
	WebElement LogIn;
	
    @FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[2]/a")
    WebElement signupbtn;

    @FindBy(xpath = "/html/body/div[1]/header/div/nav/div[2]/div/div[1]/div/a/span[3]/font")
    WebElement crmlogo;

    //Initializing the page objects
    public LoginPage() {//to initialize the pagefactory we have to create constructor of this page
        PageFactory.initElements(driver, this);//all the variables of this class will be initialized with driver
        //this means pointing to the current class object
       // instead of this, you can also write loginpage.class
    }

    //Now define the actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public  boolean validateCRMimage() {
        return crmlogo.isDisplayed();
    }
    public EmailPage loginclick() {
    	LogIn.click();
    	return new EmailPage();
    }

   
}



