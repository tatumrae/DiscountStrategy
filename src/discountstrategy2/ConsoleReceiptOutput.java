package discountstrategy2;

public class ConsoleReceiptOutput implements ReceiptOutputStrategy {

    public ConsoleReceiptOutput() {
    }

    @Override
    public void printReceipt(Receipt receipt) throws IllegalArgumentException{
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt cannot be null when printing to the console");
        } else {
            System.out.println(receipt);
        }

    }

}
