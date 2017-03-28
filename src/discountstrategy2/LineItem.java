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

    private final Product findProduct(String productId, ReceiptDataAccessStrategy dataBase) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("ProductId is missing when creating LineItem");
        } else if (dataBase == null) {
            throw new IllegalArgumentException("dataBase is missing when creating LineItem");
        }
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

    public final double calculateSubTotal() {
        double subtotal = product.getPrice() * getQty();
        return subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Missing product for LineItem");
        } else {
            this.product = product;
        }

    }

    public final double getQty() {
        return qty;
    }

    public final void setQty(double qty) {
        if (qty < 1 || qty > 1000) {
            throw new IllegalArgumentException("Quantity needs to be between 1 and 1000");
        } else {
            this.qty = qty;
        }

    }

    public final double getDiscountAmount() {
        double discountAmount = product.getDiscountStrategy().getDiscountAmount(getQty(), product.getPrice());
        return discountAmount;
    }

}
