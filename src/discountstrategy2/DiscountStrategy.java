package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public interface DiscountStrategy {
    public abstract double getDiscountAmount(double qtyPurchased, double price);
}
