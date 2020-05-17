
public class Customer {

	// Below method is about buying menus. this method calculate and add for each sales, total sales and total_customer
	// In terms of manager, this method's name could be 'sell'. 'buy' is a name for the customer.
		public static void buy(int index) { 
			Menu target = Info.menu[index];
			System.out.println("You choose " + target.getName() + ". Here you are!");
			target.addSales();
			Info.addTotalSales(target.getSales());
			Info.addTotalCustomer();
		}
}
