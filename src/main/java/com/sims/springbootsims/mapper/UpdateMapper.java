package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UpdateMapper {

    public void updateTeacher(TeacherBean teacherBean);

    public void updateStudent(StudentBean studentBean);

    public void updateClassId(String code, int classId);

    public void updateGradeId(String classCode, int gradeId);

    public void updateSubjectId(String subjectCode, int gradeId);

    public void updateAttendanceType(int id, String attendanceType);

    public void updateClass(ClassBean classBean);

    public void updateSubject(SubjectBean subjectBean);

    public void updateCollege(CollegeBean collegeBean);

    public void updateMajor(MajorBean majorBean);

    public void updateResult(ResultBean resultBean);
}
