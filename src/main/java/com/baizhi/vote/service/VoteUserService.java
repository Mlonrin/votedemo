package com.baizhi.vote.service;

import com.baizhi.vote.entity.VoteUser;

import java.util.Map;

public interface VoteUserService {

    public void register(VoteUser voteUser);

    public Map login(VoteUser voteUser);
}
