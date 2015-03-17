/**
 * 
 */
/**
 * @author anithan
 *
 */
package com.test.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageTest {
	private static final String SEARCH_XPATH = "//div[@id='search']";

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.pactera.com/");
		// WebDriverWait wait = new WebDriverWait(driver, 10);

		long end = 3000;// (some wait time )
		while (System.currentTimeMillis() < end) {
			WebElement pacteraHome = driver.findElement(By.xpath("//a[@href='http://www.pactera.com/' and @title='Pactera']"));
			if (pacteraHome.isDisplayed()) {
				System.out.println("Pactera Home page is displayed");
				break;
			}
		}

		WebElement search = driver.findElement(By.xpath(SEARCH_XPATH));
		WebElement searchinput = search.findElement(By.xpath("//form[@id='searchform']/input[@id='s']"));
		searchinput.sendKeys("Test Automation");

		WebElement searchButton = driver.findElement(By.xpath("//div[@id='search']//form[@id='searchform']/input[@id='searchsubmit']"));
		searchButton.click();

		while (System.currentTimeMillis() < end) {
			WebElement resultsSearch = driver.findElement(By.xpath("//div[@id='content']//em[contains(text(),'Search Results for')]"));
			WebElement resultAutoSearch = driver.findElement(By.xpath("//div[@id='content']//em[contains(text(),'Search Results for')]"));
			if (resultAutoSearch.isDisplayed()) {
				System.out.println("TEXT Displayed" + resultsSearch + resultAutoSearch.getText());
				if (resultAutoSearch.getText().contains("test automation")) {
					System.out.println("Test result - Pass , Text matches");
				} else {
					System.out.println("Test result - Fail , Text Does not  match");
				}
				break;
			}
		}

		driver.quit();
	}
}