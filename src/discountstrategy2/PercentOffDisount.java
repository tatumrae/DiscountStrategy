package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PercentOffDisount implements DiscountStrategy{
    private double percentDiscount;

    public PercentOffDisount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    @Override
    public final double getDiscountAmount(double price) {
        return price * percentDiscount;
    }

}
