package discountstrategy2;

import edu.wctc.trt.date.DateUtilities;

/**
 *
 * @author Tatum Thomas
 */
public class PosTerminal {

    private Receipt receipt;
    private DateUtilities dateUtilities;
    //private int transactionId = 0;

    public PosTerminal(DateUtilities dateUtilities) {
        setDateUtilities(dateUtilities);
    }

    public final void startSale(String customerId, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (customerId == null || customerId.isEmpty()) {
            customerId = "";
        } else if (dataBase == null) {
            throw new IllegalArgumentException("DataBase cannot be null when creating a new sale");
        }
        receipt = new Receipt(customerId, dataBase, dateUtilities);

    }

    public final void addItemToSale(String productId, double qty, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("ProductId cannot be null or empty");
        } else if (qty < 0 || qty > 1000) {
            throw new InvalidQuantityException();
        } else if (dataBase == null) {
            throw new IllegalArgumentException("DataBase cannot be null when creating a new sale");
        }
        receipt.createLineItem(productId, qty, dataBase);
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt object is missing");
        }
        this.receipt = receipt;
    }

    public DateUtilities getDateUtilities() {
        return dateUtilities;
    }

    public void setDateUtilities(DateUtilities dateUtilities) throws IllegalArgumentException {
        if (dateUtilities == null) {
            throw new IllegalArgumentException("dateUtilities cannot be null");
        }
        this.dateUtilities = dateUtilities;
    }
    
    

    public final void endSale(ReceiptOutputStrategy output, ReceiptOutputStrategy output2) throws IllegalArgumentException{
        if (output == null) {
            throw new IllegalArgumentException("OutputStrategy #1 is missing");
        } else if (output2 == null) {
            throw new IllegalArgumentException("OutputStrategy #2 is missing");
        }
        output.printReceipt(getReceipt());
        output2.printReceipt(getReceipt());
    }
}
