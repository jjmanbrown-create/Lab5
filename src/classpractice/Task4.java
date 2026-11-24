package classpractice;
/*
* File: Task4.java
* Author: Jalen Brown
* Course: CISC230
* Lab: Lab5
* Date: 11/4/2026
* 
*Description:
*Program is an interactive vending machine that allows users to
*view available products, purchase items, check inventory, and
*restock products. Uses Product objects to store information such
*as product names, prices, quantities, and product codes. Uses
*different methods to check product availability, reduce inventory,
*and restock items. Tracks successful purchases and total revenue
*while displaying inventory reports and a final purchase summary.
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class Task4 {
	public static void main(String [] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DecimalFormat format = new DecimalFormat("0.00");
		
		Product product1 = new Product("Bottled Water", 1.50, 5, 101);
		Product product2 = new Product("Potato Chips", 2.25, 4, 102);
		Product product3 = new Product("Chocolate Bar", 1.75, 6, 103);
		Product product4 = new Product("Energy Drink", 3.00, 3, 104);
		int choice = 0;
		int purchases = 0;
		double revenue = 0;
				
		while(choice != 5) {
		
		System.out.println("\nWelcome to Tommie Smart Vending Machine!");
		System.out.println("\n========== TOMMIE SMART VENDING MACHINE ==========");
		System.out.println("1. View Available Products");
		System.out.println("2. Purchase a Product");
		System.out.println("3. View Inventory Report");
		System.out.println("4. Restock a Product");
		System.out.println("5. Exit");
		System.out.println("Enter your choice: ");
		choice = scan.nextInt();
		
		if(choice == 1) {
			System.out.println("========== AVAILABLE PRODUCTS ==========");
			System.out.println(product1.toString());
			System.out.println(product2.toString());
			System.out.println(product3.toString());
			System.out.println(product4.toString());
		} else if(choice == 2) {

			    System.out.println("Enter product code: ");
			    int code = scan.nextInt();

			    Product selectedProduct = null;

			    if (code == product1.getProductCode()) {
			        selectedProduct = product1;
			    } else if (code == product2.getProductCode()) {
			        selectedProduct = product2;
			    } else if (code == product3.getProductCode()) {
			        selectedProduct = product3;
			    } else if (code == product4.getProductCode()) {
			        selectedProduct = product4;
			    }
			    if (selectedProduct == null) {
			        System.out.println("Invalid product code.");

			    } else if (!selectedProduct.isAvailable()) {
			        System.out.println("Product is out of stock.");

			    } else {
			        System.out.println("Selected product: " + selectedProduct.getProductName());
			        System.out.println("Price: $" + format.format(selectedProduct.getPrice()));

			        double totalPayment = 0;
			        double payment;

			        while (totalPayment < selectedProduct.getPrice()) {

			            System.out.println("Insert payment: ");
			            payment = scan.nextDouble();
			            System.out.println("Total inserted: $" + format.format(payment));

			            if (payment > 0) {
			                totalPayment = totalPayment + payment;
			                
			                double change = totalPayment - selectedProduct.getPrice();
			                
			                System.out.println("\nPurchase successful!");
					        System.out.println("Total inserted: $" + format.format(payment));
					        System.out.println("Change returned: $" + format.format(change));
					        System.out.println("Please collect your " + selectedProduct.getProductName());

			            } else {
			                System.out.println("Invalid payment. Please try again.");
			            }	          
			        }

			        selectedProduct.reduceQuantity();

			        purchases++;
			        revenue = revenue + selectedProduct.getPrice();
			    }
			}
			else if (choice == 3) {
			
			    int counter = 1;
			    int totalItems = 0;
			    double inventoryValue = 0;
			    int outOfStock = 0;
			
			    while (counter <= 4) {
			
			        if (counter == 1) {
			            totalItems = totalItems + product1.getQuantity();
			            inventoryValue = inventoryValue + (product1.getPrice() * product1.getQuantity());
			
			            if (!product1.isAvailable()) {
			                outOfStock++;
			            }
			        } else if (counter == 2) {
			            totalItems = totalItems + product2.getQuantity();
			            inventoryValue = inventoryValue + (product2.getPrice() * product2.getQuantity());
			
			            if (!product2.isAvailable()) {
			                outOfStock++;
			            }
			        } else if (counter == 3) {
			            totalItems = totalItems + product3.getQuantity();
			            inventoryValue = inventoryValue + (product3.getPrice() * product3.getQuantity());
			
			            if (!product3.isAvailable()) {
			                outOfStock++;
			            }
			        } else if (counter == 4) {
			            totalItems = totalItems + product4.getQuantity();
			            inventoryValue = inventoryValue + (product4.getPrice() * product4.getQuantity());
			
			            if (!product4.isAvailable()) {
			                outOfStock++;
			            }
			        }
			        counter++;
			    }
			    System.out.println("========== INVENTORY REPORT ==========");
			    System.out.println("Total products available: " + totalItems);
			    System.out.println("Total inventory value: $" + inventoryValue);
			    System.out.println("Total successful purchases: " + purchases);
			    System.out.println("Total revenue collected: $" + revenue);
			    System.out.println("Product types out of stock: " + outOfStock);
			}
			else if (choice == 4) {
			
			    System.out.println("Enter product code to restock: ");
			    int code = scan.nextInt();
			
			    Product restockProduct = null;
			
			    if (code == product1.getProductCode()) {
			        restockProduct = product1;
			
			    } else if (code == product2.getProductCode()) {
			        restockProduct = product2;
			
			    } else if (code == product3.getProductCode()) {
			        restockProduct = product3;
			
			    } else if (code == product4.getProductCode()) {
			        restockProduct = product4;
			    }
			
			    if (restockProduct == null) {
			        System.out.println("Invalid product code.");
			
			    } else {
			
			        System.out.println("How many items would you like to add?");
			        int amount = scan.nextInt();
			
			        if (amount > 0) {
			
			            restockProduct.restock(amount);
			
			            System.out.println("Restocking successful!");
			            System.out.println(restockProduct);
			
			        } else {
			            System.out.println("Invalid restock amount.");
			        }
			    }
			} else if (choice != 5) {

			    System.out.println("Invalid menu selection.");
			}
		}
		System.out.println("========== FINAL SUMMARY ==========");
		System.out.println("Total successful purchases: " + purchases);
		System.out.println("Total revenue collected: $" + revenue);
		System.out.println("Thank you for using Tommie Smart Vending Machine!");
	}
}