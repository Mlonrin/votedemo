package com.baizhi.vote.dao;

import com.baizhi.vote.entity.VoteSubject;

public interface VoteSubjectDao {

    /**
     *
     * @param voteSubject
     */
    void insert(VoteSubject voteSubject);

    /**
     *
     * @param ids
     */
    void multiDelete(int[] ids);

    VoteSubject selectOne(int vs_id);
}
