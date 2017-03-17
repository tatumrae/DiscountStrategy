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
        }
//        
//        transactionId += 1;
        receipt = new Receipt(customerId, dataBase);

    }

    public final void addItemToSale(String productId, double qty, ReceiptDataAccessStrategy dataBase) {
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
        output.printReceipt(getReceipt());
        output2.printReceipt(getReceipt());
    }
}
