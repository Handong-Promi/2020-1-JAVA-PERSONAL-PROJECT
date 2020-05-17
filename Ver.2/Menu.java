
public class Menu { // It could be Americano, Cafelatte, ... 
	
	//Composing the menus and price and sales of coffees. If 
	private String name;
	private int price;
	private int sales;
	
	Menu(String name, int price){ // Manager should construct through this constructor, for menu object. 
		this.name = name;
		this.price = price;
		this.sales = 0;
	}

	// Getter and Setter for name, price and sales(only getter)
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return this.price;
	}
	public int getSales() {
		return sales;
	}
	public void addSales() {
		this.sales += price;
	}
	
}
