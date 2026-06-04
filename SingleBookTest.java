package progetto.main.classes.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import progetto.main.classes.Item;
import progetto.main.classes.SingleBook;

public class SingleBookTest {
	@Test
	public void testSingleBookToString() {
		SingleBook book = new SingleBook("B001", 19.99, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		assertEquals(book.toString(),
				"id: B001, price: 19.99, title: The Catcher in the Rye, author: J.D. Salinger, genre: Fiction, bestSeller: 0");
	}

	@Test
	public void testSingleBookEquals() {
		SingleBook book1 = new SingleBook("B001", 19.99, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		SingleBook book2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		SingleBook book3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		SingleBook book4 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		assertNotEquals(book1, book2);
		assertNotEquals(book2, book3);
		assertEquals(book3, book4);

	}

	@Test
	public void testEccipienteBaseHashCode() {
		Item book1 = new SingleBook("B001", 19.99, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		Item book2 = new SingleBook("B002", 12.49, "To Kill a Mockingbird", "Harper Lee", "Fiction", 0);
		Item book3 = new SingleBook("B003", 14.99, "1984", "George Orwell", "ScienceFiction", 0);
		Item book4 = new SingleBook("B001", 19.99, "The Catcher in the Rye", "J.D. Salinge", "Fiction", 0);
		Item book5 = new SingleBook("B001", 19.99, "The Catcher in the Rye", "J.D. Salinger", "Fiction", 0);
		assertEquals(book1.hashCode(), book5.hashCode());
		assertNotEquals(book1.hashCode(), book2.hashCode());
		assertNotEquals(book1.hashCode(), book3.hashCode());
		assertNotEquals(book1.hashCode(), book4.hashCode());
	}
}
