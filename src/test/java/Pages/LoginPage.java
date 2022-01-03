package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id ="MANAGEMENT")
	WebElement text;
	
	@FindBy(id ="LocalizableTextField_CH_LOGINNAME")
	WebElement userName;
	
	@FindBy(id ="LocalizableUIPasswordField_CH_PASSWORD")
	WebElement password;
	
	@FindBy(xpath="//*[@id='LoginPageButton_BUTTON_NEXT']")
	WebElement nextButton;
	
	@FindBy(id ="LoginPageButton_BUTTON_CONFIRM")
	WebElement confirm;
	@FindBy(xpath ="//div[@id='GuiButton_OK']")
	WebElement OKbutton;
	@FindBy(xpath ="//*[@id='LoginPageButton_BUTTON_OK']")
	WebElement acceptCookies;
	
	
	public WebElement verifyPageLoaded() {
	return text;
}
	public void enterUserName(String username) {
		userName.sendKeys(username);
	}
	public void enterPassword(String Password) {
		 password.sendKeys(Password);
	}
	public void clickNext() {
		nextButton.click();
	}
	public WebElement clickConfirm() {
		return confirm;
	}
	public void clickOkButton() {
		OKbutton.click();
}
	public void acceptCookies() {
		 acceptCookies.click();
	}
}
