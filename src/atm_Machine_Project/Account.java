package atm_Machine_Project;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Account {

	private int Customer_Number;
	private int Pin_Number;
	private double Checking_Balance = 0;
	private double Saving_Balance = 0;
	private String name,name1;
	private String F_name,F_name1; 
	private String Acc_type,Acc_type1; 
	private String IFSC,IFSC1;
	
	Account(String n,String n1,String F,String F1,String Acc,String Acc1,String iFSC2,String iFSC12){
		this.name = n;
		this.name1 = n1;
		this.F_name = F;
		this.F_name1 = F1;
		this.Acc_type = Acc;
		this.Acc_type1 = Acc1;
		this.IFSC = iFSC2;
		this.IFSC1 = iFSC12;
	}
	
	Scanner input = new Scanner(System.in);
	DecimalFormat Money_Format = new DecimalFormat("'₹'###,##0.00");
	
	public int Set_Customer_Number(int S_C_N) {       // Getter setters Methods
		this.Customer_Number = S_C_N;
		return Customer_Number;
	}
	
	public int get_Customer_Number() {
		return Customer_Number;
	}
	
	public int Set_Pin_Number(int S_P_N) {
		this.Pin_Number = S_P_N;
		return Pin_Number;
	}
	
	public int get_Pin_Number() {
		return Pin_Number;
	}
	
	public double get_Checking_Balance() {
		return Checking_Balance;
	}
	
	public double get_Saving_Balance() {
		return Saving_Balance;
	}
	
	public double Cal_Checking_Withdraw(double amount) {  // Calculate checking account Withdraw
		Checking_Balance = (Checking_Balance - amount);
		return Checking_Balance;
	}
	
	public double Cal_Saving_Withdraw(double amount) {    // Calculate saving account Withdraw
		Saving_Balance = (Saving_Balance - amount);
		return Saving_Balance;
	}
	
	public double Cal_Checking_Deposit(double amount) {   // Calculate checking account Deposit
		Checking_Balance = (Checking_Balance + amount);
		return Checking_Balance;
	}
	
	public double Cal_Saving_Deposit(double amount) {     // Calculate saving account Deposit
		Saving_Balance = (Saving_Balance + amount);
		return Saving_Balance;
	}
	
	public void get_Checking_Account_Info() {
		System.out.println("Account Number: "+get_Customer_Number());
		System.out.println("User Name: "+name);
		System.out.println("User Father Name: "+F_name);
		System.out.println("Type of Account: "+Acc_type);
		System.out.println("IFSC Code: "+IFSC);
		System.out.println("===================================================================================");
		
	}
	
	public void get_Saving_Account_Info() {
		System.out.println("Account Number: "+get_Customer_Number());
		System.out.println("User Name: "+name1);
		System.out.println("User Father Name: "+F_name1);
		System.out.println("Type of Account: "+Acc_type1);
		System.out.println("IFSC Code: "+IFSC1);
		System.out.println("===================================================================================");
	}
	
	public void Checking_Account_Transfer() {
		Saving_Balance = Checking_Balance + Saving_Balance;
		Cal_Checking_Withdraw(Checking_Balance);
		System.out.println("Transaction Succussfull  :)");
		System.out.println("===================================================================================");
	}
	
	public void Saving_Account_Transfer() {
		Checking_Balance = Saving_Balance + Checking_Balance;
		Cal_Saving_Withdraw(Saving_Balance);
		System.out.println("Transaction Succussfull  :)");
		System.out.println("===================================================================================");
	}
	
	public void get_Checking_Withdraw_Input() {      
		System.out.println("Checking Account Balance: "+Money_Format.format(Checking_Balance));
		System.out.println("Enter the amount you want to withdraw from Checking Account:");
		double amount = input.nextDouble();
		
		if((Checking_Balance - amount) >= 0) {
			Cal_Checking_Withdraw(amount);
			System.out.println("Dear User, your A/C XXXX - Debited Amount Succussfully. Debited Amount: "+amount);		
			System.out.println("New Checking Account Balance: "+Money_Format.format(Checking_Balance));
			System.out.println("===================================================================================");
		}else {
			System.out.println("Insufficient balance :(");
			System.out.println("===================================================================================");
		}
	}
	
	public void get_Saving_Withdraw_Input() {
		System.out.println("Saving Account Balance: "+Money_Format.format(Saving_Balance));
		System.out.println("Enter the amount you want to withdraw from Saving Account");
		double amount = input.nextDouble();
		
		if((Saving_Balance - amount) >= 0) {
			Cal_Saving_Withdraw(amount);
			System.out.println("Dear User, your A/C XXXX - Debited Amount Succussfully. Debited Amount: "+amount);
			System.out.println("New Saving Account Balance: "+Money_Format.format(Saving_Balance));
			System.out.println("===================================================================================");
		}else {
			System.out.println("Insufficient balance :(");
			System.out.println("===================================================================================");
		}
	}
	
	public void get_Checking_Deposite_Input() {
		System.out.println("Checking Accouunt Balance: "+Money_Format.format(Checking_Balance));
		System.out.println("Enter how much money you want to deposite to checking account: ");
		double amount = input.nextDouble();
		
		if((Checking_Balance + amount) >=0 ) {
			Cal_Checking_Deposit(amount);
			System.out.println("Dear User, your A/C XXXX - Credited Amount Succussfully. Credited Amount: "+amount);
			System.out.println("New checking account balance: "+Money_Format.format(Checking_Balance));
			System.out.println("===================================================================================");
		}else {
			System.out.println("Balance Cannot be Negative :(");
			System.out.println("===================================================================================");
		}
	}
	
	public void get_Saving_Deposite_Input() {
		System.out.println("Saving Account Balance: "+Money_Format.format(Saving_Balance));
		System.out.println("Enter how much money you want to deposite to Saving Account: ");
		double amount = input.nextDouble();
		
		if((Saving_Balance + amount) >= 0) {
			Cal_Saving_Deposit(amount);
			System.out.println("Dear User, your A/C XXXX - Credited Amount Succussfully. Credited Amount: "+amount);
			System.out.println("New Saving account balance: "+Money_Format.format(Saving_Balance));
			System.out.println("===================================================================================");
		}else {
			System.out.println("Balance cannot be Negative :(");
			System.out.println("===================================================================================");
		}
	}

	
}
