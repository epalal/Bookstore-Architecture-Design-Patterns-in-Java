package progetto.utils.classes.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import progetto.main.classes.*;
import progetto.utils.classes.BookVisitor;
import progetto.utils.classes.Purchase;
import progetto.utils.classes.PurchaseVisitor;
import progetto.utils.classes.SummerStrategy;

public class PurchaseVisitorTest {
	private BookVisitor visitor;
	private Purchase receipt;
	private ShopWindow shopWindow;
	
@Before
	public void setup() {
		receipt = new MockMakeReceipt();
		shopWindow = new ShopWindow(new SummerStrategy());
		visitor = new PurchaseVisitor(shopWindow,receipt);
	}

@Test
	public void VisitorSingleBookTest() {
		Item book = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		book.accept(visitor);
		assertEquals(receipt.toString(), "	The Catcher in the Rye 19.19£\n");
	}

@Test
	public void VisitorMoreSingleBookTest() {
		Item book1 = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item book2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		book1.accept(visitor);
		book2.accept(visitor);
		assertEquals(receipt.toString(),
			"	The Catcher in the Rye 19.19£\n"
			+"	To Kill a Mockingbird 12.49£\n");
	}
@Test
	public void VisitorBookCollectionTest() {
		BookCollection books = new BookCollection("Best 3 books of 20th Century");
		Item item1 = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item item2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		Item item3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		books.addItem(item1);
		books.addItem(item2);
		books.addItem(item3);
	    books.accept(visitor);
	    assertEquals(receipt.toString(),
	    		"Best 3 books of 20th Century 42£\n"
				+"	The Catcher in the Rye 19.19£\n"
				+"					-10%\n"
				+"	To Kill a Mockingbird 12.49£\n"
				+"					-10%\n"
				+"	1984 14.99£\n"
	    		+"					-10%\n"
	    		+"-------------------------\n");
	}

@Test
public void VisitorMoreBookCollectionTest() {
	BookCollection books1 = new BookCollection("Must-Read Classics");
	BookCollection books2 = new BookCollection("Best 3 books of 20th Century");
	BookCollection books3 = new BookCollection("Fantasy Must-Have");
	Item item1 = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
	Item item2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
	Item item3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
	Item item4 = new SingleBook("B004", 9.00, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 0);
	Item item7 = new SingleBook("B007", 17.90, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 0);
	Item item8 = new SingleBook("B008", 11.90, "The Hobbit", "J.R.R. Tolkien", "Fantasy", 0);
	books2.addItem(item1);
	books2.addItem(item2);
	books2.addItem(item3);
	books3.addItem(item7);
	books3.addItem(item8);
    books1.addItem(books2);
    books1.addItem(books3);
    books1.addItem(item4);
    books1.accept(visitor);
    assertEquals(receipt.toString(),
    		"Must-Read Classics 70,04£\n"
    		+"Best 3 books of 20th Century 42£\n"
    		+"	The Catcher in the Rye 19.19£\n"
    		+"					-10%\n"
    		+"	To Kill a Mockingbird 12.49£\n"
    		+"					-10%\n"
    		+"	1984 14.99£\n"
    		+"					-10%\n"
    		+"-------------------------\n"
    		+"					-10%\n"
    		+"Fantasy Must-Have 26,82£\n"
    		+"	Harry Potter and the Sorcerer's Stone 17.9£\n"
    		+"					-10%\n"
    		+"	The Hobbit 11.9£\n"
    		+"					-10%\n"
    		+"-------------------------\n"
    		+"					-10%\n"
    		+"	The Great Gatsby 9.0£\n"
    		+"					-10%\n"
    		+"-------------------------\n");
	}
}
