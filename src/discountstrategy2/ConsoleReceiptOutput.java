package discountstrategy2;


public class ConsoleReceiptOutput implements ReceiptOutputStrategy {

    @Override
    public void printReceipt(Receipt receipt) {
        System.out.println(receipt);
    }

}
