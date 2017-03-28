package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PercentOffDiscount implements DiscountStrategy {

    private int qtyPurchased;
    private double percentDiscount;

    public PercentOffDiscount(double percentDiscount) {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Discount Percent must be between 0 and 100");
        }
        setPercentDiscount(percentDiscount);
    }

    @Override
    public final double getDiscountAmount(double qtyPurchased, double price) {
        if (qtyPurchased < 1 || qtyPurchased > 1000) {
            throw new IllegalArgumentException("Quantity needs to be between 1 and 1000");
        } else if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less than or equal to $0.00");
        }
        return price * getPercentDiscount() * qtyPurchased;
    }

    public final int getQtyPurchased() {
        return qtyPurchased;
    }

    public final void setQtyPurchased(int qtyPurchased) {
        if (qtyPurchased < 0) {
            throw new IllegalArgumentException("Invalid qtyPurchased amount");
        }
        this.qtyPurchased = qtyPurchased;
    }

    public final double getPercentDiscount() {
        return percentDiscount;
    }

    public final void setPercentDiscount(double percentDiscount) {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Disount amount must be between 0 and 100");
        }
        this.percentDiscount = percentDiscount;
    }
}
