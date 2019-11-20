package com.fresh.common.pojo;

import java.io.Serializable;

public class Cart implements Serializable {

    private Integer id;
    private String userId;
    private String pid;
    private String pphoto;
    private String pname;
    private Double pscprice;
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

    public Double getPscprice() {
        return pscprice;
    }

    public void setPscprice(Double pscprice) {
        this.pscprice = pscprice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
