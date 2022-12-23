package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.ClassBean;
import com.sims.springbootsims.entity.StudentBean;
import com.sims.springbootsims.entity.SubjectBean;
import com.sims.springbootsims.entity.TeacherBean;
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
}
