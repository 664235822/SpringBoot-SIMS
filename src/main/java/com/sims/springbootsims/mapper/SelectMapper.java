package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectMapper {

    public List<TeacherBean> queryTeacherList(String code, String name, int currentPage);

    public List<StudentBean> queryStudentOnlyList(String code, String name, int currentPage);

    public List<StudentBean> queryStudentList(String code, String name, int currentPage);

    public List<GradeBean> queryGradeList(int gradeId, int currentPage);

    public List<ClassBean> queryClassList(String code, String name, int currentPage);

    public List<SubjectBean> querySubjectList(String code, String name, int currentPage);

    public List<TeacherClassBean> queryTeacherClassOnlyList();

    public List<SubjectBean> querySubject();

    public List<TeacherClassBean> queryTeacherClassList(int gradeId, int classId, int subjectId, int currentPage);

    public int queryTeacherClassCount(int gradeId, int classId, int subjectId);

    public List<ResultBean> queryResultList(String code, String name, int gradeId, int classId, int subjectId, int currentPage);

    public int queryResultCount(String code, String name, int gradeId, int classId, int subjectId);

    public List<StudentBean> queryAddResultList(int gradeId, int classId, int subjectId, int currentPage);

    public int queryAddResultCount(int gradeId, int classId, int subjectId);

    public List<AttendanceBean> queryAttendanceList(String code, String name, int gradeId, int classId, int subjectId,
                                                    int currentPage);

    public int queryAttendanceCount(String code, String name, int gradeId, int classId, int subjectId);

    public List<StudentBean> queryAddAttendanceList(int gradeId, int classId, int subjectId, int currentPage);

    public int queryAddAttendanceCount(int gradeId, int classId, int subjectId);

    public HabitBean queryHabit(String code);

    public LoginBean queryPwd(String code);

    public int queryCount(String tableName, String code, String name);
}
