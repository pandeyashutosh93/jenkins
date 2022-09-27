package Utitlity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

	public WebDriver driver;

	public Utilities(WebDriver driver) {
		this.driver = driver;

	}

	public void selectDropDown(WebElement ele, String value) {
		Select sc = new Select(ele);
		sc.selectByVisibleText(value);
	}

	public void selectDD(WebElement ele, String value1) {
		Select sc = new Select(ele);
		List<WebElement> dd = sc.getOptions();
		int ddsize = dd.size();

		for (int i = 0; i < ddsize; i++) {

			if (dd.get(i).getText().equals(value1)) {

				dd.get(i).click();
				break;

			}
		}

	}

	public  void selectBootstrapDD(List<WebElement> dd, String value) {

		List<WebElement> bsdd = dd;
		for (WebElement dval : dd) {
			if (dval.getText().equals(value)) {
				dval.click();
				break;

			}
		}
	}

}
