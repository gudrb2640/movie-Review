package com.tmovie.review.repository;

import com.tmovie.review.entity.Member;
import com.tmovie.review.entity.Movie;
import com.tmovie.review.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void insertMovieReview() {

        IntStream.rangeClosed(1,100).forEach(i->{
            Long mno = (long) ((Math.random() * 100) + 1);

            Long mid = ((long) (Math.random() * 100) + 1);

            Review review = Review.builder()
                    .movie(Movie.builder().mno(mno).build())
                    .member(Member.builder().mid(mid).build())
                    .grade((int) (Math.random() * 5) + 1)
                    .text("이 영화에 대한 느낌" + i)
                    .build();

            reviewRepository.save(review);

        });
    }

    @Test
    void testGetMovieReviews() {

        Movie movie = Movie.builder().mno(9L).build();

        List<Review> reviews = reviewRepository.findByMovie(movie);

        reviews.forEach(review -> {
            System.out.print(review);
            System.out.println("\t" + review.getMember().getEmail());
        });
    }

}