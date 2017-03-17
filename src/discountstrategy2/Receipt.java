package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class Receipt {
    private LineItem[] lineItems;
    private Customer customer;
    private ReceiptDataAccessStrategy dataBase;
    private double totalDue = 0;
    private double totalSaved = 0;
    private double netTotal = 0;
    private static int transactionId = 0;
    private ReceiptFormatter receiptFormatter;

    public Receipt(String customerId, ReceiptDataAccessStrategy dataBase) {
        if (!customerId.isEmpty()) {
            customer = findCustomer(customerId, dataBase);
        } else {
            customer = new Customer("Not Provided", "Not Provided");
        }
        lineItems = new LineItem[0];
        transactionId += 1;
        
    }
    
    private final Customer findCustomer(String customerId, ReceiptDataAccessStrategy dataBase) {
        return dataBase.findCustomer(customerId);
    }

    public final void createLineItem(String productId, double qty, ReceiptDataAccessStrategy dataBase) {
        if (productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("productId is null or empty");
        } else if (qty < 0) {
            throw new IllegalArgumentException("qty cannot be a negative number");
        } else if (dataBase == null) {
            throw new IllegalArgumentException("dataBase is null");
        }
        LineItem lineItem = new LineItem(productId, qty, dataBase);
        addToArray(lineItem);
    }
    
    private final void addToArray(final LineItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Item being added to LineItem is null");
        }
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
        tempItems = null;
    }

    @Override
    public final String toString() {
        receiptFormatter = new ReceiptFormatter();
        return receiptFormatter.formatText(this, netTotal, totalSaved);
    }

    public final int getTransactionId() {
        return transactionId;
    }

    public final void setTransactionId(int transactionId) {
        if (transactionId <= 0) {
            throw new IllegalArgumentException("Invalid transactionId");
        }
        this.transactionId = transactionId;
    }
    
    public final double calcTotalDue (double netTotal, double totalSaved) {
        if (netTotal < 0 || totalSaved < 0) {
            throw new IllegalArgumentException("NetTotal or TotalSaved is less than zero");
        } else if (netTotal < totalSaved) {
            throw new IllegalArgumentException("NetTotal must be greater than TotalSaved");
        }
        return netTotal-totalSaved;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        if (lineItems.length == 0) {
            throw new IllegalArgumentException("LineItem array is not populated.");
        }
        this.lineItems = lineItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is missing");
        }
        this.customer = customer;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        if (totalDue < 0) {
            throw new IllegalArgumentException("totalDue cannot be negative number.");
        }
        this.totalDue = totalDue;
    }

    public double getTotalSaved() {
        return totalSaved;
    }

    public void setTotalSaved(double totalSaved) {
        if (totalSaved < 0) {
            throw new IllegalArgumentException("totalSaved cannot be a negative number.");
        }
        this.totalSaved = totalSaved;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        if (netTotal < 0) {
            throw new IllegalArgumentException("netTotal cannot be a negative number.");
        }
        this.netTotal = netTotal;
    }
    
    
}
