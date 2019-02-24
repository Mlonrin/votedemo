package com.baizhi.vote.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteDTODao {

    public List<VoteDTODao> selectByTitle(@Param("title") String title, @Param("start") int start, @Param("end") int end);

    public int getCount(@Param("title") String title);

}
