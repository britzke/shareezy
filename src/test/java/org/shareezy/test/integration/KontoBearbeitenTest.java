package org.shareezy.test.integration;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KontoBearbeitenTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/shareezy/faces/accountBearbeiten.xhtml";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testKontoBearbeiten() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("j_id_10:eMail")).clear();
    driver.findElement(By.id("j_id_10:eMail")).sendKeys("Test@test.com");
    driver.findElement(By.id("j_id_10:kennwort")).clear();
    driver.findElement(By.id("j_id_10:kennwort")).sendKeys("123");
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).clear();
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).sendKeys("123");
    driver.findElement(By.id("j_id_10:altesKennwort")).clear();
    driver.findElement(By.id("j_id_10:altesKennwort")).sendKeys("1234");
    driver.findElement(By.id("j_id_10:j_id_16")).click();
    driver.findElement(By.id("j_id_10:kennwort")).clear();
    driver.findElement(By.id("j_id_10:kennwort")).sendKeys("123");
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).clear();
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).sendKeys("1234");
    driver.findElement(By.id("j_id_10:altesKennwort")).clear();
    driver.findElement(By.id("j_id_10:altesKennwort")).sendKeys("1234");
    driver.findElement(By.id("j_id_10:j_id_16")).click();
    driver.findElement(By.id("j_id_10:kennwort")).clear();
    driver.findElement(By.id("j_id_10:kennwort")).sendKeys("123");
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).clear();
    driver.findElement(By.id("j_id_10:kennwortWiederholung")).sendKeys("123");
    driver.findElement(By.id("j_id_10:altesKennwort")).clear();
    driver.findElement(By.id("j_id_10:altesKennwort")).sendKeys("123");
    driver.findElement(By.id("j_id_10:j_id_16")).click();
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
