package Bank_Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDatabase {
	
	static Connection con;
	static void dbconnect() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_bank",
				"root","sejal2610");
	}
	static void dbDisconnect() throws SQLException {
		con.close();
	}
	public static String add(int id,String name, long phone, String email, String Branch, int balance) throws SQLException {
		String query = "insert into bank_account values(?,?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setLong(3,phone);
		ps.setString(4, email);
		ps.setString(5, Branch);
		ps.setInt(6,balance);
		
		 int i =ps.executeUpdate();
		 String result="";
		 
		 if(i>0)
			 result="Account Successfully created";
		 else
			 result="somethimg went wrong";
		
		return result;
	}
	public static String updateCustomer_name(int id, String name) throws SQLException {
		String query =" update bank_account set Customer_name = ? where Customer_ID = ?";
		String result="";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, id);
		int i = ps.executeUpdate();
		
		if(i>0)
			result += "Update Successful";
		else 
			result += "Update Failed";
		return result;
	}
	public static String updatewithdraw(int id,int amount) throws SQLException {
		String query= "update bank_account SET balance=balance-? where Customer_ID = ?";
		String result="";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, amount);
		ps.setInt(2, id);
		int i = ps.executeUpdate();
		
		if(i>0)
			result += "withdraw Successful";
		else 
			result += "withdraw Failed";
		return result;
	}
	public static String updateDeposite(int id, int amount) throws SQLException {
		
		String query= "update bank_account SET balance=balance+? where Customer_ID = ?";
		String result="";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, amount);
		ps.setInt(2, id);
		int i = ps.executeUpdate();
		
		if(i>0)
			result += "withdraw Successful";
		else 
			result += "withdraw Failed";
		return result;
	}
	
	
}
