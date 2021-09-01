package com.tmovie.review.repository;

import com.tmovie.review.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void testInsertMember() {

        IntStream.rangeClosed(1, 100).forEach(i ->{
            Member member = Member.builder()
                    .email("m" + i + "@naver.com")
                    .pw("1111")
                    .nickname("reviewer" + i).build();
            memberRepository.save(member);
        });
    }

    @Test
    @Transactional
    @Commit
    void testDeleteMember() {

        Long mid = 1L;

        Member member = Member.builder().mid(mid).build();

        reviewRepository.deleteReviewByMember(member);
        memberRepository.deleteMemberByMid(mid);

    }
}