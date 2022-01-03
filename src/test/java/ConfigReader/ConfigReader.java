package ConfigReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties properties;
	private String propertyFilePath = "Config//Config.properties";

	public ConfigReader() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}

	public String getBrowser() {
		return properties.getProperty("browser");

	}
	public String getDriverPathChrome() {
		return properties.getProperty("driver_path_chrome");
	}
	public String getDriverPathFireFox() {
		return properties.getProperty("driver_path_firefox");
	}

	public String getApplicationUrl() {
		return properties.getProperty("url");

	}
	public String getUserName() {
		return properties.getProperty("userName");
	}
	public String getPassword() {
		return properties.getProperty("password");
	}
	public String getInvoiceNameInExcel() {
		return properties.getProperty("invoiceName_in_Excel");
	}
	public String getInvoiceDateinExcel() {
		return properties.getProperty("companyID_in_Excel");
	}
}
