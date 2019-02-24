package com.baizhi.vote.service.impl;

import com.baizhi.vote.dao.VoteItemDao;
import com.baizhi.vote.entity.VoteItem;
import com.baizhi.vote.service.VoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteItemServiceImpl implements VoteItemService {

    @Autowired
    private VoteItemDao voteItemDao;

    @Override
    public void addVoteItem(List<VoteItem> voteItemList, String vu_user_id, int vs_id) {
        voteItemDao.insert(voteItemList,vu_user_id,vs_id);
    }
}
