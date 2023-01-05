package Bank_Application;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Scanner;


public class BankUI {

	static void openApp() throws SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("****** Welcome To Apna Bank ******");
		while(true) {
			System.out.println("1.open a bank account");
			System.out.println("2.any transactions for an account");
			System.out.println("0. Exit the application");
			System.out.println("Enter your choice:");
			int choice =s.nextInt();
			if(choice == 0) {
				System.out.println("************ Thank You ************");
				break;
			}
			else {
				int id = 0;
				String name;
				long phone;
				String email;
				String Branch;
				int balance;
				int amount = 0;
				switch(choice) {
				case 1:System.out.println("enter Accounte holder name:");
				name =s.next();
				System.out.println("enter Phone number:");
				phone=s.nextLong();
				System.out.println("enter email address:");
				email =s.next();
				System.out.println("enter branch:");
				Branch =s.next();
				System.out.println("you have to deposite some money:");
				balance=s.nextInt();
				System.out.println(BankDatabase.add(id,name,phone,email,Branch,balance));
				break;
				case 2:System.out.println("enter account id:");
				id=s.nextInt();
				System.out.println("1.widraw money");
				System.out.println("2.deposit money");
				System.out.println("3. update or change account holder name");
				System.out.println("4.exit sub menu");
				int inchoice =s.nextInt();
				if(inchoice==4) {
					System.out.println("************ Thank You ************");
					break;
				}
				switch(inchoice) {
				case 1:
					System.out.println("enter withdraw amount:");
					amount=s.nextInt();
					System.out.println(BankDatabase.updatewithdraw(id,amount));
					break;
				case 2:
					System.out.println("enter deposite amount:");
					amount=s.nextInt();
					System.out.println(BankDatabase.updateDeposite(id,amount));
					break;
				case 3:System.out.print("Enter New Name:");
				name = s.next();
				
					System.out.println(BankDatabase.updateCustomer_name(id,name));
					break;
				default: System.out.println("\n\n *** WRONG CHOICE *** \n\n");
				}
				default: System.out.println("\n\nEnter the correct choice\n\n"); 
				}
			}
		}
		
	}

}
