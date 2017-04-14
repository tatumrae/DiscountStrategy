package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class NumericRangeValidator implements Validator {

    /**
     * 
     * @param inputItems - first item is input, second is low range, third is high range
     * @return 
     */
    @Override
    public boolean isValid(Object[] inputItems) {
        long input = (Long)inputItems[0];
        long min = (Long)inputItems[1];
        long max = (Long)inputItems[2];
        if(input < min || input > max) {
            return false;
        } else {
            return true;
        }
    }

}
