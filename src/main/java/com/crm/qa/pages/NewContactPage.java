package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase{
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(name="category")
	WebElement option;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/form/div[4]/div[2]/div/div/div[2]/div[3]")
	WebElement choice;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebtn;
	
	//Initializing the page objects
    public NewContactPage() {//to initialize the pagefactory we have to create constructor of this page
        PageFactory.initElements(driver, this);//all the variables of this class will be initialized with driver
      //this means pointing to the current class object
        // instead of this, you can also write loginpage.class
     }
	
	public void createNewContact(String fname,String lname,String emailid) {
		firstName.sendKeys(fname);
		LastName.sendKeys(lname);
		email.sendKeys(emailid);
		option.click();
		
		List <WebElement> list=driver.findElements(By.xpath("//div[@class='visible menu transition']//div"));


        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());//for individual element we have to do get(i) because we used list class
			if(list.get(i).getText().contains("Customer")) {//either equals or contains
				list.get(i).click();
				break;
			}
        }
            savebtn.click();
        }
	}

        
		
		
		
		
	
	
	
	
	
	
	
	
	

