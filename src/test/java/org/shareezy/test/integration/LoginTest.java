package org.shareezy.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private final StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testLoginSucceded() throws Exception {
		driver.get(baseUrl + "/shareezy/faces/index.xhtml");
		driver.findElement(By.id("j_id_c:j_id_e")).clear();
		driver.findElement(By.id("j_id_c:j_id_e")).sendKeys("sdf");
		driver.findElement(By.id("j_id_c:j_id_f")).clear();
		driver.findElement(By.id("j_id_c:j_id_f")).sendKeys("sdf");
		driver.findElement(By.id("j_id_c:j_id_g")).click();
		assertEquals(
				"Hier kommt ein Willkommenstext hin.",
				driver.findElement(
						By.cssSelector("#center > div.ui-layout-unit-content.ui-widget-content"))
						.getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
