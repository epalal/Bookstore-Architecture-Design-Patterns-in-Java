package progetto.main.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import progetto.utils.classes.BookVisitor;

import java.util.Iterator;

public class BookCollection extends Item {
	private String collectionTitle;
	private Collection<Item> collection = new ArrayList<>();


	public BookCollection(String name, Collection<Item> collection) {
		super(name);
		this.collectionTitle = getName();
		this.collection = collection;
	}
	
	public BookCollection(String name) {
		super(name);
		this.collectionTitle = getName();
	}
	
	public Collection<Item> getBooks() {
		return collection;
	}

	public void addItem(Item item) {
		collection.add(item);
	}
	
	public void removeItem(Item item) {
		collection.remove(item);
	}

	public Iterator<Item> iterator() {
		return collection.iterator();
	}

	@Override
	public double calculatePrice() {
		double price = 0;
		double discount = 0.1;
		Iterator<Item> BookIteration = this.iterator();
		if (!BookIteration.hasNext()) {
			return price;
		}
		price += BookIteration.next().calculatePrice();
		if (!BookIteration.hasNext()) {
			return price;
		}
		while (BookIteration.hasNext()) {
			price += BookIteration.next().calculatePrice();
		}
		return price = price - price * discount;
	}

	@Override
	public void accept(BookVisitor visitor) {
		visitor.visitBookCollection(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(collection);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookCollection other = (BookCollection) obj;
		return Objects.equals(collection, other.collection);
	}

	@Override
	public String toString() {
		return super.toString() + "\n " + collection.toString();
	}

	public String getCollectionTitle() {
		return collectionTitle;
	}
}
