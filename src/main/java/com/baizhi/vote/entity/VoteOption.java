package com.baizhi.vote.entity;

public class VoteOption {

    private int vo_id;
    private String vo_option;
    private int vo_order;   //选项顺序

    public VoteOption() {
    }

    public VoteOption(int vo_id, String vo_option, int vo_order) {

        this.vo_id = vo_id;
        this.vo_option = vo_option;
        this.vo_order = vo_order;
    }

    public VoteOption(String vo_option) {
        this.vo_option = vo_option;
    }

    public int getVo_id() {

        return vo_id;
    }

    public void setVo_id(int vo_id) {
        this.vo_id = vo_id;
    }

    public String getVo_option() {
        return vo_option;
    }

    public void setVo_option(String vo_option) {
        this.vo_option = vo_option;
    }

    public int getVo_order() {
        return vo_order;
    }

    public void setVo_order(int vo_order) {
        this.vo_order = vo_order;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "vo_id=" + vo_id +
                ", vo_option='" + vo_option + '\'' +
                ", vo_order=" + vo_order +
                '}';
    }
}
