package classpractice;

public class Product {

	private String productName;
	private double price;
	private int quantity;
	private int productCode;
	
	public Product(String name, double itemPrice, int itemQuantity, int code){
		productName = name;
		price = itemPrice;
		quantity = itemQuantity;
		productCode = code;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getProductCode() {
		return productCode;
	}
	
	public boolean isAvailable() {
		if (quantity > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void reduceQuantity() {
		if (quantity > 0) {
			quantity--;
		}
		
	}
	
	public void restock(int amount) {
		if(amount > 0 ) {
			quantity = quantity + amount;
		} else {
			System.out.println("Invalid restock amount.");
		}
		
	}
	
	public String toString() {
		return "Code: " + productCode + " | " + productName + 
				" | $" + price + " | Stock: " + quantity;
		
	}
}