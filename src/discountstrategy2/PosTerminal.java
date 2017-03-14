package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PosTerminal {
    private Receipt receipt;

    public PosTerminal() {
    }
    
    public final void startSale(String customerId, ReceiptDataAccessStrategy data) {
        receipt = new Receipt(customerId, data);
    }
    
    public final void addItemToSale(String productId, double qty, ReceiptDataAccessStrategy data) {
        receipt.createLineItem(productId, qty, data);
    }
    
    public final void endSale(ReceiptOutputStrategy output) {
        // output the receipt
    }
}
