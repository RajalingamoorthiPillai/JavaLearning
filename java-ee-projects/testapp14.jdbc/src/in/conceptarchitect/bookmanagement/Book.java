package in.conceptarchitect.bookmanagement;

public class Book {
	String id;
	String title;
	String author;
	String cover;
	String description;
	int price;
	String tags;
	double rating;
	public Book(String id, String title, String author, String cover, String description, int price, String tags,
			double rating) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.cover = cover;
		this.description = description;
		this.price = price;
		this.tags = tags;
		this.rating = rating;
	}
	public Book() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", cover=" + cover + ", price=" + price
				+ ", rating=" + rating + "]";
	}
	
	

}
