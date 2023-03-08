package in.conceptarchitect.bookmanagement.viewmodel;

import in.conceptarchitect.bookmanagement.entities.Review;

public class NewReview extends Review {

	String bookId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	
}
