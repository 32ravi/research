package miscLang;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Demo {
	
	 // JDBC driver name and database URL
	 static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	 static final String DB_URL = "jdbc:oracle:thin:@exa1db1a-vip:1521:SBTBD21A";
	 static final String USER_ID = "trade41_04";
	 static final String USER_PWD = "trade41_04";
	 //dev41bc3a Logging in as trade41_04/trade41_04@SBTBD21A
	 //HTS1.debug:Connected to jdbc:oracle:thin:@exa1db1a-vip:1521:SBTBD21A" 
	 
	public static void main(String[] argv) {

		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try
		{
			//STEP 1: load the driver class / Register JDBC driver; per JDBC spec, ASA driver class is loaded, it is registered with DriverManager.
			Class.forName(JDBC_DRIVER);

			System.out.println("Oracle JDBC Driver Registered!");

			//STEP 2: create  the connection object
			Connection connection = null;
			connection = DriverManager.getConnection(DB_URL, USER_ID, USER_PWD);


			if (connection != null) {
				System.out.println("You made it, take control your database now!");
			} else {
				System.out.println("Failed to make connection!");
			}
			
			//SETP 3 : Create the statement object
			Statement statement = connection.createStatement();
			
			//SETP 4 : execute query
			 ResultSet result = statement.executeQuery("select * from sbtorder");
			 System.out.println("Processing results....");
			 
			 //STEP 5 : Process result set
			 int j=0;
			 while(result.next() && j<10){
				 System.out.println("DBID:" +result.getLong(1) + " BR:" + result.getString(5) + " SEQ:" + result.getInt(6));
				 j++;
			 }
			 
			 //SETP 6 : Close the connection At the end
			 //connection.close();

			 //================================
			 //Prepared Statement for fast performance
			 String preparedSQL = "select * from sbtOrder where branch = ?";
			 PreparedStatement prepStatement = connection.prepareStatement(preparedSQL);
			 
			 prepStatement.setString(1, "YKJ");
			 result = prepStatement.executeQuery();
			 
			 while(result.next()){
				 System.out.println("DBID:" +result.getLong(1) + " BR:" + result.getString(5) + " SEQ:" + result.getInt(6));
			 }
			 //======================================
			 //update via prepared statement
			 String strUpdate = "update sbtorder set branchSequenceNumber = ? where branch =? and branchSequenceNumber = ?" ;
			 PreparedStatement prepUpdate = connection.prepareStatement(strUpdate);
			 
			 prepUpdate.setInt(1, 22);
			 prepUpdate.setString(2, "YKJ");
			 prepUpdate.setInt(3, 66);
			int upd = prepUpdate.executeUpdate();
			System.out.println("Count updated:" + upd);
			 

		}
		catch(Exception e){
			System.out.println("Something is wrong..." + e);
		}


	}

}
