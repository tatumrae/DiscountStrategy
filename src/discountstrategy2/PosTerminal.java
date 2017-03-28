package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PosTerminal {

    private Receipt receipt;
    //private int transactionId = 0;

    public PosTerminal() {
    }

    public final void startSale(String customerId, ReceiptDataAccessStrategy dataBase) {
        if (customerId == null || customerId.isEmpty()) {
            customerId = "";
        } else if (dataBase == null) {
            throw new IllegalArgumentException("DataBase cannot be null when creating a new sale");
        }
        receipt = new Receipt(customerId, dataBase);

    }

    public final void addItemToSale(String productId, double qty, ReceiptDataAccessStrategy dataBase) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("ProductId cannot be null or empty");
        } else if (qty < 0 || qty > 1000) {
            throw new IllegalArgumentException("Quantity must be between 1 and 1000");
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

    public final void endSale(ReceiptOutputStrategy output, ReceiptOutputStrategy output2) {
        if (output == null) {
            throw new IllegalArgumentException("OutputStrategy #1 is missing");
        } else if (output2 == null) {
            throw new IllegalArgumentException("OutputStrategy #2 is missing");
        }
        output.printReceipt(getReceipt());
        output2.printReceipt(getReceipt());
    }
}
