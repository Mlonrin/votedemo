package com.baizhi.vote.test;

import com.baizhi.vote.entity.VoteSubject;
import com.baizhi.vote.service.VoteSubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTest {
    @Autowired
    private VoteSubjectService voteSubjectService;

    @Test
    public void selectOne(){
        VoteSubject voteSubject = voteSubjectService.selectOne(1);
        System.out.println(voteSubject);
    }
}
