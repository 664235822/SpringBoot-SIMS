package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InsertMapper {

    public void insertLogin(String code, String pwd, int stateId);

    public void insertTeacher(TeacherBean teacherBean);

    public void insertCollege(CollegeBean collegeBean);

    public void insertMajor(MajorBean majorBean);

    public void insertStudent(StudentBean studentBean);

    public TeacherClassBean queryTeacherClass(int teacherId, int classId, int subjectId);

    public void deleteTeacherClass(int teacherId, int classId, int subjectId);

    public void insertTeacherClass(TeacherClassBean teacherClassBean);

    public List<Integer> queryGradeCode();

    public void insertGrade(GradeBean gradeBean);

    public void insertClass(ClassBean classBean);

    public List<Integer> querySubjectCode();

    public void insertSubject(SubjectBean subjectBean);

    public void insertResult(ResultBean resultBean);

    public void insertAttendance(AttendanceBean attendanceBean);

    public HabitBean queryHabit(String code);

    public void deleteHabit(String code);

    public void insertHabit(HabitBean habitBean);
}
