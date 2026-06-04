package progetto.main.classes.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.Collection;
import progetto.main.classes.Item;
import progetto.main.classes.SingleBook;
import progetto.main.classes.BookCollection;

public class BookCollectionTest {
	@Test
	public void testBookCollectionToString() {
		BookCollection books = new BookCollection("Best 3 books of 20th Century");
		Item item1 = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item item2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		Item item3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		Collection<Item> collection = books.getBooks();
		collection.add(item1);
		collection.add(item2);
		collection.add(item3);
		assertEquals(books.toString(), "BookCollection: Best 3 books of 20th Century"
				+ "\n [id: B001, price: 19.19, title: The Catcher in the Rye, author: J.D. Salinger, genre: Fiction, bestSeller: 0, "
				+ "id: B002, price: 12.49, title: To Kill a Mockingbird, author: Harper Lee, genre: Fiction, bestSeller: 0, "
				+ "id: B003, price: 14.99, title: 1984, author: George Orwell, genre: ScienceFiction, bestSeller: 0]");
	}

	@Test
	public void testBookCollectionEquals() {
		BookCollection books1 = new BookCollection("Best books of 20th Century");
		BookCollection books2 = new BookCollection("Best books of 20th Century");
		Item item1 = new SingleBook("B001", 19.10, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		books1.getBooks().add(item1);
		books2.getBooks().add(item1);
		assertEquals(books1, books2);
		Item item2 = new SingleBook("B002", 12.40, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		books2.getBooks().add(item2);
		assertNotEquals(books1, books2);
	}

	@Test
	public void testBookCollectionHashCode() {
		BookCollection books1 = new BookCollection("Best books of 20th Century");
		BookCollection books2 = new BookCollection("Best books of 20th Century");
		Item book1 = new SingleBook("B001", 19.10, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		books1.getBooks().add(book1);
		books2.getBooks().add(book1);
		assertEquals(books1, books2);
		Item book2 = new SingleBook("B002", 12.40, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		books2.getBooks().add(book2);
		assertNotEquals(books1.hashCode(), books2.hashCode());
	}

	@Test
	public void testBookCollectionPrice() {
		BookCollection books1 = new BookCollection("Fiction Must-have");
		BookCollection books2 = new BookCollection("Best books of 20th Century");
		Item book1 = new SingleBook("B001", 19.10, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item book2 = new SingleBook("B002", 12.40, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		Item book3 = new SingleBook("B003", 14.90, "1984", "George Orwell", "ScienceFiction", 0);
		books1.getBooks().add(book1);
		books1.getBooks().add(book2);
		books2.getBooks().add(books1);
		books2.getBooks().add(book3);
		assertEquals(books1.calculatePrice(), 28.35, 0.01);
		assertEquals(books2.calculatePrice(), 38.92, 0.01);
		books2.getBooks().remove(book3);
		assertEquals(books2.calculatePrice(), 28.35, 0.01);
		books2.getBooks().remove(books1);
		assertEquals(books2.calculatePrice(), 0, 0.01);

	}

	@Test
	public void testPrintTitles() {
		BookCollection books1 = new BookCollection("Best 3 books of 20th Century");
		BookCollection books2 = new BookCollection("Fiction Must-have");
		Item item1 = new SingleBook("B001", 19.19, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item item2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		Item item3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		Collection<Item> collection = books1.getBooks();
		books2.getBooks().add(item2);
		books2.getBooks().add(item3);
		collection.add(item1);
		collection.add(books2);
		assertEquals(books1.toString(), "BookCollection: Best 3 books of 20th Century"
				+ "\n [id: B001, price: 19.19, title: The Catcher in the Rye, author: J.D. Salinger, genre: Fiction, bestSeller: 0, "
				+ "BookCollection: Fiction Must-have\n [id: B002, price: 12.49, title: To Kill a Mockingbird, author: Harper Lee, genre: Fiction, bestSeller: 0, "
				+ "id: B003, price: 14.99, title: 1984, author: George Orwell, genre: ScienceFiction, bestSeller: 0]]");
	}
}
