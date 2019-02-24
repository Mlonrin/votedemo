package com.baizhi.vote.entity;

public class VoteItem {

    private int vi_id;
    private VoteUser voteUser;
    private VoteOption voteOption;

    public VoteItem() {
    }

    public VoteItem(int vi_id, VoteUser voteUser, VoteOption voteOption) {

        this.vi_id = vi_id;
        this.voteUser = voteUser;
        this.voteOption = voteOption;
    }

    public int getVi_id() {

        return vi_id;
    }

    public void setVi_id(int vi_id) {
        this.vi_id = vi_id;
    }

    public VoteUser getVoteUser() {
        return voteUser;
    }

    public void setVoteUser(VoteUser voteUser) {
        this.voteUser = voteUser;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }

    @Override
    public String toString() {
        return "VoteItem{" +
                "vi_id=" + vi_id +
                ", voteUser=" + voteUser +
                ", voteOption=" + voteOption +
                '}';
    }
}
