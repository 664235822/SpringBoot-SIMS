package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelectMapper {

    public List<TeacherBean> queryTeacherList(String code, String name, int currentPage);

    public List<StudentBean> queryStudentOnlyList(String code, String name, int currentPage);

    public List<StudentBean> queryStudentList(String code, String name, int currentPage);

    public List<GradeBean> queryGradeList(String gradeId, int currentPage);

    public List<ClassBean> queryClassList(String code, String name, int currentPage);

    public List<SubjectBean> querySubjectList(String code, String name, int currentPage);

    public List<TeacherClassBean> queryTeacherClassOnlyList();

    public List<SubjectBean> querySubjectById(int id);

    public List<TeacherClassBean> queryTeacherClassList(int gradeId, int classId, int subjectId, int currentPage);

    public int queryTeacherClassCount(int gradeId, int classId, int subjectId);

    public LoginBean queryPwd(String code);

    public int queryCount(String tableName, String code, String name);
}
