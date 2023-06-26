package Selejav;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AzureTF1 {
	
	public static WebDriver driver;
	public static Logger log = Logger.getLogger(AzureTF1.class.getName());
	public static File f1 = new File("C:\\Users\\Trigger\\eclipse-workspace\\Selenium\\OR.Properties");
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		PropertyConfigurator.configure("C:\\Users\\Trigger\\eclipse-workspace\\Selenium\\log4j.properties");
		ChromeOptions co =new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		co.addArguments("start-maximized");
		
		driver = new ChromeDriver(co);
		
		log.info("Starting Chrome");
		driver.get(" https://itera-qa.azurewebsites.net/home/automation");
		log.info("Url launch Successly");
//1.TextArea Practice 
		driver.findElement(By.id("name")).sendKeys("Hashini");
		driver.findElement(By.id("phone")).sendKeys("9084835749");
		driver.findElement(By.id("email")).sendKeys("hashini12345@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Hashini@9080");
		driver.findElement(By.id("address")).sendKeys("Laxmi Mills,Coimbatore");
		driver.findElement(By.name("submit")).click();
		log.info("Text entered successly");
//2.check box, Radio
		WebElement fm =driver.findElement(By.id("female"));			//radio
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", fm);
		
		driver.findElement(By.id("tuesday")).click();				//check box	
		driver.findElement(By.id("friday")).click();
		log.info("Buttons clicked successly");
//3.DropDown - 
		Select drpcon = new Select(driver.findElement(By.className("custom-select")));
		drpcon.selectByValue("1");
		log.info("Drop down selected successly");
		
		FileInputStream fs = new FileInputStream(f1);
		Properties prop = new Properties();
		prop.load(fs);
//Radio		
		WebElement rad=driver.findElement(By.xpath(prop.getProperty("rad_xp")));
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		js3.executeScript("arguments[0].click();", rad);
		log.info("Radio Xpath Selected successly");
//check box
		WebElement chk1=driver.findElement(By.xpath(prop.getProperty("chk1_xp")));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", chk1);
		
		WebElement chk2=driver.findElement(By.xpath(prop.getProperty("chk2_xp")));
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", chk2);
		log.info("check box Xpath selected successly");
		
		//driver.close();
	}

}
