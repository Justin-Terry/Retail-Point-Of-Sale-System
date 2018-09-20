package mainPackage;

import gui.SceneController;
import database.Database;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	private static Database storeDB = new Database("Store");
	private static Settings settings = new Settings();

	public static void main(String[] args) {
		setUpStoreDB();	
		launch();
	}
	
	public void start(Stage window) {	
		SceneController theScene = new SceneController(window);
		window.setTitle("Retail POS System");
		window.setMaximized(true);
		window.setScene(theScene.getHomeScene());
		window.show();
	}
	
	
	public static void setUpStoreDB() {
		// Setup tables
				if (storeDB.isConnected()) {
					storeDB.addTable("Products",
							  "sku int,"
							+ "description VARCHAR(50),"
							+ "price double,"
							+ "size VARCHAR(10)");
					storeDB.addTable("Transactions",
							  "number int,"
							+ "date   VARCHAR(15)");
					if (settings.getUseCustomerDB().equals("true")) {
						storeDB.addTable("Customers",
				   	        	  "fName VARCHAR(20),"
								+ "lName VARCHAR(20),"
								+ "email VARCHAR(50)");
					}
					if (settings.getUseEmployeeDB().equals("true")) {
						storeDB.addTable("Employees",
								  "fName VARCHAR(20),"
								+ "lName VARCHAR(20),"
								+ "empNum int");
					}
					if (settings.getUseEmployeeClock().equals("true")) {
						storeDB.addTable("Punches",
								  "type int,"
								+ "date VARCHAR(10),"	//
								+ "time VARCHAR(8)");  // Convert to dateTime type of data field
					}
				}
	}

}
