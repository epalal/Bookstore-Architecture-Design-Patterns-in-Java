package progetto.utils.classes;

import java.util.ArrayList;
import progetto.main.classes.SingleBook;
import progetto.utils.classes.DisplayStrategy;

public class SummerStrategy implements DisplayStrategy {
	private double discount;

	public SummerStrategy() {
		this.discount = 0.75;
	}

	public ArrayList<SingleBook> pickBooks(ArrayList<SingleBook> books) {
		ArrayList<SingleBook> selectedBooks = new ArrayList<>();
		for (SingleBook book : books) {
			if (book.getGenre().equals("Fiction") || book.getGenre().equals("Fantasy")) {
				selectedBooks.add(book);
				book.setPrice(book.getPrice() * discount);
			}
		}
		return selectedBooks;
	}

	@Override
	public double newPrice(double price) {
		return price;
	}
}