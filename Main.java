package Invoice_Management;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        Customer[] customers = new Customer[100];
	        int customerCount = 0;
	        Scanner sc = new Scanner(System.in);

	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("1. Add a new customer");
	            System.out.println("2. Display an invoice");
	            System.out.println("3. Display total quantity sold for a product");
	            System.out.println("4. Display paid and unpaid invoice count for a customer");
	            System.out.println("5. Exit");

	            int choice = sc.nextInt();
	            sc.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    customers[customerCount] = new Customer();
	                    customers[customerCount].createInvoice();
	                    printInvoiceHeader();
	                    customers[customerCount].getInvoice();
	                    customers[customerCount].updateCustomerInvoiceCount();
	                    customerCount++;
	                    break;
	                case 2:
	                    System.out.println("Enter Customer ID: ");
	                    int customerId = sc.nextInt();
	                    System.out.println("Enter Invoice ID: ");
	                    int invoiceId = sc.nextInt();
	                    displayInvoice(customers, customerCount, customerId, invoiceId);
	                    break;
	                case 3:
	                    System.out.println("Enter Product ID: ");
	                    int productId = sc.nextInt();
	                    sc.nextLine(); // Consume newline
	                    int totalQuantity = 0;
	                    for (int i = 0; i < customerCount; i++) {
	                        totalQuantity += customers[i].getTotalQuantitySold(productId);
	                    }
	                    System.out.println("Total quantity sold for product ID " + productId + ": " + totalQuantity);
	                    break;
	                case 4:
	                	System.out.println("Enter Customer ID: ");
	                    customerId = sc.nextInt();
	                    sc.nextLine(); // Consume newline
	                    boolean customerFound = false;
	                    for (int i = 0; i < customerCount; i++) {
	                        if (customers[i].customerId == customerId) {
	                            int paidCount = customers[i].getPaidInvoiceCount();
	                            int unpaidCount = customers[i].getUnpaidInvoiceCount();
	                            System.out.println("Customer " + customers[i].customerName + " has " + paidCount + " paid invoices and " + unpaidCount + " unpaid invoices.");
	                            customerFound = true;
	                            break;	                        }
	                    }
	                    if (!customerFound) {
	                        System.out.println("Customer not found.");
	                    }
	                    break;
	                case 5:
	                    System.exit(0);
	            }
	        }
	    }

	    public static void printInvoiceHeader() {
	        System.out.println("   \t\t---------------------Invoice---------------------\t\t\t\t");
	        System.out.println("\t\t\t\t\t" + "ABC STORES" + "\t\t\t\t\t");
	        System.out.println("  Contact No: 9344820759");
	        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        Date date = new Date();
	        Calendar calendar = Calendar.getInstance();
	        String[] days = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	        System.out.println("Date:" + formatter.format(date) + " " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
	    }

	    public static void displayInvoice(Customer[] customers, int customerCount, int customerId, int invoiceId) {
	        for (int i = 0; i < customerCount; i++) {
	            if (customers[i].customerId == customerId) {
	                customers[i].displayInvoice(invoiceId);
	                return;
	            }
	        }
	        System.out.println("Customer or Invoice not found.");
	    }
	}

	
