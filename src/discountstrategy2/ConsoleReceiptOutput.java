package discountstrategy2;


public class ConsoleReceiptOutput implements ReceiptOutputStrategy {

    public ConsoleReceiptOutput() {
    }

    @Override
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }

}
