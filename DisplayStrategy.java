package progetto.utils.classes;

import java.util.ArrayList;
import progetto.main.classes.SingleBook;

public interface DisplayStrategy {
	ArrayList<SingleBook> pickBooks(ArrayList<SingleBook> books);
	double newPrice(double price);
}
