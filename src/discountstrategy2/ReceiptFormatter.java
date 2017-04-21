package discountstrategy2;

/**
 *
 * @author Tatum Thomas
 */
public class ReceiptFormatter {

    public ReceiptFormatter() {

    }

    public String formatText(Receipt receipt, String dateAndTime, double netTotal, double totalSaved) {
        String data = "";
        data += "Date: " + receipt.getTodaysDateAndCurrentTime() + "\n";
        data += "Customer Name: " + receipt.getCustomer().getName() + "\n";
        data += "Customer ID: " + receipt.getCustomer().getCustomerId() + "\n";
        data += "Transaction No: " + String.format("%04d", receipt.getTransactionId()) + "\n\n";
        data += "Item No   Item                Price      Qty     Subtotal     Discount\n";
        data += "--------------------------------------------------------------------------\n";
        for (LineItem item : receipt.getLineItems()) {
            data += item.getLineItemData() + "\n";
            netTotal += item.getProduct().getPrice() * item.getQty();
            totalSaved += item.getDiscountAmount();

        }
        data += "\n";
        data += "--------------------------------------------------------------------------\n";
        data += String.format("%79s", ("Net Total: $" + String.format("%-12.2f", netTotal))) + "\n";
        data += String.format("%79s", ("Total Saved: $" + String.format("%-12.2f", totalSaved))) + "\n";
        data += String.format("%79s", ("Total Due: $" + String.format("%-12.2f", receipt.calcTotalDue(netTotal, totalSaved))));
        return data;
    }

}
