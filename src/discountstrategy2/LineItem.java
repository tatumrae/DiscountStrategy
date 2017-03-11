package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class LineItem {
    private Product product;
    private double qty;

    public LineItem(String productId, double qty, ReceiptDataAccessStrategy data) {
        product = findProduct(productId, data);
        this.qty = qty;
    }

    private Product findProduct(String prodId, ReceiptDataAccessStrategy data){
        return data.findProduct(prodId, data);
    }
    
    
}
