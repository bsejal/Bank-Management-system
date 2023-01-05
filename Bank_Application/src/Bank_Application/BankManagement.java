package Bank_Application;

import java.sql.SQLException;

public class BankManagement {

	public static void main(String[] args) {
		
			try {
				BankDatabase.dbconnect();
				BankUI.openApp();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					BankDatabase.dbDisconnect();
				}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	}
	
}
