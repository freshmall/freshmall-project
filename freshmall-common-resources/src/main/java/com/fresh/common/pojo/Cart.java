package com.fresh.common.pojo;

import java.io.Serializable;

public class Cart implements Serializable {

    private Integer id;
    private String userId;
    private String pid;
    private String pphoto;
    private String pname;
    private Double phyprice;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getPhyprice() {
        return phyprice;
    }

    public void setPhyprice(Double phyprice) {
        this.phyprice = phyprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", pid='" + pid + '\'' +
                ", pphoto='" + pphoto + '\'' +
                ", pname='" + pname + '\'' +
                ", phyprice=" + phyprice +
                ", num=" + num +
                '}';
    }
}

