package in.conceptarchitect.bookmanagement.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



@Entity
@Table(name="Books")
public class Book {
	
	@Id
	String id;
	
	String title;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	Author author;
	
	@OneToMany(mappedBy="book")
	List<Review> reviews=new ArrayList<Review>();
	
	
	String coverUrl;
	
	
	
	
	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Min(0)
	int price;
	
	@Min(1) @Max(5)
	double rating;
	
	@Column(length = 5000)
	String description;
	
	String tags;

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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	

	public Book(String id, String title, Author author, List<Review> reviews, String coverUrl, @Min(0) int price,
			@Min(1) @Max(5) double rating, String description, String tags) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.reviews = reviews;
		this.coverUrl = coverUrl;
		this.price = price;
		this.rating = rating;
		this.description = description;
		this.tags = tags;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author.getName() + "]";
	}
	
	
	
	

}
