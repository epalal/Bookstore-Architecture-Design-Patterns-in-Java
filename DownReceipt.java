package progetto.utils.classes;

public class DownReceipt extends ReceiptDecorator {

	private final String downText;

	public DownReceipt(ReceiptMaker finalReceipt, String down) {
		super(finalReceipt);
		this.downText = down;
	}

	@Override
	public void print(Purchase receipt) {
		receipt.addDown(downText);
		super.print(receipt);
	}

}
