package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PercentOffDiscount implements DiscountStrategy {

    private int qtyPurchased;
    private double percentDiscount;

    public PercentOffDiscount(double percentDiscount) {
        setPercentDiscount(percentDiscount);
    }

    @Override
    public final double getDiscountAmount(double qtyPurchased, double price) {
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
        if (percentDiscount < 0) {
            throw new IllegalArgumentException("Invalid percentDiscount amount");
        }
        this.percentDiscount = percentDiscount;
    }
}
