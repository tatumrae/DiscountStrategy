package discountstrategy2;

/**
 *
 * @author tatum
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReceiptDataAccessStrategy data = new InMemoryAccessStrategy();
        ReceiptOutputStrategy receipt = new ConsoleReceiptOutput();
        
        PosTerminal pos = new PosTerminal();
        
        pos.startSale("100", data);
        pos.addItemToSale("A101", 1, data);
        pos.endSale(receipt);
    }
    
}
