package com.example.springdb.service;

import com.example.springdb.domain.Member;
import com.example.springdb.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void memberJoinTest() {
        Member m = new Member();
        m.setName("spring222");

        long id = memberService.join(m);

        Member finder = memberService.findOne(id).get();
        assertThat(m.getName()).isEqualTo(finder.getName());
    }
}
