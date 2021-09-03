package com.tmovie.review.controller;

import com.tmovie.review.dto.ReviewDTO;
import com.tmovie.review.entity.Movie;
import com.tmovie.review.entity.Review;
import com.tmovie.review.repository.ReviewRepository;
import com.tmovie.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@Log4j2
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{mno}/all")
    public ResponseEntity<List<ReviewDTO>> getList(@PathVariable("mno") long mno) {

        List<ReviewDTO> result = reviewService.getListOfMovie(mno);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/{mno}")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDTO reviewDTO) {
        Long reviewnum = reviewService.register(reviewDTO);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @PutMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> modyfyReview(@PathVariable Long reviewnum,
                                             @RequestBody ReviewDTO reviewDTO) {

        reviewService.modify(reviewDTO);
        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }

    @DeleteMapping("/{mno}/{reviewnum}")
    public ResponseEntity<Long> removeReview(@PathVariable Long reviewnum) {
        reviewService.delete(reviewnum);

        return new ResponseEntity<>(reviewnum, HttpStatus.OK);
    }
}
