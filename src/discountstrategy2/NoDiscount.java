package discountstrategy2;


public class NoDiscount implements DiscountStrategy {
    final double NO_DISCOUNT = 0;

    public NoDiscount() {
    }
    
    @Override
    public double getDiscountAmount(double qtyPurchased, double price) throws IllegalArgumentException{
        if (qtyPurchased < 1 || qtyPurchased > 1000) {
            throw new InvalidQuantityException();
        } else if (price <= 0) {
            throw new InvalidPriceException();
        }
        return NO_DISCOUNT;
    }

}
