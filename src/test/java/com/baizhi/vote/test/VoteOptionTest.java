package com.baizhi.vote.test;


import com.baizhi.vote.dao.VoteOptionDao;
import com.baizhi.vote.entity.VoteOption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VoteOptionTest {
    @Autowired
    private VoteOptionDao voteOptionDao;

    @Test
    public void insert(){

        List<VoteOption> voteOptionList = new ArrayList<>();

        voteOptionList.add(new VoteOption("踏足山巅"));
        voteOptionList.add(new VoteOption("步入低谷"));
        voteOptionList.add(new VoteOption("顺风而往"));

        voteOptionDao.insert(voteOptionList,1);

    }
}
