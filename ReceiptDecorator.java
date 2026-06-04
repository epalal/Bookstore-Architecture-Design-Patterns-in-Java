package progetto.utils.classes;

public abstract class ReceiptDecorator implements ReceiptMaker {

	private ReceiptMaker finalReceipt;

	public ReceiptDecorator(ReceiptMaker finalReceipt) {
		this.finalReceipt = finalReceipt;
	}

	@Override
	public void print(Purchase receipt) {
		finalReceipt.print(receipt);
	}
}
