#Author : Madhu Bala
#Desciption : User enters into Procountor webpage and import files under Data import

Feature: User login Procountor webpage and upload files with csv format under Data import category

 Scenario: User login wepage and upload the file under data import 

    Given user enter into the application site
    When user enter username and password 
    And login to the application
    When user clicks management and select import data
    Then user selects Import Invoices from Import type dropdown 
    And user choose file of csv format from drive
		Then user validates that import is successful and click on save
		And user views the imported invoice


  Scenario: User login wepage and upload the file zip under data import 

    Given user enter into the application site
    When user enter username and password 
    And login to the application
    When user clicks management and select import data
    Then user selects Import Invoices from Import type dropdown 
    And user choose file of zip format from drive
		Then user validates that import is successful and click on save
		And user views the imported invoice

   Scenario: User login wepage and upload invalid file format under data import 

    Given user enter into the application site
    When user enter username and password 
    And login to the application
    When user clicks management and select import data
    Then user selects Import Invoices from Import type dropdown 
    And user choose file of invalid format from drive
		Then user validates that import is unsuccessful and click on Ok button
		
		
		Scenario: User login wepage and upload incorrect csv file under data import 

    Given user enter into the application site
    When user enter username and password 
    And login to the application
    When user clicks management and select import data
    Then user selects Import Invoices from Import type dropdown 
    And user choose file with incorrect csv file from drive
		Then user validates that import is unsuccessful and click on cancel button
		