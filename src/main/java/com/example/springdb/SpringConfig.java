package com.example.springdb;

import com.example.springdb.repository.JdbcMemberRepository;
import com.example.springdb.repository.JdbcTemplateMemberRepository;
import com.example.springdb.repository.JpaMemberRepository;
import com.example.springdb.repository.MemberRepository;
import com.example.springdb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    DataSource dataSource;
    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository);
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new JpaMemberRepository(em);
        return new JdbcTemplateMemberRepository(dataSource);
        //return new JdbcMemberRepository(dataSource);
    }
}
