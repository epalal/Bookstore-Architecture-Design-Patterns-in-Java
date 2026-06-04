package progetto.utils.classes;

import java.text.DecimalFormat;

import progetto.main.classes.*;

public class SimplePurchaseVisitor implements BookVisitor {
	private final ShopWindow shopWindow;
	private final Purchase receipt;

	public SimplePurchaseVisitor(ShopWindow shopWindow,Purchase receipt) {
		this.receipt = receipt;
		this.shopWindow = shopWindow;
	}

	@Override
	public void visitSingleBook(SingleBook book) {
		visit(book);
	}

	@Override
	public void visitBookCollection(BookCollection books) {
		visit(books);
	}
	
	public void visit(Item item) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		receipt.addDown(item.getName() 
				+ " " 
				+ decimalFormat.format(shopWindow.finalPrice(item)) 
				+ "£");
		
	}
}