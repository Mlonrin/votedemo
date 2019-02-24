package com.baizhi.vote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.vote.dao")
public class VoteAppRun {

    public static void main(String[] args) {
        SpringApplication.run(VoteAppRun.class, args);
    }

}
