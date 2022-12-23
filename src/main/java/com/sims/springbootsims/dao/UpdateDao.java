package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.*;
import com.sims.springbootsims.mapper.UpdateMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UpdateDao {

    @Resource
    private UpdateMapper updateMapper;

    /*
     * 更新教师信息
     * @param teacherInfo 要更新的教师信息
     */
    public void updateTeacher(TeacherBean teacherInfo) throws Exception {
        updateMapper.updateTeacher(teacherInfo);
    }

    /*
     * 更新学生信息
     * @param studentInfo 要更新的学生信息
     */
    public void updateStudent(StudentBean studentInfo) throws Exception {
        updateMapper.updateStudent(studentInfo);
    }

    /*
     * 学生转班
     * @param classList 要转班的学生信息列表
     */
    public void updateClassId(List<StudentBean> classList) throws Exception {
        for (StudentBean studentBean : classList) {
            updateMapper.updateClassId(studentBean.getCode(), studentBean.getClassId());
        }
    }

    /*
     * 班级转年级
     * @param classList 要转班的学生信息列表
     */
    public void updateGradeId(List<ClassBean> gradeList) throws Exception {
        for (ClassBean classBean : gradeList) {
            updateMapper.updateGradeId(classBean.getClassCode(), classBean.getGradeId());
        }
    }

    /*
     * 科目转年级
     * @param gradeList 要转年级的科目信息列表
     */
    public void updateSubjectId(List<SubjectBean> gradeList) throws Exception {
        for (SubjectBean subjectBean : gradeList) {
            updateMapper.updateSubjectId(subjectBean.getSubjectCode(), subjectBean.getGradeId());
        }
    }

    /*
     * 更新考勤状态
     * @param attendanceList 要更新的考勤信息列表
     */
    public void updateAttendanceType(List<AttendanceBean> attendanceList) throws Exception {
        for (AttendanceBean attendanceBean : attendanceList) {
            updateMapper.updateAttendanceType(attendanceBean.getId(), attendanceBean.getType());
        }
    }

    /*
     * 更新班级名
     * @param classInfo 要更新的班级信息
     */
    public void updateClass(ClassBean classInfo) throws Exception {
        updateMapper.updateClass(classInfo);
    }

    /*
     * 更新科目名
     * @param 要更新的科目信息
     */
    public void updateSubject(SubjectBean subjectInfo) throws Exception {
        updateMapper.updateSubject(subjectInfo);
    }
}
