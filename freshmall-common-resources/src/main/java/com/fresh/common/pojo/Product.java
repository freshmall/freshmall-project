package com.fresh.common.pojo;

import java.io.Serializable;
import java.util.Date;
public class Product implements Serializable {
    private String pid;
    private String pname;
    private String showname;
    private String paddress;
    private String pstate;
    private String pdlcode;
    private String pxlcode;
    private String pfbtime;
    private String pgrade;
    private String pphoto;
    private String pbigphoto;
    private double pscprice;
    private double phyprice;
    private int psum;
    private String putil;
    private String pintroduce;
    private Date starttime;
    private Date endtime;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getPdlcode() {
        return pdlcode;
    }

    public void setPdlcode(String pdlcode) {
        this.pdlcode = pdlcode;
    }

    public String getPxlcode() {
        return pxlcode;
    }

    public void setPxlcode(String pxlcode) {
        this.pxlcode = pxlcode;
    }

    public String getPfbtime() {
        return pfbtime;
    }

    public void setPfbtime(String pfbtime) {
        this.pfbtime = pfbtime;
    }

    public String getPgrade() {
        return pgrade;
    }

    public void setPgrade(String pgrade) {
        this.pgrade = pgrade;
    }

    public String getPphoto() {
        return pphoto;
    }

    public void setPphoto(String pphoto) {
        this.pphoto = pphoto;
    }

    public String getPbigphoto() {
        return pbigphoto;
    }

    public void setPbigphoto(String pbigphoto) {
        this.pbigphoto = pbigphoto;
    }

    public double getPscprice() {
        return pscprice;
    }

    public void setPscprice(double pscprice) {
        this.pscprice = pscprice;
    }

    public double getPhyprice() {
        return phyprice;
    }

    public void setPhyprice( double phyprice) {
        this.phyprice = phyprice;
    }

    public int getPsum() {
        return psum;
    }

    public void setPsum(int psum) {
        this.psum = psum;
    }

    public String getPutil() {
        return putil;
    }

    public void setPutil(String putil) {
        this.putil = putil;
    }

    public String getPintroduce() {
        return pintroduce;
    }

    public void setPintroduce(String pintroduce) {
        this.pintroduce = pintroduce;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getShowname() {
        return showname;
    }

    public void setShowname(String showname) {
        this.showname = showname;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", paddress='" + paddress + '\'' +
                ", pstate='" + pstate + '\'' +
                ", pdlcode='" + pdlcode + '\'' +
                ", pxlcode='" + pxlcode + '\'' +
                ", pfbtime='" + pfbtime + '\'' +
                ", pgrade='" + pgrade + '\'' +
                ", pphoto='" + pphoto + '\'' +
                ", pbigphoto='" + pbigphoto + '\'' +
                ", pscprice=" + pscprice +
                ", phyprice=" + phyprice +
                ", psum='" + psum + '\'' +
                ", putil='" + putil + '\'' +
                ", pintroduce='" + pintroduce + '\'' +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                '}';
    }
}

