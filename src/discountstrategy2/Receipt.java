package discountstrategy2;

import edu.wctc.trt.date.DateUtilities;

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
    private String todaysDateAndCurrentTime;
    private static int transactionId = 0;
    private ReceiptFormatter receiptFormatter;
    private DateUtilities dateUtilities;

    public Receipt(String customerId, ReceiptDataAccessStrategy dataBase, DateUtilities dateUtilities) {
        if (!customerId.isEmpty()) {
            customer = findCustomer(customerId, dataBase);
        } else {
            customer = new Customer("Not Provided", "Not Provided");
        }
        setTodaysDateAndCurrentTime(dateUtilities.getTodaysDateAndCurrentTime());
        lineItems = new LineItem[0];
        transactionId += 1;

    }

    private final Customer findCustomer(String customerId, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (dataBase == null) {
            throw new IllegalArgumentException("dataBase cannot be null");
        } else {
            return dataBase.findCustomer(customerId);
        }

    }

    public final void createLineItem(String productId, double qty, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("productId is null or empty");
        } else if (dataBase == null) {
            throw new IllegalArgumentException("dataBase is null");
        } else if (qty < 0) {
            throw new InvalidQuantityException();
        } else {
            LineItem lineItem = new LineItem(productId, qty, dataBase);
            addToArray(lineItem);
        }

    }

    private final void addToArray(final LineItem item) throws IllegalArgumentException{
        if (item == null) {
            throw new IllegalArgumentException("Item being added to LineItem array is null");
        } else {
            LineItem[] tempItems = new LineItem[lineItems.length + 1];
            System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
            tempItems[lineItems.length] = item;
            lineItems = tempItems;
            tempItems = null;
        }
    }

    @Override
    public final String toString() throws IllegalArgumentException{
        receiptFormatter = new ReceiptFormatter();
        if (this == null) {
            throw new IllegalArgumentException("Receipt cannot be null");
        } else {
            return receiptFormatter.formatText(this, todaysDateAndCurrentTime, netTotal, totalSaved);
        }

    }

    public final int getTransactionId() {
        return transactionId;
    }

    public final void setTransactionId(int transactionId) throws IllegalArgumentException{
        if (transactionId <= 0) {
            throw new IllegalArgumentException("Invalid transactionId");
        }
        this.transactionId = transactionId;
    }

    public final double calcTotalDue(double netTotal, double totalSaved) throws IllegalArgumentException{
        if (netTotal < 0 || totalSaved < 0) {
            throw new IllegalArgumentException("NetTotal or TotalSaved is less than zero");
        } else if (netTotal < totalSaved) {
            throw new IllegalArgumentException("NetTotal must be greater than TotalSaved");
        }
        return netTotal - totalSaved;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) throws IllegalArgumentException{
        if (lineItems.length == 0) {
            throw new IllegalArgumentException("LineItem array is not populated.");
        } else {
            this.lineItems = lineItems;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) throws IllegalArgumentException{
        if (customer == null) {
            throw new IllegalArgumentException("Customer is missing");
        } else {
            this.customer = customer;
        }

    }

    public String getTodaysDateAndCurrentTime() {
        return todaysDateAndCurrentTime;
    }

    public void setTodaysDateAndCurrentTime(String todaysDateAndCurrentTime) {
        this.todaysDateAndCurrentTime = todaysDateAndCurrentTime;
    }
    
    

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) throws IllegalArgumentException{
        if (totalDue < 0) {
            throw new IllegalArgumentException("totalDue cannot be negative number.");
        } else {
            this.totalDue = totalDue;
        }

    }

    public double getTotalSaved() {
        return totalSaved;
    }

    public void setTotalSaved(double totalSaved) throws IllegalArgumentException{
        if (totalSaved < 0) {
            throw new IllegalArgumentException("totalSaved cannot be a negative number.");
        } else {
            this.totalSaved = totalSaved;
        }
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) throws IllegalArgumentException{
        if (netTotal < 0) {
            throw new IllegalArgumentException("netTotal cannot be a negative number.");
        } else {
            this.netTotal = netTotal;
        }

    }

}
