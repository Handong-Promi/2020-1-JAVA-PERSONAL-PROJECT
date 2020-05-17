import java.util.Scanner;

public class Cafe{

	static Scanner kb = new Scanner(System.in);

	//Password for entering administer mode
 	private static String admin_PW = "Handong Promi";

	//Composing the menus and price and sales of coffees.
	private static String[] menu = {"Espresso", "Americano", "Cafelatte", "Affogato"};
	private static int[] price = {3000, 3500, 4000, 5000};
	private static int[] each_sales = {0,0,0,0};
	private static int size = menu.length;

	//set the total sales and total customer number
	private static int total_customer = 0;
	private static int total_sales = 0;

	public static void main(String[] args){

		int option;

		System.out.println("\nWelecome to the Promi's Cafe!");

		while(true){

			//There is two mode here : administer and Customer
			System.out.print("\nSelect the option! (1.administer 2.Customer 0.Quit) >> ");
			option = kb.nextInt();
			kb.nextLine(); //for getting rid of '\n'
			System.out.println();

			//If the entered value is invalid, go back the first part of above while statement.
			if(option!=1&&option!=2&&option!=0){
				System.out.println("You entered invalid option. Try again!\n");
				continue;
			}

			switch(option){

				case 1:
					administer(); // Checking all about menus
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

	//Bellow Methods are for administer Mode
	public static void administer(){

		//first, ask the password to the person trying to enter the mode.
		if(!pw_check()){
			return;
			//if entered password is uncorrect over 5 times, go back to menu
		}

		while(true){

			int option;

			//There are 5 options for admistration.
			System.out.print("1.Menu list 2.Each sales 3.Total customer 4.Total sales 0.Quit >> ");
			option = kb.nextInt();

			switch(option){
				case 1:
					get_menu(); break; //show each menu and each price
				case 2:
					get_each_sales(); break; // show each menu and each sales
				case 3:
					get_total_customer(); break; // show total customer number
				case 4:
					get_total_sales(); break; // show total sales
				case 0:
					return;
				default:
					System.out.println("You entered invalid option. Try again!\n");
			}
		}
	}

	private static Boolean pw_check(){

		String pw;
		int pw_chance = 5;

		while(pw_chance>0){

			System.out.print("Enter the password for administer. > ");
			pw = kb.nextLine();
			pw_chance--;
			// once password is entered, the chance to enter password is decreased.

			if(!pw.equals(admin_PW)){
				System.out.print("You entered wrong password. ");
				System.out.println("Left chance : " + pw_chance);
			}
			else{
				System.out.println("Enter into administer Mode....");
				return true;
			}
		}

		//if the else statement in above while statement does not implemented, then the bellow expression gonna be implemented.
		System.out.println("You've exhausted your chances.");
		System.out.println("Going back to the selecting option...");
		return false;
	}

	// show each menu and each price.
	private static void get_menu(){
		for(int i=0;i<size;i++){
			System.out.println(i+1 + ". " + menu[i] + "\t" + price[i] + " won");
		}
		return;
	}
	// show each menu and each sales
	private static void get_each_sales(){
		for(int i=0;i<size;i++){
			System.out.println(i+1 + ". " + menu[i] + "\t" + each_sales[i] + " won");
		}
		return;
	}
	// show the total customer number;
	private static void get_total_customer(){
		System.out.println("The total customer number is " + total_customer + " person(s)");
		return;
	}
	// show the total sales.
	private static void get_total_sales(){
		System.out.println("The total salses is " + total_sales + " won");
		return;
	}

	//Bellow methods are for Customer mode.
	public static void Customer(){

		int menu;

		get_menu(); // using get_menu that used in administer mode.
		System.out.print("Select the menu >> "); menu = kb.nextInt();

		switch(menu){
			case 1:
				sell_Espresso(); // Customer choose Espresso.
				break;
			case 2:
				sell_Americano(); // Customer choose Americano.
				break;
			case 3:
				sell_Cafelatte(); // Customer chosse Cafelatte.
				break;
			case 4:
				sell_Affogato(); // Customer choose Affogato.
				break;
			default:
				System.out.println("You entered invalid menu. Going back to the option...");
				break;
		}
		return;
	}

	//Below four methods are about selling menus. Each method calculate and add for each sales, total sales and total_customer
	private static void sell_Espresso(){
		System.out.println("You choose Espresso. Here you are!");
		each_sales[0] += price[0];
		total_sales += price[0];
		total_customer++;
		return;
	}
	private static void sell_Americano(){
		System.out.println("You choose Americano. Here you are!");
		each_sales[1] += price[1];
		total_sales += price[1];
		total_customer++;
		return;
	}
	private static void sell_Cafelatte(){
		System.out.println("You choose Cafelatte. Here you are!");
		each_sales[2] += price[2];
		total_sales += price[2];
		total_customer++;
		return;
	}
	private static void sell_Affogato(){
		System.out.println("You choose Affogato. Here you are!");
		each_sales[3] += price[3];
		total_sales += price[3];
		total_customer++;
		return;
	}
}
