package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class QtyDiscount implements DiscountStrategy{
    private double percentDiscount;
    private double qty;

    public QtyDiscount(double percentDiscount, double qty) {
        setPercentDiscount(percentDiscount);
        setQty(qty);
    }
    
    

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }
    
    
    
    @Override
    public double getDiscountAmount(double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}