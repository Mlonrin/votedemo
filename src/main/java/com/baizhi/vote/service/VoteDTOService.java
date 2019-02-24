package com.baizhi.vote.service;

import com.baizhi.vote.dao.VoteDTODao;

import java.util.List;

public interface VoteDTOService {

    public List<VoteDTODao> selectByTitle(String title, int page, int rows);

    public int getCount(String title);

}
