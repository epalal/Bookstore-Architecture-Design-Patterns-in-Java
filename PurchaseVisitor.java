package progetto.utils.classes;

import java.text.DecimalFormat;
import java.util.Iterator;

import progetto.main.classes.*;

public class PurchaseVisitor implements BookVisitor {

	private final Purchase receipt;
	private final ShopWindow shopWindow;

	public PurchaseVisitor(ShopWindow shopWindow,Purchase receipt) {
		this.receipt = receipt;
		this.shopWindow = shopWindow;
	}

	@Override
	public void visitSingleBook(SingleBook item) {
		receipt.addDown("	" + item.getName() + " " + shopWindow.finalPrice(item) + "£");
	}

	@Override
	public void visitBookCollection(BookCollection books) {
		Iterator<Item> bookIteration = books.iterator();
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		receipt.addDown(books.getName() + " " + decimalFormat.format(shopWindow.finalPrice(books)) + "£");
		while (bookIteration.hasNext()) {
			bookIteration.next().accept(this);
			receipt.addDown("					-10%");
		}
		receipt.addDown("-------------------------");
	}
}
