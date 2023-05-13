package com.sims.springbootsims.entity;

/*
 * 成绩实体类
 */
public class ResultBean {

    //成绩id
    private int id;
    //科目id
    private int subId;
    //学生id
    private int sId;
    //成绩
    private double result;
    //年级名称
    private String gradeName;
    //班级名称
    private String className;
    //学生学号
    private String code;
    //学生名称
    private String name;
    //时间
    private String time;
    //科目名称
    private String subjectName;
    //提交修改成绩老师id
    private String tid;
    //状态
    private String status;
    //修改成绩值
    private double actualResult;

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    //是否同意修改 1 同意  2 不同意
    private String target;

    private String tName;

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getActualResult() {
        return actualResult;
    }

    public void setActualResult(double actualResult) {
        this.actualResult = actualResult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubId() {
        return subId;
    }

    public void setSubId(int subId) {
        this.subId = subId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
