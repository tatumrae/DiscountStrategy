package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class QtyDiscount implements DiscountStrategy{
    private double percentDiscount;
    private double qtyRequiredForDiscount;
    private double qtyPurchased;

    public QtyDiscount(double percentDiscount, double qtyRequiredForDiscount) {
        setPercentDiscount(percentDiscount);
        setQtyRequiredForDiscount(qtyRequiredForDiscount);
    }

    public final double getPercentDiscount() {
        return percentDiscount;
    }

    public final void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public final double getQtyRequiredForDiscount() {
        return qtyRequiredForDiscount;
    }

    public final void setQtyRequiredForDiscount(double qtyRequiredForDiscount) {
        this.qtyRequiredForDiscount = qtyRequiredForDiscount;
    }

    public final double getQtyPurchased() {
        return qtyPurchased;
    }

    public final void setQtyPurchased(double qtyPurchased) {
        this.qtyPurchased = qtyPurchased;
    }

    @Override
    public final double getDiscountAmount(double qtyPurchased, double price) {
        if (qtyPurchased >= getQtyRequiredForDiscount()) {
            return qtyPurchased * price * getPercentDiscount();
        } else {
            return 0;
        }
    }
}