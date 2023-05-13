package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SelectMapper {

    public List<TeacherBean> queryTeacherList(String collegeId,String majorId,String code, String name, int currentPage);

    public List<CollegeBean> queryCollegeList(String code,String name, int currentPage);

    public List<CollegeBean> queryAllCollegeList();

    public List<MajorBean> queryAllMajorList();

    public List<MajorBean> queryMajorList(String code,String collegeId,String name, int currentPage);

    public List<StudentBean> queryStudentOnlyList(String collegeId, String majorId,String code, String name, int currentPage);
    public List<String> queryStudentOnlyList9(String collegeId, String majorId,String code, String name, int currentPage);

    public List<StudentBean> queryStudentList(String collegeId, String majorId,String code, String name, int currentPage);

    public List<GradeBean> queryGradeList(String collegeId,String majorId,int gradeId, int currentPage);

    public List<ClassBean> queryClassList(String collegeId,String majorId,String code, String name, int currentPage);

    public List<SubjectBean> querySubjectList(String collegeId,String majorId,String code, String name, int currentPage);

    public List<TeacherClassBean> queryTeacherClassOnlyList();

    public List<SubjectBean> querySubject();

    public List<TeacherClassBean> queryTeacherClassList(String collegeId, String majorId,int gradeId, int classId, int subjectId, int currentPage);

    public int queryTeacherClassCount(String collegeId, String majorId,int gradeId, int classId, int subjectId);

    public List<ResultBean> queryResultList(String code, String name, int gradeId, int classId, int subjectId, int currentPage,String desc, String collegeId, String majorId);

    public List<ResultBean> queryResultListCheck(String code, String name, int gradeId, int classId, int subjectId, int currentPage, String collegeId, String majorId);

    public List<ResultBean> queryResultListEcharts(int gradeId, int classId, int subjectId);

    public int queryResultCount(String code, String name, int gradeId, int classId, int subjectId, String collegeId, String majorId);
    public int queryResultCount1(String code, String name, int gradeId, int classId, int subjectId, String collegeId, String majorId);

    public int queryResultCountEcharts(String code, String name, int gradeId, int classId, int subjectId,int pass,String collegeId, String majorId);

    public List<StudentBean> queryAddResultList(int gradeId, int classId, int subjectId, int currentPage, String collegeId, String majorId);

    public int queryAddResultCount(int gradeId, int classId, int subjectId, String collegeId, String majorId);

    public List<AttendanceBean> queryAttendanceList(String code, String name, int gradeId, int classId, int subjectId,
                                                    int currentPage);

    public int queryAttendanceCount(String code, String name, int gradeId, int classId, int subjectId);

    public List<StudentBean> queryAddAttendanceList(int gradeId, int classId, int subjectId, int currentPage);

    public int queryAddAttendanceCount(int gradeId, int classId, int subjectId);

    public HabitBean queryHabit(String code);

    public LoginBean queryPwd(String code);

    public int queryCount(String collegeId,String majorId,String tableName, String code, String name);

    public int queryCollegeCount(String tableName, String code, String name);

    public int queryMajorCount(String tableName, String code, String name);
}
