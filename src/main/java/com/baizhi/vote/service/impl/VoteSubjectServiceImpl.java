package com.baizhi.vote.service.impl;

import com.baizhi.vote.dao.VoteOptionDao;
import com.baizhi.vote.dao.VoteSubjectDao;
import com.baizhi.vote.entity.VoteSubject;
import com.baizhi.vote.service.VoteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteSubjectServiceImpl implements VoteSubjectService {
    @Autowired
    private VoteSubjectDao voteSubjectDao;

    @Autowired
    private VoteOptionDao voteOptionDao;

    @Override
    public void addVoteSubject(VoteSubject voteSubject) {
        //插入主题
        voteSubjectDao.insert(voteSubject);

        //插入选项
        voteOptionDao.insert(voteSubject.getVoteOptionList(),voteSubject.getVs_id());
    }

    @Override
    public void multiDelete(int[] ids) {
        voteSubjectDao.multiDelete(ids);
    }

    @Override
    public VoteSubject selectOne(int vs_id) {
        return voteSubjectDao.selectOne(vs_id);
    }
}
