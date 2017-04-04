package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class InvalidPriceException 
        extends IllegalArgumentException{
    
    private final static String MSG = "Price cannot be less than or equal to $0.00";

    public InvalidPriceException() {
        super(MSG);
    }

    public InvalidPriceException(String s) {
        super(MSG);
    }

    public InvalidPriceException(String message, Throwable cause) {
        super(MSG, cause);
    }

    public InvalidPriceException(Throwable cause) {
        super(cause);
    }

}
