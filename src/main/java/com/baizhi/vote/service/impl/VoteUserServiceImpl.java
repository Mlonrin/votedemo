package com.baizhi.vote.service.impl;

import com.baizhi.vote.dao.VoteUserDao;
import com.baizhi.vote.entity.VoteUser;
import com.baizhi.vote.service.VoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VoteUserServiceImpl implements VoteUserService {
    @Autowired
    private VoteUserDao voteUserDao;

    @Override
    public void register(VoteUser voteUser) {
        voteUserDao.insert(voteUser);
    }

    @Override
    public Map login(VoteUser voteUser) {
        Map map = new HashMap();
        voteUser = voteUserDao.selectOne(voteUser);
        if(voteUser!=null){
            map.put("isLogin",true);
            map.put("user",voteUser);
        }else {
            map.put("isLogin",false);
        }
        return map;
    }
}
