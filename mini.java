package com.minimvn;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class mini {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HARIKRISHNAN S\\eclipse-workspace\\Maven_Project_New_1\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		
		//login success
		
		driver.get("http://localhost:7080/login");
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("tomsmith");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		WebElement login = driver.findElement(By.className("radius"));
		login.click();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		logout.click();
		
		System.out.println("Login success");
		Thread.sleep(2000);
		//driver.clear();
		
		
		//login fail
		
		driver.get("http://localhost:7080/login");
		
		WebElement username1 = driver.findElement(By.name("username"));
		username1.sendKeys("tomsmith");

		WebElement password1 = driver.findElement(By.name("password"));
		password1.sendKeys("SuperSecretpassword!");

		WebElement login1 = driver.findElement(By.xpath("//*[@id=\"login\"]/button/i"));
		login1.click();
		Thread.sleep(2000);
		System.out.println("Login failed");
		
		
		
		//CheckBoxes
		
		driver.get("http://localhost:7080/checkboxes");
		WebElement checkbox =  driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
		checkbox.click();
		System.out.println("Checkbox clicked");
		Thread.sleep(2000);
		
		WebElement unchecked = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
		unchecked.click();
		Thread.sleep(2000);
	
		
		
		//drag and Drop
		
		driver.get("http://localhost:7080/drag_and_drop");

		WebElement source = driver.findElement(By.id("column-a"));
		WebElement target = driver.findElement(By.id("column-b"));
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source,target).build().perform();
		System.out.println("Drag and drop done");
		Thread.sleep(1000);
		
	
	
		
		//Drop down
		
		driver.get("http://localhost:7080/dropdown");
		WebElement Select = driver.findElement(By.id("dropdown"));
		Select s1 =new Select(Select);
	
		s1.selectByVisibleText("Option 1");
		System.out.println("selected option1 in drop down");
		Thread.sleep(2000);
	
//		
		
		//Dynamic content 
		
		driver.get("http://localhost:7080/dynamic_content");
		driver.navigate().refresh();
		System.out.println("Content refreshed");
		Thread.sleep(5000);
		
		
		//dynamic control 
		
		driver.get("http://localhost:7080/dynamic_controls");
		WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
		checkbox3.click();
		WebElement removebutton = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		removebutton.click();
		
//		WebElement control = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
//		WebDriverWait wait = new WebDriverWait (driver,30);
//		wait.until(ExpectedConditions.visibilityOf(control));
//		

		WebElement enabled = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		enabled.click();
		
		WebElement disabled = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		disabled.click();
		Thread.sleep(2000);
		System.out.println("Dynamic control success");
	
		
		//File Download
		driver.get("http://localhost:7080/download");
		
		WebElement download = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		download.click();
		Thread.sleep(2000);
		
			
		//upload	
		driver.get("http://localhost:7080/upload");
		Thread.sleep(2000);
		WebElement addfile = driver.findElement(By.id("file-upload"));
		 Actions at = new Actions(driver);
		 at.moveToElement(addfile).perform();
		
		addfile.sendKeys("C:\\Users\\HARIKRISHNAN S\\Downloads\\dotdash-meredith-logo.avif");
		Thread.sleep(2000);
		
		WebElement upload = driver.findElement(By.id("file-submit"));
		upload.click();
		Thread.sleep(2000);
		
		System.out.println("File Uploaded");
		
		//Scroll down
//		driver.get("http://localhost:7080/floating_menu");
//		Thread.sleep(2000);
//		WebElement scrolldown = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/p[9]/text()"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();",scrolldown);
//		js.executeScript("window.scrollBy(0,2500)");
//		WebElement scrolldown1 = driver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li[1]/a"));
//		String actual = scrolldown1.getText();
//		Assert.assertEquals("Home", actual);
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0,-2500)");
//		System.out.println("Scroll down");
//		
		
		//Iframe
		driver.get("http://localhost:7080/iframe");
		
		WebElement popup = driver.findElement(By.xpath("/html/body/div[4]/div/div/button"));
		popup.click();
		driver.switchTo().frame(0);
		WebElement text = driver.findElement(By.xpath("//*[@id=\"tinymce\"]"));
		text.clear();
		text.sendKeys("Iframe test");
		String actual1 = text.getText();
		Thread.sleep(2000);
	Assert.assertEquals("Iframe test", actual1);
		
		
		//Mouse Hover
		
		driver.get("http://localhost:7080/hovers");
		WebElement image1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
		WebElement image2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
		WebElement image3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
		
		Actions act = new Actions(driver);
		act.moveToElement(image1).build().perform();
		Thread.sleep(2000);
		act.moveToElement(image2).build().perform();
		Thread.sleep(2000);
		act.moveToElement(image3).build().perform();
		
		//JavaScript Alert
		
		driver.get("http://localhost:7080/javascript_alerts");
		WebElement alert = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
		alert.click();
		WebDriverWait wait1 = new WebDriverWait (driver,30);
		wait1.until(ExpectedConditions.alertIsPresent());
		Alert alertjs = driver.switchTo().alert();
		String textt = alertjs.getText();
		Thread.sleep(2000);
		alertjs.dismiss();
		  
		WebElement alertconfirm = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
		alertconfirm.click();
		WebDriverWait wait2 = new WebDriverWait (driver,30);
		wait2.until(ExpectedConditions.alertIsPresent());
		Alert alertjs1 = driver.switchTo().alert();
		String text1 = alertjs1.getText();
		Thread.sleep(2000);
		alertjs1.accept();
		
		WebElement alertpromot = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
		alertpromot.click();
		WebDriverWait wait3 = new WebDriverWait (driver,30);
		wait3.until(ExpectedConditions.alertIsPresent());
		Alert alertjs2 = driver.switchTo().alert();
		String text2 = alertjs1.getText();
		alertjs2.sendKeys("I am a JS prompt");
		Thread.sleep(2000);
		alertjs2.accept();
		
		// Open New Tab
		driver.get("http://localhost:7080/windows");
		Thread.sleep(2000);
		WebElement newwindow = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
		newwindow.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> i = set.iterator();
		String pw = i.next();
		String ch = i.next();
		driver.switchTo().window(ch);
		Thread.sleep(2000);
		driver.close();
		System.out.println("New Tab done");
		
	
	
	// Notification Message
		WebDriver driver1 = new ChromeDriver();

		driver1.get("http://localhost:7080/notification_message_rendered");
		WebElement message = driver1.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		Thread.sleep(2000);
		message.click();
		Thread.sleep(2000);
		WebElement message2 = driver1.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
		message2.click();
	
		WebElement message3 = driver1.findElement(By.xpath("//*[@id=\"flash\"]"));
		String noti= message3.getText();
		System.out.println(noti);
		Thread.sleep(3000);
		driver1.close();
	
		
	}

	}

