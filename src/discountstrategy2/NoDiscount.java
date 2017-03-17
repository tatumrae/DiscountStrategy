package discountstrategy2;


public class NoDiscount implements DiscountStrategy {
    final double NO_DISCOUNT = 0;

    public NoDiscount() {
    }
    
    @Override
    public double getDiscountAmount(double qtyPurchased, double price) {
        return NO_DISCOUNT;
    }

}
