package atm_Machine_Project;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Date;


public class Option_Menu extends Account {

	Option_Menu(String n, String n1, String F, String F1, String Acc, String Acc1, String IFSC, String IFSC1) {
		super(n, n1, F, F1, Acc, Acc1, IFSC, IFSC1);
	}

	Scanner Menu_Input = new Scanner(System.in); // Scanner class
	
	DecimalFormat Money_Format = new DecimalFormat("'₹'###,##0.00"); //Format to print $ & comma - Example: 1,000
	
	HashMap<Integer, Integer> data = new HashMap<>();  // Storing the Customer Number and Password in HasMap
	
	public void get_login() throws IOException {
		
		int x = 1;  // Condition x == 1 run infinite times.
		do {
			try {
			data.put(190007, 2001);  //First account number, Second Pin Number
			data.put(190020, 2002);  
			data.put(190030, 1996);  
			
			System.out.println("\n");
			System.out.println("!!!================================== Welcome ==================================!!!");
			System.out.println("\n");
			Date date = new Date(System.currentTimeMillis());  //To Print Date and Time 
			System.out.println("Date & Time: "+date);
			System.out.println("Your presence makes us very happy :)"+"\n");
			System.out.println("Enter your Customer Number: ");
			Set_Customer_Number(Menu_Input.nextInt());
			System.out.println("===================================================================================");
			System.out.println("Enter Pin Number: ");
			Set_Pin_Number(Menu_Input.nextInt());
			System.out.println("===================================================================================");
			}catch(Exception E) {
				System.out.println("\n" + "Invalid Character's. Use Only Numbers." + "\n");
				x = 2 ;
			}
			
			//Validation Purpose
			
			int c_n = get_Customer_Number();  
			int p_n = get_Pin_Number();
			if(data.containsKey(c_n) && data.get(c_n) == p_n) {   // Condition Check 
				get_Account_Type();
			}else {
				System.out.println("\n" + "Invalid Customer Number or Password" + "\n");
			}
			
		}while(x == 1); 
		
	}
	
	public void get_Account_Type() {
		System.out.println("Kindly Select the account you want to access:");
		System.out.println("Press 1 - Checking Account");
		System.out.println("Press 2 - Saving Account");
		System.out.println("Press 3 - Exit");
		System.out.println("===================================================================================");
		int selection = Menu_Input.nextInt();
		
		switch(selection) {
		
		case 1:
			get_Checking_Account();
			break;
			
		case 2:
			get_Saving_Account(); 
			break;
			
		case 3:
			System.out.println("Thank you for using this ATM");
			System.out.println("Have a Good Day :)"); 
			break;
			
		default:
			System.out.println("\n"+"Oops!!! Invalid Choice. Enter the Correct Choice :)"+"\n");
			get_Account_Type();
		}
	}
	
	public void get_Checking_Account() {
		
		System.out.println("Checking Account");
		System.out.println("Press 1 - View Balance");
		System.out.println("Press 2 - Withdraw Funds");
		System.out.println("Press 3 - Deposit Funds");
		System.out.println("Press 4 - Account Information");
		System.out.println("Press 5 - Transfer Fund");
		System.out.println("Press 6 - Exit");
		System.out.println("===================================================================================");
		int selection = Menu_Input.nextInt();
		
		switch(selection) {
		
		case 1: 
			System.out.println("Checking Account Balance: "+Money_Format.format(get_Checking_Balance()));
			System.out.println("===================================================================================");
			get_Account_Type();
			break;
			
		case 2:
			get_Checking_Withdraw_Input();
			get_Account_Type();
			break;
			
		case 3:
			get_Checking_Deposite_Input();
			get_Account_Type();
			break;
			
		case 6:
			System.out.println("Thank you for using this ATM");
			System.out.println("Have a Good Day :)"); 
			break;
			
		case 4:
			get_Checking_Account_Info();
			get_Account_Type();
			break;
			
		case 5:
			Checking_Account_Transfer();
			get_Account_Type();
			
		default:
			System.out.println("\"\\n\"+\"Oops!!! Invalid Choice. Enter the Correct Choice :)\"+\"\\n\"");
			get_Checking_Account();
	
	}
}
	
	public void get_Saving_Account() {
		
		System.out.println("Saving Account");
		System.out.println("Press 1 - View Balance ");
		System.out.println("Press 2 - Withdraw Funds");
		System.out.println("Press 3 - Deposit Funds");
		System.out.println("Press 4 - Account Information");
		System.out.println("Press 5 - Transfer Fund");
		System.out.println("Press 6 - Exit");
		System.out.println("===================================================================================");
		int selection = Menu_Input.nextInt();
		
		switch(selection) {
		
		case 1:
			System.out.println("Saving Account Balance: "+Money_Format.format(get_Saving_Balance()));
			System.out.println("===================================================================================");
		    get_Account_Type();
		    break;
		    
		case 2:
			get_Saving_Withdraw_Input();
			get_Account_Type();
			break;
			
		case 3:
			get_Saving_Deposite_Input();
			get_Account_Type();
			break;
		
		case 6:
			System.out.println("Thank you for using this ATM");
			System.out.println("Have a Good Day :)"); 
			break;
			
		case 4:
			get_Saving_Account_Info();
			get_Account_Type();
			break;
			
		case 5:
			Saving_Account_Transfer();
			get_Account_Type();
			
		default:
			System.out.println("\"\\n\"+\"Oops!!! Invalid Choice. Enter the Correct Choice :)\"+\"\\n\"");
			get_Saving_Account();
		}
		
	}
	
}
