package com.tmovie.review.repository;

import com.tmovie.review.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieImageRepository extends JpaRepository<MovieImage, Long> {

}
