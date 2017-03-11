package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class Receipt {
    private LineItem[] lineItems;
    private Customer customer;
    private ReceiptDataAccessStrategy data;

    public Receipt(String customerId, ReceiptDataAccessStrategy data) {
        customer = findCustomer(customerId, data);
    }
    
    private final Customer findCustomer(String customerId, ReceiptDataAccessStrategy data) {
        return data.findCustomer(customerId, data);
    }

    public final void createLineItem(String productId, double qty) {
        LineItem lineItem = new LineItem(productId, qty, data);
        // add lineItem to new lineItems[]
    }
}
