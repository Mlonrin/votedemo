package com.baizhi.vote.dao;

import com.baizhi.vote.entity.VoteUser;

public interface VoteUserDao {

    public void insert(VoteUser voteUser);

    public VoteUser selectOne(VoteUser voteUser);

}
