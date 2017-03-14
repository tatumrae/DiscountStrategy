package discountstrategy2;


public class NoDiscount implements DiscountStrategy {

    public NoDiscount() {
    }
    
    @Override
    public double getDiscountAmount(double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
