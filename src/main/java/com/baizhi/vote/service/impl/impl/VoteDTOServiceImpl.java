package com.baizhi.vote.service.impl.impl;

import com.baizhi.vote.dao.VoteDTODao;
import com.baizhi.vote.service.VoteDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteDTOServiceImpl implements VoteDTOService {

    @Autowired
    private VoteDTODao voteDTODao;

    @Override
    public List<VoteDTODao> selectByTitle(String title, int page, int rows) {
        int start = (page-1)*rows+1;
        int end = page*rows;

        List<VoteDTODao> voteDTODaoList = voteDTODao.selectByTitle(title, start, end);
        return voteDTODaoList;
    }

    @Override
    public int getCount(String title) {
        return voteDTODao.getCount(title);
    }
}
