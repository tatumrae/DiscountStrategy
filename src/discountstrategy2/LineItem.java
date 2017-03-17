package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class LineItem {
    private Product product;
    private double qty;
    //private DecimalFormatter decimalFormatter;

    public LineItem(String productId, double qty, ReceiptDataAccessStrategy dataBase) {
        product = findProduct(productId, dataBase);
        setQty(qty);
    }

    private final Product findProduct(String productId, ReceiptDataAccessStrategy dataBase){
        return dataBase.findProduct(productId);
    }
    
    public final String getLineItemData() {
        //decimalFormatter = new DecimalFormatter();
        String lineItemData = "";
        lineItemData += String.format("%-10s", product.getProductId());
        lineItemData += String.format("%-20s", product.getProductName());
        lineItemData += "$" + String.format("%-10.2f", product.getPrice());
        lineItemData += String.format("%-8.0f", getQty());
        lineItemData += "$" + String.format("%-12.2f", calculateSubTotal());
        lineItemData += "$" + String.format("%-10.2f", getDiscountAmount());
        
        return lineItemData;
    }
    
    public final double calculateSubTotal(){
        double subtotal = product.getPrice() * getQty();
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final double getQty() {
        return qty;
    }

    public final void setQty(double qty) {
        this.qty = qty;
    }
    
    public final double getDiscountAmount() {
        double discountAmount = product.getDiscountStrategy().getDiscountAmount(getQty(), product.getPrice());
        return discountAmount;
    }
    
    
    
}
