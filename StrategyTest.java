package progetto.utils.classes.tests;

import org.junit.Test;

import progetto.main.classes.ShopWindow;
import progetto.main.classes.SingleBook;
import progetto.utils.classes.NoStrategy;
import progetto.utils.classes.SummerStrategy;
import progetto.utils.classes.WinterStrategy;
import progetto.utils.classes.BestSellerStrategy;


import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class StrategyTest {
	@Test
	public void PicksTest() {
		WinterStrategy winterSales = new WinterStrategy();
		SummerStrategy summerSales = new SummerStrategy();
		NoStrategy noSales = new NoStrategy();
		BestSellerStrategy bestSellerStrategy = new BestSellerStrategy();
		ArrayList<SingleBook> collection = new ArrayList<>();
		SingleBook book1 = new SingleBook("B001", 19.90, "The Catcher in the Rye", "J.D. Salinger", "Fiction",0);
		SingleBook book2 = new SingleBook("B002", 12.40, "To Kill a Mockingbird", "Harper Lee", "Fiction",0);
		SingleBook book3 = new SingleBook("B003", 14.23, "1984", "George Orwell", "ScienceFiction", 0);
		SingleBook book4 = new SingleBook("B004", 9.00, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 0);
		SingleBook book5 = new SingleBook("B005", 7.18, "Pride and Prejudice", "Jane Austen", "Romance", 0);
		SingleBook book6 = new SingleBook("B006", 24.19, "The Da Vinci Code", "Dan Brown", "Thriller", 0);
		SingleBook book7 = new SingleBook("B007", 17.90, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 0);
		SingleBook book8 = new SingleBook("B008", 11.90, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 0);
		SingleBook book9 = new SingleBook("B009", 16.40, "The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "Mystery", 0);
		SingleBook book10 = new SingleBook("B010", 8.90, "It", "Stephen King", "Horror", 0);
		collection.add(book1);
		collection.add(book2);
		collection.add(book3);
		collection.add(book4);
		collection.add(book5);
		collection.add(book6);
		collection.add(book7);
		collection.add(book8);
		collection.add(book9);
		collection.add(book10);
		
		ShopWindow shopWindow = new ShopWindow(winterSales);
		ArrayList<SingleBook> pickedBooks = winterSales.pickBooks(collection);
		ArrayList<SingleBook> expectedBooks = new ArrayList<>();
		expectedBooks.add(book3);
		expectedBooks.add(book5);
		assertEquals(pickedBooks,expectedBooks);
		expectedBooks.clear();
		
		shopWindow.setStrategy(summerSales);
		pickedBooks = summerSales.pickBooks(collection);
		expectedBooks.add(book1);
		expectedBooks.add(book2);
		expectedBooks.add(book4);
		expectedBooks.add(book7);
		expectedBooks.add(book8);
		assertEquals(pickedBooks,expectedBooks);
		expectedBooks.clear();		
		
		shopWindow.setStrategy(noSales);
		pickedBooks = noSales.pickBooks(collection);
		assertEquals(pickedBooks,expectedBooks);
		expectedBooks.clear();
		
		shopWindow.setStrategy(bestSellerStrategy);
	    pickedBooks = bestSellerStrategy.pickBooks(collection);
	    expectedBooks.add(book9);
		expectedBooks.add(book10);
		assertEquals(pickedBooks,expectedBooks);
		expectedBooks.clear();	
	}
}
