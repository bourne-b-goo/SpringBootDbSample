package com.example.springdb.service;

import com.example.springdb.domain.Member;
import com.example.springdb.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Service
public class TestServices {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public void testTrans(boolean useException) {

        String userName = getRandomName();

        for (int i = 0; i < 5; i++) {
            Member member = new Member();
            member.setName(userName + i);

            memberRepository.save(member);
        }

        if (useException)
            throw new RuntimeException("testTrans");
    }

    public void insert() {

        String userName = getRandomName();

        for (int i = 0; i < 5; i++) {
            Member member = new Member();
            member.setName(userName + i);

            memberRepository.save(member);

            if (i >= 2)
                throw new RuntimeException("testTrans");
        }
    }

    private String getRandomName() {
        LocalDate n = LocalDate.now();
        LocalTime t = LocalTime.now();

        return "user_" + n.toString() + t.toString();
    }
}
