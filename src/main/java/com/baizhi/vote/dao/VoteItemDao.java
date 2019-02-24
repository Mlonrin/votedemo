package com.baizhi.vote.dao;

import com.baizhi.vote.entity.VoteItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VoteItemDao {

    /**
     *  向数据插入投票结果
     * @param voteItemList 选项id集合
     * @param vu_user_id    参与选择的用户
     * @param vs_id         投票主题id
     */
    void insert(@Param("voteItemList") List<VoteItem> voteItemList, @Param("vu_user_id") String vu_user_id, @Param("vs_id") int vs_id);

}
