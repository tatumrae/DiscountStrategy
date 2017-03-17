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
        if (productId == null || productId.length() != 4) {
            throw new IllegalArgumentException("Product ID can only be 4 digits");
        }
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        if (productName == null || productName.length() == 0) {
            throw new IllegalArgumentException("Product name is null or empty");
        } else if (productName.length() < 2) {
            throw new IllegalArgumentException("Product name less than 2 characters");
        }
        this.productName = productName;
    }

    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price is less than 0.");
        }
        this.price = price;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discount;
    }

    public final void setDiscountStrategy(DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException("Missing discount type");
        }
        this.discount = discount;
    }
    
    
}
