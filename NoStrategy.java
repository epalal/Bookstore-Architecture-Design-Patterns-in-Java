package progetto.utils.classes;

import java.util.ArrayList;
import progetto.main.classes.SingleBook;
import progetto.utils.classes.DisplayStrategy;

public class NoStrategy implements DisplayStrategy {

	public ArrayList<SingleBook> pickBooks(ArrayList<SingleBook> books) {
		ArrayList<SingleBook> selectedBooks = new ArrayList<>();
		return selectedBooks;
	}

	public double newPrice(double price) {
		return price;
	}
}