import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// this class has the right to access Info class directly. Because Info menu exists for Manager!
public class Manager {
	
	private static String password = "Handong Promi"; // initial password. 
	private static final int pw_chance = 5; // 
	private static Scanner kb;
	
//Getter and Setter for private instance variables.	
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Manager.password = password;
	}
	public static int getPw_chance() {
		return pw_chance;
	}


// this method is for entering Manager mode in cafeDemo.java
	public static Boolean pw_check() {
		
		String input;
		int leftChance = getPw_chance();
		kb = new Scanner(System.in);
		
		while(leftChance>0){

			System.out.print("\nEnter the password for manager. >> ");
			input = kb.nextLine();
			leftChance--;
			// once password is entered, the chance to enter password is decreased.
			
			if(!input.equals(getPassword())){
				System.out.print("You entered wrong password. ");
				System.out.println("Left chance : " + leftChance);
			}
			else{
				System.out.println("Enter into Manager Mode....\n");
				return true;
			}
		}
		
		//if the else statement in above while statement does not implemented, then the bellow expression gonna be implemented.
		System.out.println("You've exhausted your chances.");
		System.out.println("Going back to the selecting option...");
		return false;
	}

	
	
// Below method is for getting informations from Info class. (static)

// Set a menu based on name, price that entered from manager.
	public static void setMenu(String name, int price) {
		int index = Info.getCount(); // If the current number of elements in menu arrays is x, the available index is x. 
		Menu coffee = new Menu(name, price);
		Info.menu[index] = coffee;
	}
	
	// show each menu and each price.
	public static void showMenu(){
		Info.showMenu(); // Because showMenu in Info class is also used for customer, it just calls showMenu() method in Info class.
	}
	
	// show each menu and each sales
	public static void showSales(){
		int size = Info.getCount(); // this size is different from size in Info class.
		if(size==0) {
			System.out.println("\nMenu list is empty!\n");
			return;
		}
		System.out.println();
		for(int i=0;i<size;i++){
			System.out.printf("%2d. %-15s %d won\n", i+1, Info.menu[i].getName(), Info.menu[i].getSales());
		}
		System.out.println();
	}
	
	public static void initMenu() {
		Info.initMenu();
	}
	
	public static void showStatistics(){ // show the total customer number and total sales.
		System.out.println("\nThe total customer number is " + Info.getTotalCustomer() + " person(s)");
		System.out.println("The total salses is " + Info.getTotalSales() + " won\n");
	}
	

// below methods are related to control files.
	
	public static void setMenuFromFile() {
		
		System.out.print("\nEnter the file name for initializing menus >> ");
		String fileName = kb.nextLine();
		Scanner inputStream = null;
		
		try {			
			inputStream = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("<Error> opening the file: " + fileName);
			System.out.println("Going back to the selecting option...\n");
			return;
		}
		
		System.out.print("All of data will be initialized. Are you sure? (YES : 1 / NO : 2) >> ");
		int answer = kb.nextInt();
		kb.nextLine();
		
		if(answer!=1) {
			System.out.println("Going back to the selecting option...\n");
			return;
		}
		else Info.initMenu(); // deleting all of the menu data.
		
		String line = inputStream.nextLine();
		
		while(inputStream.hasNextLine() && !Info.isFull()) { // it conducts when file has next line and menu array is not full.
			line = inputStream.nextLine();
			String[] data = line.split("\t");
			String name = data[0];
			int price = Integer.parseInt(data[1]);
			setMenu(name, price);
		}
		inputStream.close();
		
		System.out.println("Done of reading data from " + fileName + "!\n");
		return;
	}
	
	public static void saveAsFile() {
		
		System.out.print("\nEnter the file name for saving data >> ");
		String fileName = kb.nextLine();
		PrintWriter outputStream = null;
		
		try {
			outputStream = new PrintWriter(fileName);
		}
		catch(FileNotFoundException e){
			System.out.println("Error opening the file: " + fileName);
			System.out.println("Going back to the selecting option...\n");
			return;
		}
		
		// Saving data...
		outputStream.println("MenuName\tprice");
		for(int i=0;i<Info.getCount();i++) {
			outputStream.println(Info.menu[i].getName() + "\t" + Info.menu[i].getPrice());
		}
		outputStream.println("\nTotal Customers: " + Info.getTotalCustomer());
		outputStream.println("\nTotal Sales: " + Info.getTotalSales());
		outputStream.close();
		
		System.out.println("Done of saving data to " + fileName + "!\n");
		return;
	}
}
