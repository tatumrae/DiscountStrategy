package discountstrategy2;

import javax.swing.JOptionPane;

public class JOptionPaneReceiptOutput implements ReceiptOutputStrategy {

    public JOptionPaneReceiptOutput() {
    }

    @Override
    public void printReceipt(Receipt receipt) throws IllegalArgumentException{
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt cannot be null when using JOptionPane");
        } else {
            JOptionPane.showMessageDialog(null, receipt);
        }
    }

}
