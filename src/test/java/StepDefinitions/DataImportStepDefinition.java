package StepDefinitions;

import java.io.IOException;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import BaseClass.BaseClass;
import BaseClass.CheckInvoiceImage;
import ConfigReader.ConfigReader;
import Pages.DataImportPage;
import Pages.LoginPage;
import Pages.ValidationPage;
import Utility.ScreenRecorderUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataImportStepDefinition {

	WebDriver driver;
	BaseClass baseClass = new BaseClass();
	ConfigReader reader = new ConfigReader();
	ScreenRecorderUtil screenRecorder;
	LoginPage page;
	DataImportPage dataImportpage;
	ValidationPage validatePage;
	CheckInvoiceImage image;
	WebElement element;
	boolean status = false;
	String inputFileLocation_csv =System.getProperty("user.dir") +"\\Inputfile\\exampleInvoice.csv";
	String inputFileLocation_zip =System.getProperty("user.dir") +"\\Inputfile\\CSV_INVOICE_IMPORT.zip";
	String inputFileLocation_invalid = System.getProperty("user.dir") +"\\Inputfile\\exampleinvoice.txt";
	String inputFileLocation_incorrect = System.getProperty("user.dir") +"\\Inputfile\\exampleInvoiceIncorrect.csv";
	
	@Before
	public WebDriver setup() throws Exception {

		driver = baseClass.chooseBrowser();
		
		screenRecorder.startRecord("Data Import");
		
		baseClass.openApplication(driver);
		
		return driver;
	}

	@Given("^user enter into the application site$")
	public void user_enter_into_the_application_site() {

		page = new LoginPage(driver);
		
		element = page.verifyPageLoaded();

		baseClass.waitForElementToDisplay(driver, element);

	}

	@When("^user enter username and password$")
	public void user_enter_username_and_password() {
		
		page = new LoginPage(driver);
		
		page.acceptCookies();
		
		page.enterUserName(reader.getUserName());
		
		page.enterPassword(baseClass.decodePassword());

	}

	@Then("^login to the application$")
	public void click_on_signin_button() {
		
		page = new LoginPage(driver);
		
		page.clickNext();
		
		element = page.clickConfirm();
		
		/*
		 * if(element.isEnabled()) { Actions actions = new Actions(driver);
		 * actions.moveToElement(page.clickConfirm()).click().perform(); }
		 */	 
		
		page.clickOkButton();

	}

	@When("^user clicks management and select import data$")
	public void user_clicks_management_and_select_import_data() {
		
		dataImportpage = new DataImportPage(driver);

		dataImportpage.searchBox();

		dataImportpage.selectLink();
	}

	@Then("^user selects Import Invoices from Import type dropdown$")
	public void user_selects_Import_invoces_from_Import_type_dropdown() throws InterruptedException {

		dataImportpage = new DataImportPage(driver);
		
		dataImportpage.selectImportType();
		
		Thread.sleep(1000);
		
		dataImportpage.selectIportInvoiceFromDropDown();

		dataImportpage.selectFile();

	}

	@And("^user choose file of csv format from drive$")
	public void user_choose_cvs_file_from_drive() {
		
		dataImportpage = new DataImportPage(driver);

		dataImportpage.chooseFile(inputFileLocation_csv);
		
		dataImportpage.clickContinue();
		
		dataImportpage.clickContinueButtonOnDataImportScreen();
	}
	@And("^user choose file of zip format from drive$")
	public void user_choose_zip_file_from_drive() {
		
		dataImportpage = new DataImportPage(driver);

		dataImportpage.chooseFile(inputFileLocation_zip);
		
		dataImportpage.clickContinue();
		
		dataImportpage.clickContinueButtonOnDataImportScreen();
	}
	@And("^user choose file of invalid format from drive$")
	public void user_choose_invalid_file_from_drive() {
		
		dataImportpage = new DataImportPage(driver);

		dataImportpage.chooseFile(inputFileLocation_invalid);
		
		dataImportpage.clickContinue();	
		
		dataImportpage.clickContinueButtonOnDataImportScreen();
	}
	@Then("^user validates that import is unsuccessful and click on Ok button$")
	public void user_validates_that_import_is_unsuccessful_and_click_on_close() {
		
		validatePage = new ValidationPage(driver);
	
		
		status = validatePage.validateErrorMessage();
		
		if(status) {
			
			Assert.assertTrue(status);
		}
		
		//validatePage.clickOnClose();
	}

	@Then("^user validates that import is successful and click on save$")
	public void user_validates_that_import_successful_and_save() {
		
		validatePage = new ValidationPage(driver);
		
		 status = validatePage.getTextFromUI();
		 
		if (status) {
			
			validatePage.clickOnSave();
		}
	}

	@And("^user views the imported invoice$")
	public void user_views_the_imported_invoice() throws Exception {
		
		validatePage = new ValidationPage(driver);
		
		validatePage.clickOnYesButton();
		
		validatePage.selectInvoiceFomList();
		
		image = new CheckInvoiceImage(driver);
		
		status = image.imagePresentorNot();
		
		if(status) {
			
			Assert.assertTrue(status);
			
		}
	}
	
	@And("^user choose file with incorrect csv file from drive$")
	public void user_choose_file_with_incorrect_csv_file_from_drive() {
		
		dataImportpage = new DataImportPage(driver);

		dataImportpage.chooseFile(inputFileLocation_incorrect);
		
		dataImportpage.clickContinue();	
		
		dataImportpage.clickContinueButtonOnDataImportScreen();

	}
	
	@Then("^user validates that import is unsuccessful and click on cancel button")
	public void user_validates_that_import_is_unsuccessful_and_click_on_cancel_button() {
	
		validatePage = new ValidationPage(driver);
		
		status = validatePage.validateIncorrectfileImport();
		
		if(status) {
			
			Assert.assertTrue(status);
		}
		
		validatePage.clickOnCancelButton();
		
	}
	
	@After
	public void tearDown() throws Exception {
		screenRecorder.stopRecord();
		driver.close();
		driver.quit();
	}
}
