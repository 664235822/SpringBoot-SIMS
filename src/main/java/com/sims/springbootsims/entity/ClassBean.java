package com.sims.springbootsims.entity;

import java.util.List;

/*
 * 班级信息实体类
 */
public class ClassBean {

    //班级id
    private int id;
    //班级编号
    private String classCode;
    //班级名
    private String className;
    //创建人
    private String createMessage;
    //创建时间
    private String createTime;
    //年级Id
    private int gradeId;
    //科目列表
    private List<SubjectBean> subjects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCreateMessage() {
        return createMessage;
    }

    public void setCreateMessage(String createMessage) {
        this.createMessage = createMessage;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public List<SubjectBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectBean> subjects) {
        this.subjects = subjects;
    }
}
