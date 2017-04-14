package discountstrategy2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tatum
 */
public class QtyDiscountTest {

    private QtyDiscount instance;

    public QtyDiscountTest() {
    }

    @Before
    public void setUp() {
        instance = new QtyDiscount(0.15, 5);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setPercentDiscount method, of class QtyDiscount.
     */

    @Test(expected = IllegalArgumentException.class)
    public void setPercentDiscountShouldThrowIaeIfNumberBelowRange() {
        instance.setPercentDiscount(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setPercentDiscountShouldThrowIaeIfNumberAboveRange() {
        instance.setPercentDiscount(101);
    }
    
    @Test
    public void setPercentDiscountShouldAllow0To100() {
        for (int i = 0; i < 101; i++) {
            try {
                instance.setPercentDiscount(i);

            } catch (IllegalArgumentException iae) {
                fail("Arguments from 0 to 100 inclusive should be legal, "
                        + "but fails with IllegalArgumentException.");
            }
        }
    }

    /**
     * Test of setQtyRequiredForDiscount method, of class QtyDiscount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void setQtyRequiredForDiscountShouldNotBeLessThanZero() {
        instance.setQtyRequiredForDiscount(-1);
    }
    
    @Test
    public void setQtyRequiredShouldBeGreaterThanZero() {
      try{
        instance.setQtyRequiredForDiscount(2);
      } catch(IllegalArgumentException e) {
          fail("value should have been allowed");
      }
        
    }

    /**
     * Test of setQtyPurchased method, of class QtyDiscount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void setQtyPurchasedShouldNotBeLessThanZero() {
        instance.setQtyPurchased(-1);
    }
    
    @Test 
    public void setQtyPurchasedShouldBeGreaterThanZero() {
        int[] goodValues = {1, 5, 16, 34, 10000};
        for (int i : goodValues) {
            try {
            instance.setQtyPurchased(1);
            } catch (IllegalArgumentException iae) {
                fail ("Good value was not accepted");
            }
        }
    }
    
    @Test
    public void getQtyDiscountAmountReturnZeroIfMinimumNotMet() {
        double expected = 0;
        double results = instance.getDiscountAmount(4, 10);
        assertEquals(expected, results, .001);
    }
    
    @Test
    public void getQtyDiscountAmountReturnDiscountAmountIfMinimumIsMet() {
        // qtyPurchased * price * getPercentDiscount();
        double expected = 5 * 10 * instance.getPercentDiscount();
        // 7.5
        double results = instance.getDiscountAmount(5, 10);
        assertEquals(expected, results, .001);
    }

}
