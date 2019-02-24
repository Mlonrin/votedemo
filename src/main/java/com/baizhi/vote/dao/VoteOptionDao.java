package com.baizhi.vote.dao;

import com.baizhi.vote.entity.VoteOption;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteOptionDao {

    void insert(@Param("voteOptionList") List<VoteOption> voteOptionList, @Param("vs_id") int vs_id);

}
