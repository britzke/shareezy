package org.shareezy.test.integration;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Eine Integrationstestunit, die die Ressourcenliste, Detailansicht der
 * Ressource und deren Navigation überprüft.
 * 
 * @author tim treibmann
 * 
 */

public class TestRessourcenListeNavigation {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Testet die Navigation in der Ressourcenliste mit dem 1 und 2 Elemente der
	 * Liste und überprüft, ob der Name der Ressource in der Liste, bei einer
	 * erfolgreichen Navigation in die Detailansicht, gleich der Name der
	 * angezeigten Ressource in der Detailansicht ist.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testREssourcenListeNavigation() throws Exception {
		driver.get(baseUrl + "/shareezy/faces/ressourcenList.xhtml");
		String texteins = driver.findElement(
				By.xpath("//div/table/tbody/tr/td")).getText();
		driver.findElement(By.xpath("//td[6]/button")).click();
		assertEquals(texteins, driver.findElement(By.cssSelector("h3"))
				.getText());

		driver.findElement(By.linkText("Ressourcenliste")).click();

		String textzwei = driver.findElement(
				By.xpath("//div/table/tbody/tr[2]/td")).getText();
		driver.findElement(By.xpath("//tr[2]/td[6]/button")).click();
		assertEquals(textzwei, driver.findElement(By.cssSelector("h3"))
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
}
