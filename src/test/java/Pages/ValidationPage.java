package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ConfigReader.ConfigReader;
import Utility.ScreenRecorderUtil;

public class ValidationPage {
	
	WebDriver driver;
	ConfigReader reader = new ConfigReader();
	ScreenRecorderUtil screenRecorder;
	String actualText_successful_import = "Amount of incorrectly read rows: 0.";
	String actualText_unsuccessful_import = "Amount of incorrectly read rows: 0.";
	String error_text="The type of the selected file is invalid";
	
	boolean status = false;
	public ValidationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@id='AButton_SAVE_']/div[1]")
	WebElement btn_Save;
	
	@FindBy(id = "GuiLabel_CH_RESUME")
	WebElement text;
	
	@FindBy(id = "GuiButton_YES")
	WebElement btn_Yes;
	
	@FindBy(id = "GuiButton_CLOSE0")
	WebElement btn_Close;
	
	@FindBy(id = "AButton_CANCEL")
	WebElement btn_Cancel;
	
	@FindBy(xpath = "//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr/td[2]")
	WebElement tableRowName;
	
	@FindBy(xpath = "//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr/td[3]")
	WebElement companyID;
	
	@FindBy(xpath = "//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr")
	WebElement tableRow;
	
	@FindBy(xpath = "//*[@id='INVOICE_IMAGE_TAB_ID']/div/div/div/div/div[1]/div/div/div/div[1]/div/img")
	WebElement invoiceImage;
	
	@FindBy(xpath = "//*[@id='UIVerticalLayout0']/div/div/div")
	WebElement errortext;
	//*[@id="UIVerticalLayout0"]/div/div/div  
	public boolean getTextFromUI() {
		
		status = text.getText().contains(actualText_successful_import);
		//System.out.println(status);
		return status;
		
	}
	public void clickOnSave() {
		btn_Save.click();
	}
	public void clickOnYesButton() {
		btn_Yes.click();
	}
	public void clickOnCancelButton() {
	btn_Cancel.click();
	}
	public WebElement getInvoiceImage() {
		return invoiceImage;
	}
	public void selectInvoiceFomList() throws Exception {
		//screenRecorder.startRecord("Data Import");
		String actual_textNameInexcel = reader.getInvoiceNameInExcel().toString();
		String actual_CompanyIDInexcel = reader.getInvoiceDateinExcel().toString();
	
		List<WebElement> invoiceList = driver.findElements(By.xpath("//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr"));
		
		for(int i=1; i<= invoiceList.size(); i++) {
			String actual_textNameInUI =driver.findElement(By.xpath("//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr["+i+"]/td[2]")).getText();
		
		String actual_CompanyIdInUI = driver.findElement(By.xpath("//*[@id='UIGridWithSimpleTableCompatibility']/div[3]/table/tbody/tr["+i+"]/td[3]")).getText();
		
		if(actual_textNameInUI.equals(actual_textNameInexcel)) {
			if(actual_CompanyIdInUI.equals(actual_CompanyIDInexcel)){
			
			
			tableRowName.click();
			//screenRecorder.stopRecord();
		}
		}
	}
}
	public String getErrorMessage() {
		return errortext.getText();
	}
	
	public String getMessage() {
		return text.getText();
	}
	
	public boolean validateErrorMessage() {
		if(getErrorMessage().equals(error_text)) {
			status = true;
		}
		return status;
		
	}
	public void clickOnClose() {
	btn_Close.click();
	}
	
	public boolean validateIncorrectfileImport() {
		if(getErrorCountFromUI()>0) {
			status = true;
		}
		return status;
	}
	public int getErrorCountFromUI() {
		String text = getMessage();
		String count = text.substring(text.lastIndexOf(":") + 1).trim();
		int number = Integer.parseInt(count.substring(0, count.length()-1));
		

		return number;
	}
}
