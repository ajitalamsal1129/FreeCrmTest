package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop;//to load the properties file
    public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
    

    //CONSTRUCTOR--we will call in child class using super keyword
    //inside the base class,we will read the properties
    //initializing prop variables
    public TestBase() {
        try{
            prop=new Properties();
            //to read the property file we have to create the object of property class
            //Properties is the default class in java
            FileInputStream ip=new FileInputStream("src/main/java/com/crm/qa/config/config.properties");
            //inside the  FileInputStream cl;ass we have to tell where exactly our prop file is available
            prop.load(ip);//load the property file
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void initialization(){//we have to call this method in child class also
        String browsername=prop.getProperty("browser"); 
        
        if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ajitalamsal/Downloads/chromedriver");
			 driver=new ChromeDriver();//this driver will be initialized.Means inside the child class also i can use it
			 //chromerdriver--constructor implements webdriver interface
			 //driver is the reference variable of webdriver interfave,we can now access the methods of webdriver interface
		}
		else if(browsername.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "/Users/ajitalamsal/Downloads/geckodriver");
		 driver=new FirefoxDriver();//it will launch blank firefox
		}else if(browsername.contentEquals("safari")) {
			driver=new SafariDriver();
		}
        e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
}



