package com.baizhi.vote.entity;

public class VoteUser {

    private String vu_user_id;

    private String vu_user_name;

    private String vu_password;

    private int vu_status;

    public VoteUser() {
    }

    public VoteUser(String vu_user_id, String vu_user_name, String vu_password, int vu_status) {

        this.vu_user_id = vu_user_id;
        this.vu_user_name = vu_user_name;
        this.vu_password = vu_password;
        this.vu_status = vu_status;
    }

    public String getVu_user_id() {

        return vu_user_id;
    }

    public void setVu_user_id(String vu_user_id) {
        this.vu_user_id = vu_user_id;
    }

    public String getVu_user_name() {
        return vu_user_name;
    }

    public void setVu_user_name(String vu_user_name) {
        this.vu_user_name = vu_user_name;
    }

    public String getVu_password() {
        return vu_password;
    }

    public void setVu_password(String vu_password) {
        this.vu_password = vu_password;
    }

    public int getVu_status() {
        return vu_status;
    }

    public void setVu_status(int vu_status) {
        this.vu_status = vu_status;
    }

    @Override
    public String toString() {
        return "VoteUser{" +
                "vu_user_id='" + vu_user_id + '\'' +
                ", vu_user_name='" + vu_user_name + '\'' +
                ", vu_password='" + vu_password + '\'' +
                ", vu_status=" + vu_status +
                '}';
    }
}
