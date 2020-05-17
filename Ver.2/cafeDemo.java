import java.util.Scanner;

public class cafeDemo{

	public static Scanner kb = new Scanner(System.in);
	public static String[] ManageMode = {"Set menu", "Set menu with file", "Menu list", "Init menu", "Get each sales", "Get statistics", "Save as file", "Set password"};
	public static int MSize = ManageMode.length;
	
	public static void main(String[] args){

		int option;
		
		System.out.println("\nWelecome to the Promi's Cafe!");
		
		Info.setDefaultMenu();
		
		while(true){

			//There is two mode here : administer and Customer
			System.out.print("\nSelect the option! (1.administer 2.Customer 0.Quit) >> ");
			option = kb.nextInt();
			kb.nextLine(); //for getting rid of '\n'

			//If the entered value is invalid, go back the first part of above while statement.
			if(option!=1&&option!=2&&option!=0){
				System.out.println("You entered invalid option. Try again!\n");
				continue;
			}

			switch(option){

				case 1:
					Manager(); // Checking all about menus
					break;
				case 2:
					Customer(); // make customer select menu
					break;
				case 0:
					System.out.println("See you next time! Have a good day! :)");
				default:
					return;
			}
		}
	}

	//Bellow Methods are for manager Mode
	public static void Manager(){

		//first, ask the password to the person trying to enter the mode.
		if(!Manager.pw_check()){
			return;
			//if entered password is incorrect over 5 times, go back to menu
		}

		while(true){

			int option;

			//There are 6 options for Managing
			for(int i=0; i<MSize; i++) {
				System.out.print(i+1 + "." + ManageMode[i] + " ");
			}
			System.out.print("0.Quit ");
			System.out.print(">> ");
			option = kb.nextInt();
			kb.nextLine();
			
			switch(option){
				
				case 1:
					if(Info.isFull()) {
						System.out.println("The menu list is already full!");
						System.out.println("Going back to opiton...\n");
					}
					else {
						System.out.print("\nEnter the name of menu: "); String name = kb.nextLine();
						System.out.print("Enter the price of menu: "); int price = kb.nextInt();
						Manager.setMenu(name, price);
						System.out.println("\nDone of adding a menu!");
						System.out.println("Menu name: " + name);
						System.out.println("Price: " + price + "\n");
					}
					break;
				case 2:
					Manager.setMenuFromFile();
					break;
				case 3:
					Manager.showMenu(); //show each menu and each price
					break; 
				case 4:
					Manager.initMenu(); // initialize all the menu.
					System.out.println("\nDone of initializing!\n");
					break;
				case 5:
					Manager.showSales();// show each menu and each sales
					break;
				case 6:
					Manager.showStatistics(); // show the total customer number and total sales.
					break;
				case 7:
					Manager.saveAsFile();
					break;
				case 8:
					System.out.print("\nEnter the new password >> ");
					String newPW = kb.nextLine();
					Manager.setPassword(newPW);
					System.out.println("Done of setting password! You should remember that\n");
					break;
				case 0:
					return;
				default:
					System.out.println("You entered invalid option. Try again!\n");
			}
		}
	}

	//Bellow methods are for Customer mode.
	public static void Customer(){

		int menu;
		
		Info.showMenu(); // using show menu in Info class.
		System.out.print("Select the menu >> "); menu = kb.nextInt();
		
		int index = menu-1; // for access a certain index.
		int size = Info.getCount(); // this size is different from size in Info class.
		boolean isValid = false;
		
		for(int i=0; i<size;i++) { // check the entered menu is valid or not.
			if((menu-1)==i) {
				isValid = true; 
				break;
			}
		}
		
		if(isValid) {
			Customer.buy(index);
			return;
		}
		else {
			System.out.println("You entered invalid menu. Going back to the main option...");
			return;
		}
	}
}

	
