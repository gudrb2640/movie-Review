package com.tmovie.review.service;

import com.tmovie.review.dto.ReviewDTO;
import com.tmovie.review.entity.Member;
import com.tmovie.review.entity.Movie;
import com.tmovie.review.entity.Review;

import java.util.List;

public interface ReviewService {

    //영화의 모든 영화리뷰를 가져온다.
    List<ReviewDTO> getListOfMovie(Long mno);

    //영화 리뷰를 추가
    Long register(ReviewDTO reviewDTO);

    //특정한 영화 리뷰를 수정
    void modify(ReviewDTO reviewDTO);

    //영화 리뷰 삭제
    void delete(Long reviewnum);

    default Review dtoToEntity(ReviewDTO reviewDTO) {

        return Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .movie(Movie.builder().mno(reviewDTO.getMno()).build())
                .member(Member.builder().mid(reviewDTO.getMid()).build())
                .grade(reviewDTO.getGrade())
                .text(reviewDTO.getText())
                .build();
    }

    default ReviewDTO entityToDTO(Review review) {

        return ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
                .mno(review.getMovie().getMno())
                .mid(review.getMember().getMid())
                .nickname(review.getMember().getNickname())
                .email(review.getMember().getEmail())
                .grade(review.getGrade())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();
    }

}
