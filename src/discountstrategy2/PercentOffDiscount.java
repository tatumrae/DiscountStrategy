package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PercentOffDiscount implements DiscountStrategy{
    private double percentDiscount;

    public PercentOffDiscount(double percentDiscount) {
        setDiscountAmount(percentDiscount);
    }

    @Override
    public final double getDiscountAmount(double price) {
        return price * percentDiscount;
    }
    public void setDiscountAmount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }
}
