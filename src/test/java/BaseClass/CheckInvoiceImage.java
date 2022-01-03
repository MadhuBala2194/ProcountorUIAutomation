package BaseClass;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Pages.ValidationPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CheckInvoiceImage {
	WebDriver driver;
	WebElement element;
	ValidationPage page;
	
	public CheckInvoiceImage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public boolean imagePresentorNot() throws IOException{
		
		page = new ValidationPage(driver);
		
		element = page.getInvoiceImage();
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		Boolean imgPresent =  (Boolean) (js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element));
	  
	 return imgPresent;
}
}
