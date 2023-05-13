package com.sims.springbootsims.entity;

/**
  专业管理bean
 */
public class MajorBean {

    private int mid;

    private String mname;

    private String mstatus;

    private String mremark;

    private String cid;

    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public String getMremark() {
        return mremark;
    }

    public void setMremark(String mremark) {
        this.mremark = mremark;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
