package com.fekadu.onlinegebeya.service;

import com.fekadu.onlinegebeya.domain.Review;

import java.util.List;

public interface ReviewService {
    public Review save(Review rv);

    public List<Review> getReviewsByApproved(boolean b);

    public List<Review> getReviews();

    List<Review> getAll();
    int getAverageRating(Long productId);
    List<Review> findByProductId(Long id);
    public List<Review> getReviewsUnapproved();

    public Review getReviewById(Long id);
}
