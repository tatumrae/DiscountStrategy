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
        ReceiptOutputStrategy receipt = new ConsoleOutput();
        
        PosTerminal pos = new PosTerminal();
        
        pos.startSale("2002486", data);
        pos.addItemToSale("A101", 1);
        pos.endSale(receipt);
    }
    
}
