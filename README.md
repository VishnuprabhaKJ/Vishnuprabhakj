# Invoice Management System

## Table Design

### Customers Table

| Column Name         | Data Type   | Description               |
|---------------------|-------------|---------------------------|
| customerId          | int         | Unique identifier for each customer |
| customerName        | String      | Name of the customer      |
| invoices            | Invoice[]   | Array of invoices associated with the customer |
| currentInvoiceCount | int         | Number of invoices created by the customer |

### Invoices Table

| Column Name    | Data Type   | Description               |
|----------------|-------------|---------------------------|
| invoiceId      | int         | Unique identifier for each invoice |
| products       | Product[]   | Array of products included in the invoice |
| productCount   | int         | Number of products in the invoice |
| isPaid         | boolean     | Status of the invoice (Paid or Unpaid) |

### Products Table

| Column Name    | Data Type   | Description               |
|----------------|-------------|---------------------------|
| ID             | int         | Unique identifier for each product |
| name           | String      | Name of the product       |
| quantity       | int         | Quantity of the product   |
| unit           | String      | Unit of measurement       |
| rate           | double      | Rate per unit of the product |
| price          | double      | Total price for the quantity of the product |

## Code Module Description

### Main Class

**File:** `Main.java`

**Description:** This is the entry point of the application. It provides a menu for users to:
- Add a new customer
- Display an invoice for a customer
- Display the total quantity sold for a customer
- Display the total quantity sold for a product
- Display the count of paid and unpaid invoices for a customer
- Exit the application

### Customer Class

**File:** `Customer.java`

**Description:**
- `Customer()`: Constructor to create a new customer by taking input for `customerId` and `customerName`.
- `createInvoice()`: Method to create a new invoice and add products to it.
- `getInvoice()`: Method to display the most recent invoice for the customer.
- `displayInvoice(int invoiceId)`: Method to display a specific invoice by `invoiceId`.
- `getTotalQuantitySold(int productId)`: Method to get the total quantity sold for a specific product across all invoices of the customer.
- `getPaidInvoiceCount()`: Method to get the count of paid invoices for the customer.
- `getUnpaidInvoiceCount()`: Method to get the count of unpaid invoices for the customer.

### Invoice Class

**File:** `Invoice.java`

**Description:**
- `Invoice()`: Constructor to create a new invoice with a unique `invoiceId`. By default, the invoice is marked as unpaid.
- `addProducts()`: Method to add products to the invoice and prompt the user to specify if the invoice is paid or unpaid.
- `displayInvoice()`:
