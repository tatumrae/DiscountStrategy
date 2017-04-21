package discountstrategy2;

import edu.wctc.trt.date.DateUtilities;

/**
 *
 * @author tatum
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReceiptDataAccessStrategy dataBase = new InMemoryAccessStrategy();
        ReceiptOutputStrategy output = new ConsoleReceiptOutput();
        ReceiptOutputStrategy output2 = new JOptionPaneReceiptOutput();
        DateUtilities dateUtilities = new DateUtilities();
        
        PosTerminal pos = new PosTerminal(dateUtilities);
        
        pos.startSale("200", dataBase);
        pos.addItemToSale("A101", 1, dataBase);
        pos.addItemToSale("B205", 5, dataBase);
        pos.addItemToSale("C222", 3, dataBase);
        pos.endSale(output, output2);
        
        pos.startSale("", dataBase);
        pos.addItemToSale("A101", 4, dataBase);
        pos.addItemToSale("B205", 2, dataBase);
        pos.addItemToSale("C222", 58, dataBase);
        pos.endSale(output, output2);
    }
    
}
