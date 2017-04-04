package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class InvalidQuantityException 
        extends IllegalArgumentException{
    
    private final static String MSG = "Quantity needs to be between 1 and 1000";

    public InvalidQuantityException() {
        super(MSG);
    }

    public InvalidQuantityException(String s) {
        super(MSG);
    }

    public InvalidQuantityException(String message, Throwable cause) {
        super(MSG, cause);
    }

    public InvalidQuantityException(Throwable cause) {
        super(cause);
    }

}
