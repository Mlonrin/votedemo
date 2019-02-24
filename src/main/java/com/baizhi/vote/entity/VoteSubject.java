package com.baizhi.vote.entity;

import java.util.List;

public class VoteSubject {

    private int vs_id;
    private String vs_title;
    private int vs_type;
    private int vs_status;
    private List<VoteOption> voteOptionList;
    private List<VoteItem> voteItemList;

    public VoteSubject() {
    }

    public VoteSubject(int vs_id, String vs_title, int vs_type, int vs_status, List<VoteOption> voteOptionList, List<VoteItem> voteItemList) {
        this.vs_id = vs_id;
        this.vs_title = vs_title;
        this.vs_type = vs_type;
        this.vs_status = vs_status;
        this.voteOptionList = voteOptionList;
        this.voteItemList = voteItemList;
    }

    public int getVs_id() {

        return vs_id;
    }

    public void setVs_id(int vs_id) {
        this.vs_id = vs_id;
    }

    public String getVs_title() {
        return vs_title;
    }

    public void setVs_title(String vs_title) {
        this.vs_title = vs_title;
    }

    public int getVs_type() {
        return vs_type;
    }

    public void setVs_type(int vs_type) {
        this.vs_type = vs_type;
    }

    public int getVs_status() {
        return vs_status;
    }

    public void setVs_status(int vs_status) {
        this.vs_status = vs_status;
    }

    public List<VoteOption> getVoteOptionList() {
        return voteOptionList;
    }

    public void setVoteOptionList(List<VoteOption> voteOptionList) {
        this.voteOptionList = voteOptionList;
    }

    public List<VoteItem> getVoteItemList() {
        return voteItemList;
    }

    public void setVoteItemList(List<VoteItem> voteItemList) {
        this.voteItemList = voteItemList;
    }

    @Override
    public String toString() {
        return "VoteSubject{" +
                "vs_id=" + vs_id +
                ", vs_title='" + vs_title + '\'' +
                ", vs_type=" + vs_type +
                ", vs_status=" + vs_status +
                ", voteOptionList=" + voteOptionList +
                ", voteItemList=" + voteItemList +
                '}';
    }
}
