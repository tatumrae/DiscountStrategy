package discountstrategy2;


public class NoDiscount implements DiscountStrategy {
    final double NO_DISCOUNT = 0;

    public NoDiscount() {
    }
    
    @Override
    public double getDiscountAmount(double qtyPurchased, double price) {
        if (qtyPurchased < 1 || qtyPurchased > 1000) {
            throw new IllegalArgumentException("Quantity needs to be between 1 and 1000");
        } else if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less than or equal to $0.00");
        }
        return NO_DISCOUNT;
    }

}
