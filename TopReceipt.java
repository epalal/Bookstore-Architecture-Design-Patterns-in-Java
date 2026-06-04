package progetto.utils.classes;

public class TopReceipt extends ReceiptDecorator {

	private final String topText;

	public TopReceipt(ReceiptMaker finalReceipt, String top) {
		super(finalReceipt);
		this.topText = top;
	}

	@Override
	public void print(Purchase receipt) {
		receipt.addTop(topText);
		super.print(receipt);
	}
}
