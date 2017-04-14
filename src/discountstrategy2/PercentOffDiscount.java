package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class PercentOffDiscount implements DiscountStrategy {

    private int qtyPurchased;
    private double percentDiscount;
    private Validator validator = new NumericRangeValidator();

    public PercentOffDiscount(double percentDiscount) throws IllegalArgumentException{
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new InvalidDiscountPercentageException();
        }
        setPercentDiscount(percentDiscount);
    }

    @Override
    public final double getDiscountAmount(double qtyPurchased, double price) throws IllegalArgumentException {
        if (qtyPurchased < 1 || qtyPurchased > 1000) {
            throw new InvalidQuantityException();
        } else if (price <= 0) {
            throw new InvalidPriceException();
        }
        return price * getPercentDiscount() * qtyPurchased;
    }

    public final int getQtyPurchased() {
        return qtyPurchased;
    }

    public final void setQtyPurchased(int qtyPurchased) throws IllegalArgumentException {
//        if (qtyPurchased < 1 || qtyPurchased > 1000) {
//            throw new InvalidPriceException();
//        }
//        this.qtyPurchased = qtyPurchased;
            Object[] objArray = {new Integer(qtyPurchased),new Integer(1), new Integer(1000)};
          if (!validator.isValid(objArray)) {
              throw new InvalidPriceException();
          }
    }

    public final double getPercentDiscount() {
        return percentDiscount;
    }

    public final void setPercentDiscount(double percentDiscount) throws IllegalArgumentException {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new InvalidDiscountPercentageException();
        }
        this.percentDiscount = percentDiscount;
    }
}
