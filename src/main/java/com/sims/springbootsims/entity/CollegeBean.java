package com.sims.springbootsims.entity;

/**
 *  学院bean
 */
public class CollegeBean {

    private int cid;

    private  String cname;

    private String cstatus;

    private String cremark;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
