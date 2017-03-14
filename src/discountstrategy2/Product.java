package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class Product {
    private String productId;
    private String productName;
    private double price;
    private DiscountStrategy discount;

    public Product(String productId, String productName, double price, DiscountStrategy discount) {
        setProductId(productId);
        setProductName(productName);
        setPrice(price);
        setDiscountStrategy(discount);
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        this.productName = productName;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discount;
    }

    public final void setDiscountStrategy(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    
}
