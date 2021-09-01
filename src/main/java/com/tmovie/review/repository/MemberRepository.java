package com.tmovie.review.repository;

import com.tmovie.review.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    void deleteMemberByMid(Long mid);
}
