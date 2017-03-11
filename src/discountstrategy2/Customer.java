package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class Customer {
    
    // only utilizing customerId at this time
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    
}
