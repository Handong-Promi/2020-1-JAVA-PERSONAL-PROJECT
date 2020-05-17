
public class Info {
	
	private static final int size = 10; // Maximum kinds of menu is 10. Later, I will improve the flexibility of the size.
	public static Menu[] menu = new Menu[size]; // initial value : null
	
	private static int total_customer = 0;
	private static int total_sales = 0;
	
// methods for getting and adding total_customer / total_sales;
	public static int getTotalCustomer() {
		return total_customer;
	}
	public static int getTotalSales() {
		return total_sales;
	}
	public static void addTotalCustomer() {
		total_customer++;
	}
	public static void addTotalSales(int sale) {
		total_sales += sale;
	}

	public static void setDefaultMenu() {
		
		String[] defaultMenu = {"Espresso", "Americano", "Cafe Latte", "Affogato"};
		int[] price = {3000, 3500, 4000, 5000};
		
		for(int i=0; i<4 && !isFull(); i++){ // fulfilling until the size of menu arrays being 4.
			Manager.setMenu(defaultMenu[i], price[i]);
		}
		
	}

// Count how many valid elements(not null) in menu array.
	public static int getCount() {
		int count = 0; 
		// after while loop, the count's maximum is 10. 
		// that is, if the count == size, it doesn't check second expression so that avoiding program terminated by memory error.
		while(count < size && menu[count] != null) {
			count++;
		}
		return count; // this is the number of elements in menu arrays. not index. Be careful.
	}
	
// Check the menu arrays is full or not.
	public static Boolean isFull() {
		Boolean flag ;
		if(getCount()==size) flag = true;
		else flag = false;
		return flag;
	}
	
	public static void showMenu() {
		
		int size = getCount(); // this size is different from size in Info class.
		if(size==0) {
			System.out.println("\nMenu list is empty!\n");
			return;
		}
		
		System.out.println();
		for(int i=0;i<size;i++){
			System.out.printf("%2d. %-15s %d won\n", i+1, menu[i].getName(), menu[i].getPrice());
		}
		System.out.println();
	}
	
	public static void initMenu() {
		for(int i=0;i<size;i++) {
			menu[i] = null;
		}
	}
}
