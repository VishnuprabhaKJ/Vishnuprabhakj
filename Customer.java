package Invoice_Management;
import java.util.Scanner;

public class Customer {
	String customerName;
    public int customerId;
    Invoice[] invoices = new Invoice[100];
    int currentInvoiceCount;

    Scanner sc = new Scanner(System.in);

    public Customer() {
        System.out.println("Enter Customer id: ");
        customerId = sc.nextInt();
        sc.nextLine();  // Consume newline
        System.out.println("Enter Customer Name: ");
        customerName = sc.nextLine();
    }

    public void createInvoice() {
        invoices[currentInvoiceCount] = new Invoice();
        invoices[currentInvoiceCount].addProducts();
        
    }

    public void getInvoice() {
        invoices[currentInvoiceCount].displayInvoice();
    }

    public void updateCustomerInvoiceCount() {
        currentInvoiceCount++;
    }

    public void displayInvoice(int invoiceId) {
        for (int i = 0; i < currentInvoiceCount; i++) {
            if (invoices[i].invoiceId == invoiceId) {
                invoices[i].displayInvoice();
                return;
            }
        }
        System.out.println("Invoice not found.");
    }
    public int getTotalQuantitySold(int productId) {
        int totalQuantity = 0;
        for (int i = 0; i < currentInvoiceCount; i++) {
            totalQuantity += invoices[i].getTotalQuantitySold(productId);
        }
        return totalQuantity;
    }
    
    public int getPaidInvoiceCount() {
        int paidCount = 0;
        for (int i = 0; i < currentInvoiceCount; i++) {
            if (invoices[i].isPaid) {
                paidCount++;
            }
        }
        return paidCount;
    }

    public int getUnpaidInvoiceCount() {
        int unpaidCount = 0;
        for (int i = 0; i < currentInvoiceCount; i++) {
            if (!invoices[i].isPaid) {
                unpaidCount++;
            }
        }
        return unpaidCount;
    }
}
