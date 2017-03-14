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

    private Product findProduct(String productId, ReceiptDataAccessStrategy data){
        return data.findProduct(productId);
    }
    
    public String getLineItemData() {
        String lineItemData = "";
        lineItemData += product.getProductId() + " ";
        lineItemData += product.getProductName() + " ";
        lineItemData += product.getPrice() + " ";
        lineItemData += getQty() + " ";
        lineItemData += calculateSubTotal() + " ";
        lineItemData += getDiscountAmount();
        
        return lineItemData;
    }
    
    public double calculateSubTotal(){
        double subtotal = product.getPrice() * getQty();
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
    
    public double getDiscountAmount() {
        double discountAmount = product.getPrice() * product.getDiscountStrategy().getDiscountAmount(getQty());
        return discountAmount;
    }
    
    
    
}
