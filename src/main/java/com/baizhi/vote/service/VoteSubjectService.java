package com.baizhi.vote.service;

import com.baizhi.vote.entity.VoteSubject;

public interface VoteSubjectService {
    public void addVoteSubject(VoteSubject voteSubject);

    void multiDelete(int[] ids);

    VoteSubject selectOne(int vs_id);
}
