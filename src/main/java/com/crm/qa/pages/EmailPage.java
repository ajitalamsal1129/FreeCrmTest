package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class EmailPage extends TestBase {
	@FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[1]/div/input")
    WebElement email;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[2]/div/input")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]")
    WebElement loginbtn;
    
    public EmailPage() {//to initialize the pagefactory we have to create constructor of this page
        PageFactory.initElements(driver, this);//all the variables of this class will be initialized with driver
    }
    public HomePage login(String em, String pw) throws InterruptedException {
    	email.sendKeys(em);
        password.sendKeys(pw);
        loginbtn.click();
        return new HomePage();//because homepage is the landing page of loginpage
        //We are returning the homepage object
    }
    }

       



