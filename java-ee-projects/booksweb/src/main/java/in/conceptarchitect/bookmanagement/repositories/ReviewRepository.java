package in.conceptarchitect.bookmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.conceptarchitect.bookmanagement.entities.Review;

public interface ReviewRepository 
	extends JpaRepository<Review,Integer> {

}
