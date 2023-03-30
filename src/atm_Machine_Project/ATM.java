package atm_Machine_Project;

public class ATM {
	public static void main(String args[]) throws Exception {
		
		Option_Menu OP = new Option_Menu("HARISH", "RADHIKA", "LOGANATHAN", 
				"SHANMUGAM", "CHECKING", "SAVINGS", "#SBI000462","#BOI000562");
		OP.get_login();
		
	}

}
