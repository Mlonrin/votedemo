package com.baizhi.vote.service;

import com.baizhi.vote.entity.VoteItem;

import java.util.List;

public interface VoteItemService {

    public void addVoteItem(List<VoteItem> voteItemList, String vu_user_id, int vs_id);
}
