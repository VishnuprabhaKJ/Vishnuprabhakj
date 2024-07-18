package Invoice_Management;
import java.util.Random;
import java.util.Scanner;


public class Invoice {
	 int invoiceId;
	    Product[] products = new Product[100];
	    int productCount = 0;
	    boolean isPaid;
	    

	    Scanner sc = new Scanner(System.in);

	    public Invoice() {
	        invoiceId = generateFiveDigitRandomNumber();
	    }

	    public void addProducts() {
	        int i = 0;
	        do {
	            products[i] = new Product();
	            System.out.println("Want to add more items? (y or n): ");
	            char shouldAddMore = sc.next().charAt(0);
	            sc.nextLine(); // Consume newline
	            i++;
	            productCount++;
	            if (shouldAddMore != 'y' && shouldAddMore != 'Y') {
	                break;
	            }
	        } while (true);
	        System.out.println("Is the invoice paid? (true/false): ");
	        isPaid = sc.nextBoolean();
	        sc.nextLine(); 
	    }

	    public static int generateFiveDigitRandomNumber() {
	        Random random = new Random();
	        return random.nextInt(90000) + 10000;
	    }

	    public void displayInvoice() {
	        System.out.println("Invoice ID: " + invoiceId);
	        System.out.println("--------------------------------------------------------------");
	        System.out.println("Product ID\tName\tQuantity\tUnit\tRate\tPrice");
	        System.out.println("--------------------------------------------------------------");
	        double total = 0;
	        for (int i = 0; i < productCount; i++) {
	            System.out.println(products[i].ID + "\t\t" + products[i].name + "\t" + products[i].quantity + "\t\t" + products[i].unit + "\t" + products[i].rate + "\t" + products[i].price);
	            total += products[i].price;
	        }
	        System.out.println("--------------------------------------------------------------");
	        System.out.println("\t\t\t\t\t\t Total: " + total);
	        System.out.println("\t\t\t\t\t\tDiscount: 10%");
	        System.out.println("\t\t\t\t\t Invoice Total: "+(total-(total*0.1)));
	        
	        System.out.println("\t\t\t\t\t Status: "+ (isPaid ? "Paid" : "Unpaid"));
	        
	    }
	    
	   
	    
	    public int getTotalQuantitySold(int productId) {
	        int totalQuantity = 0;
	        for (int i = 0; i < productCount; i++) {
	            if (products[i].ID == productId) {
	                totalQuantity += products[i].quantity;
	            }
	        }
	        return totalQuantity;
	    }
	   
	}

