package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Settings {
	private static final String SETTINGSPATH = "src/mainPackage/settings.txt";
	private String useEmployeeDB = "true";
	private String useCustomerDB = "true";
	private String useEmployeeClock = "true";

	public Settings() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(SETTINGSPATH));
			String setting = br.readLine();
			useEmployeeDB = setting.substring(16,setting.length());
			setting = br.readLine();
			useCustomerDB = setting.substring(16,setting.length());
			setting = br.readLine();
			useEmployeeClock = setting.substring(19, setting.length());
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Failed to load settings.txt");
		}

	}
	
	public String getUseEmployeeDB() {
		return useEmployeeDB;
	}
	
	public String getUseCustomerDB() {
		return useCustomerDB;
	}
	
	public String getUseEmployeeClock() {
		return useEmployeeClock;
	}

}
