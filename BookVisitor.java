package progetto.utils.classes;

import progetto.main.classes.BookCollection;
import progetto.main.classes.SingleBook;

public interface BookVisitor {
	
	void visitSingleBook(SingleBook book);

	void visitBookCollection(BookCollection books);
}
