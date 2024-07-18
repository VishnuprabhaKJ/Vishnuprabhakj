package Invoice_Management;
import java.util.Scanner;


public class Product {
	 int ID, quantity;
	    String name, unit;
	    double rate, price;

	    Scanner sc = new Scanner(System.in);

	    public Product() {
	        System.out.println("Product ID: ");
	        ID = sc.nextInt();
	        sc.nextLine();  // Consume newline
	        System.out.println("Name: ");
	        name = sc.nextLine();
	        System.out.println("Quantity: ");
	        quantity = sc.nextInt();
	        sc.nextLine();  // Consume newline
	        System.out.println("Unit: ");
	        unit = sc.nextLine();
	        System.out.println("Rate: ");
	        rate = sc.nextDouble();
	        price = rate * quantity;
	        System.out.println("Price: " + price);
	    }
}
