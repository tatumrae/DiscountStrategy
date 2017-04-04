package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class Customer {
    
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        setName(name);
        setCustomerId(customerId);
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) throws IllegalArgumentException{
        if (!customerId.equalsIgnoreCase("Not Provided") && customerId.length() != 3) {
            throw new IllegalArgumentException("Customer ID can only be 3 digits");
        }
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Customer name is null or empty");
        } else if (name.length() < 2) {
            throw new IllegalArgumentException("Customer name less than 2 characters");
        } 
        this.name = name;
    }

    
}
