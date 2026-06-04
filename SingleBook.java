package progetto.main.classes;

import progetto.utils.classes.BookVisitor;

public class SingleBook extends Item {
	private String id;
	private double price;
	private String title;
	private String author;
	private String genre;
	private int bestSeller;

	public SingleBook(String id, double price, String name, String author, String genre, int bestSeller) {
		super(name);
		this.id = id;
		this.price = price;
		this.title = name;
		this.author = author;
		this.genre = genre;
		this.bestSeller = bestSeller;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public double calculatePrice() {
		return price;
	}

	public int getBestSeller() {
		return bestSeller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + bestSeller;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		SingleBook other = (SingleBook) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bestSeller != other.bestSeller)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + ", price: " + price + ", title: " + title + ", author: " + author + ", genre: " + genre
				+ ", bestSeller: " + bestSeller;
	}

	@Override
	public void accept(BookVisitor visitor) {
		visitor.visitSingleBook(this);
	}
	
	public void setBestSeller(int bestSeller) {
		this.bestSeller = bestSeller;
	}
}
