package com.baizhi.vote.entity;

public class VoteDTO {

    private int vs_id;
    private String vs_title;
    private int user_number;
    private int option_number;

    public VoteDTO() {
    }

    public VoteDTO(int vs_id, String vs_title, int user_number, int option_number) {

        this.vs_id = vs_id;
        this.vs_title = vs_title;
        this.user_number = user_number;
        this.option_number = option_number;
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

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }

    public int getOption_number() {
        return option_number;
    }

    public void setOption_number(int option_number) {
        this.option_number = option_number;
    }

    @Override
    public String toString() {
        return "VoteDTODao{" +
                "vs_id=" + vs_id +
                ", vs_title='" + vs_title + '\'' +
                ", user_number=" + user_number +
                ", option_number=" + option_number +
                '}';
    }
}
