package com.fekadu.onlinegebeya.service.serviceImpl;

import com.fekadu.onlinegebeya.domain.Review;
import com.fekadu.onlinegebeya.repository.ReviewRepo;
import com.fekadu.onlinegebeya.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> getReviewsByApproved(boolean b) {
        return (List)reviewRepo.findByApproved(b);
    }

    @Override
    public List<Review> getReviews() {
        return (List)reviewRepo.findAll();
    }

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review save(Review review){
        return reviewRepo.save(review);
    }

    @Override
    public int getAverageRating(Long productId) {
        return reviewRepo.getAverageRating(productId);
    }

    @Override
    public List<Review> findByProductId(Long id) {
        return reviewRepo.findByProductId(id);
    }

    public List<Review> getReviewsUnapproved() {
        return reviewRepo.findByApproved(false);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepo.findById(id).get();
    }
}
