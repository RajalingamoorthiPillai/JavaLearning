package in.conceptarchitect.bookmanagement.services;

import java.util.List;

import in.conceptarchitect.bookmanagement.entities.Book;
import in.conceptarchitect.bookmanagement.entities.Review;
import in.conceptarchitect.bookmanagement.viewmodel.NewBook;
import in.conceptarchitect.bookmanagement.viewmodel.NewReview;

public interface BookService {

	Book addBook(NewBook book);

	List<Book> getAllBooks();

	Book getBookById(String id);

	List<Review> getAllReviews(String bookId);

	Review addReview(NewReview review);

}