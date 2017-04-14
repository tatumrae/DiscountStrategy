package discountstrategy2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tatum
 */
public class ProductTest {
    
    private Product instance;
    
    public ProductTest() {
    }
    
    @Before
    public void setUp() {
        instance = new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(0.15,5));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setProductId method, of class Product.
     */
    @Test
    public void testSetProductId() {
        //
    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        //
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice() {
        //
    }

    /**
     * Test of setDiscountStrategy method, of class Product.
     */
    @Test
    public void testSetDiscountStrategy() {
        //
    }
    
}
