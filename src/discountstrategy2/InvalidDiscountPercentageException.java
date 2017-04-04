package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class InvalidDiscountPercentageException 
        extends IllegalArgumentException{
    
    private final static String MSG = "Discount amount must be between 0 and 100";

    public InvalidDiscountPercentageException() {
        super(MSG);
    }

    public InvalidDiscountPercentageException(String s) {
        super(MSG);
    }

    public InvalidDiscountPercentageException(String message, Throwable cause) {
        super(MSG, cause);
    }

    public InvalidDiscountPercentageException(Throwable cause) {
        super(cause);
    }

}
