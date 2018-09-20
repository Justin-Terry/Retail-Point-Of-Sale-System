package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private static final String DBDRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String dbLocation;
	static Connection dbConnection;
	
	
	/* ----------------------------------------------------------------------------------
	 * Name: Database (Constructor)
	 * Input: (String) Name for database
	 * Returns: Nothing
	 * Description: Attempts to create a connection to the database <name>
	 ---------------------------------------------------------------------------------- */		
	public Database(String str) {
		try {
			dbConnection = DriverManager.getConnection("jdbc:derby:databases/" + str + "; create = true");
			if (dbConnection != null) {
				System.out.println("Created and/or connected to " + str + " database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error creating the " + str + " database.");
		}
	}
	
	
	/* ----------------------------------------------------------------------------------
	 * Name: isConnected
	 * Input: None
	 * Returns: Boolean
	 * Description: Checks to see if the dbConnection is active returns true if it is and false
	 * 				if it is closed or null.
	---------------------------------------------------------------------------------- */		
	public boolean isConnected() {
		if(dbConnection != null) {
			try {
				return !dbConnection.isClosed();
			}catch(SQLException e) {
				System.out.println("Problem checking if database is connected.");
			}
		}
		return false;
	}
	

	/* ----------------------------------------------------------------------------------
	 * Name: addTable
	 * Input: (String)Name of table, (String)Attributes for new table only
	 * Returns: Nothing
	 * Description: Accepts the name of a new table and the attributes for the new table,
	 * 				checks if the table already exists then creates it if it doesn't.
	 ---------------------------------------------------------------------------------- */	
	
	public void addTable(String name, String attributes) {
		if (!doesTableExist(name.toUpperCase())) {
			try {
				Statement stmt = dbConnection.createStatement();
				stmt.executeUpdate("CREATE TABLE " + name + "("+ attributes + ")");
			} catch (SQLException e) {
				System.out.println("Error adding table " + name);
				e.printStackTrace();
			}
		}
	}

	
	/* ----------------------------------------------------------------------------------
	 * Name: addTable
	 * Input: (String)Name of table, (String)Attributes for new table only
	 * Returns: Nothing
	 * Description: Accepts the name of a new table and the attributes for the new table,
	 * 				checks if the table already exists then creates it if it doesn't.
	 ---------------------------------------------------------------------------------- */	
	public boolean doesTableExist(String name) {
		ResultSet tables;
		while (true) {
			if (getdbMetaData() != null) {
				DatabaseMetaData dbmd = getdbMetaData();
				try {
					tables = dbmd.getTables(null, null, name, null);
					if (tables.next()) {
						return true;
					} else {
						return false;
					}
				} catch (SQLException e) {
					System.out.println("Problem getting tables from dbmd");
				}
			}
		}
	}
	
	
	/* ----------------------------------------------------------------------------------
	 * Name: getdbMetaData
	 * Input: None
	 * Returns: Database Meta Data
	 * Description: Returns the metaData for this database connection
	 ---------------------------------------------------------------------------------- */
	public DatabaseMetaData getdbMetaData() {
		try {
			return dbConnection.getMetaData();
		} catch (SQLException e) {
			System.out.println("Problem getting database meta data");
			return null;
		}
	}

}
