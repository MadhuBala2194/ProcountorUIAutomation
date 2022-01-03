package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DataImportPage {
	WebDriver driver;

	public DataImportPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//div[@id='MANAGEMENT']//span[@role='text']//span[1]")
	WebElement text1;
	@FindBy(css ="div[id='MANAGEMENT'] span[role='text'] span:nth-child(1)")
	WebElement text;
	@FindBy(xpath ="//div[@id='MANAGEMENT']")
	WebElement text2;
	@FindBy(xpath ="//span[contains(text(),'Import data')]")
	WebElement dataImport;
	
	@FindBy(xpath ="//input[@id='SearchParameterTextField']")
	WebElement txtSearchBox;
	
	@FindBy(id ="UIButton_Management----em-class--match--Import-data--em-")
	WebElement linkText;
	
	@FindBy(id ="GuiChoice_CH_IMPORTTYPE")
	WebElement importTypeDropDown;
	
	@FindBy(xpath ="//span[normalize-space()='Import invoices (CSV, DDE, ZIP)']")
	WebElement selectImportInvoice;
	
	@FindBy(id ="AButton_SELECT_FILE_")
	WebElement btn_SelectFile;
	
	@FindBy(className="gwt-FileUpload")
	WebElement btn_ChooseFile;
	
	@FindBy(id ="GuiButton_CONTINUE")
	WebElement btn_Continue;
	
	@FindBy(xpath ="//*[@id='AButton_CONTINUE']/div")
	WebElement btn_ContinueImportData;
	
	public WebElement selectManagement() {
		return text2;
		
	}
	public WebElement selectImportData() {
		return dataImport;
	}
	public void searchBox() {
		txtSearchBox.sendKeys("Import Data");
	}
	public void selectLink() {
		 linkText.click();
	}
	public void selectImportType() {
		 importTypeDropDown.click();
	}

	public void selectIportInvoiceFromDropDown() {
		selectImportInvoice.click();
	}
	public void selectFile() {
		 btn_SelectFile.click();
	}
	public void chooseFile(String filePath) {
		 btn_ChooseFile.sendKeys(filePath);
	}

	public void clickContinue() {
		btn_Continue.click();
	}
	public void clickContinueButtonOnDataImportScreen() {
		btn_ContinueImportData.click();
	}
}
