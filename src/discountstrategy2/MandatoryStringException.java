package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class MandatoryStringException 
        extends IllegalArgumentException{
    
    private final static String MSG = "Method argument is mandatory";

    public MandatoryStringException() {
        super(MSG);
    }

    public MandatoryStringException(String s) {
        super(MSG);
    }

    public MandatoryStringException(String message, Throwable cause) {
        super(MSG, cause);
    }

    public MandatoryStringException(Throwable cause) {
        super(cause);
    }

}
