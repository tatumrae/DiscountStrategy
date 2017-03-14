package discountstrategy2;

import javax.swing.JOptionPane;


public class JOptionPaneReceiptOutput implements ReceiptOutputStrategy {

    @Override
    public void printReceipt(Receipt receipt) {
        JOptionPane.showMessageDialog(null, receipt);
    }

}
