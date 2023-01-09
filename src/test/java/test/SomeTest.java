/*
 * The MIT License
 *
 * Copyright 2016 CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class devops{
	public static void main(String[] args) {
		
		testSuccessfulLogin();
		testSuccessfulSignup();
		testIncorrectLogin();
		testEmptyFieldsLogin();
		testExistingEmailSignup();
	}
	
	public static void testSuccessfulLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		  // Navigate to the login page
		  driver.get("https://app.dealmachine.com/login");

		  // Enter a valid username and password
		  driver.findElement(By.name("email")).sendKeys("umerhayat176@gmail.com");
		  driver.findElement(By.name("password")).sendKeys("umer12345");

		  // Click the login button
		  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

		  // Verify that the user is redirected to the home screen
		  String currentUrl = driver.getCurrentUrl();
		  assertEquals("https://app.dealmachine.com/home", currentUrl);
		}
	
	@Test
	public static void testSuccessfulSignup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the signup page
	  driver.get("https://app.dealmachine.com/signup");

	  // Enter a unique email and valid password
	  driver.findElement(By.name("email")).sendKeys("testuser@gmail.com");
	  driver.findElement(By.name("password")).sendKeys("testpass");

	  // Click the signup button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that the user is redirected to the home screen
	  String currentUrl = driver.getCurrentUrl();
	  assertEquals("https://app.dealmachine.com/home", currentUrl);
	}
	
	@Test
	public static void testIncorrectLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the login page
	  driver.get("https://app.dealmachine.com/login");

	  // Enter a valid username and incorrect password
	  driver.findElement(By.name("email")).sendKeys("testuser");
	  driver.findElement(By.name("password")).sendKeys("incorrectpass");

	  // Click the login button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("Incorrect password", errorMessage.getText());
	}
	
	@Test
	public static void testEmptyFieldsLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the login page
	  driver.get("https://app.dealmachine.com/login");

	  // Leave the username and password fields empty
	  driver.findElement(By.name("email")).sendKeys("");
	  driver.findElement(By.name("password")).sendKeys("");

	  // Click the login button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("email and password cannot be empty", errorMessage.getText());
	}
	
	@Test
	public static void testExistingEmailSignup() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	  // Navigate to the signup page
	  driver.get("https://app.dealmachine.com/signup");

	  // Enter an email that is already in use
	  driver.findElement(By.id("email")).sendKeys("testuser@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("testpass");

	  // Click the signup button
	  driver.findElement(By.xpath("//*[@id=\"deal-signup-inner\"]/div[2]/div/div[1]/div/form/div[2]/div[1]/div/div/div")).click();

	  // Verify that an error message is displayed
	  WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));
	  assertTrue(errorMessage.isDisplayed());
	  assertEquals("Email already in use", errorMessage.getText());
	}
	
}
}