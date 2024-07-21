package com.devil.reviewRating_service.repository;

import com.devil.reviewRating_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review , Long> {}
