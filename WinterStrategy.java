package progetto.utils.classes;

import java.util.ArrayList;
import progetto.main.classes.SingleBook;
import progetto.utils.classes.DisplayStrategy;

public class WinterStrategy implements DisplayStrategy {

	public ArrayList<SingleBook> pickBooks(ArrayList<SingleBook> books) {
		ArrayList<SingleBook> selectedBooks = new ArrayList<>();
		for (SingleBook book : books) {
			if (book.getGenre().equals("Romance") || book.getGenre().equals("ScienceFiction")) {
				selectedBooks.add(book);
			}
		}
		return selectedBooks;
	}
	
	public double newPrice(double price) {
		return price;
	}
}