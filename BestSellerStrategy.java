package progetto.utils.classes;

import java.util.ArrayList;
import progetto.main.classes.SingleBook;

public class BestSellerStrategy implements DisplayStrategy {
    public ArrayList<SingleBook> pickBooks(ArrayList<SingleBook> books) {
        ArrayList<SingleBook> selectedBooks = new ArrayList<>();
        int counter = 0;
        for (SingleBook book : books) {
            if (book.getGenre().equals("Horror") || book.getGenre().equals("Mystery")) {
            	book.setBestSeller(counter + 1);
            	book.setPrice(book.getPrice() * 0.9);
                selectedBooks.add(book);
                counter++;
			}
        }
        return selectedBooks;
    }

    public double newPrice(double price) {
        return price;
    }
}
