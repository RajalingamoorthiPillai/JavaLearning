package in.conceptarchitect.bookmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.conceptarchitect.bookmanagement.entities.Book;
import in.conceptarchitect.bookmanagement.entities.EntityNotFoundException;
import in.conceptarchitect.bookmanagement.entities.Review;
import in.conceptarchitect.bookmanagement.repositories.AuthorRepository;
import in.conceptarchitect.bookmanagement.repositories.BookRepository;
import in.conceptarchitect.bookmanagement.viewmodel.NewBook;
import in.conceptarchitect.bookmanagement.viewmodel.NewReview;

@Service
public class JpaBookService implements BookService {

	@Autowired 
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	
	
	@Override
	public Book addBook(NewBook book) {
		
		var author = authorRepository
						.findById(book.getAuthorId())
						.orElseThrow(()-> new EntityNotFoundException("Invalid Author Id: "+book.getAuthorId()));

		var b=new Book();
		b.setId(book.getId());
		b.setTitle(book.getTitle());
		b.setTags(book.getTags());
		b.setAuthor(author);
		b.setPrice(book.getPrice());
		b.setRating(book.getRating());
		b.setDescription(book.getDescription());
		b.setCoverUrl(book.getCoverUrl());
		
		return bookRepository.save(b);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Override
	public Book getBookById(String id){
		return bookRepository
					.findById(id)
					.orElseThrow(()->new EntityNotFoundException("Invalid Book Id :"+id));
				
	}
	
	@Override
	public List<Review> getAllReviews(String bookId){
		return getBookById(bookId).getReviews();
	}
	
	@Override
	public Review addReview(NewReview review)
	{
		var book=getBookById(review.getBookId());
		var r=new Review();
		r.setBook(book);
		r.setReviewerName(review.getReviewerName());
		r.setReviewerEmail(review.getReviewerEmail());
		r.setRating(review.getRating());
		r.setReview(review.getReview());
		r.setTitle(review.getTitle());
		
		book.getReviews().add(r);
		bookRepository.save(book);
		return r;
	}
	
}
