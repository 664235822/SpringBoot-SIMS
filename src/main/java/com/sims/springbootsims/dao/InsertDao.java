package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.*;
import com.sims.springbootsims.mapper.InsertMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class InsertDao {

    @Resource
    private InsertMapper insertMapper;

    /*
     * 添加教师信息
     * @param info 教师信息
     */
    public void insertTeacher(TeacherBean info) throws Exception {
        insertMapper.insertLogin(info.getCode(), info.getPwd(), 2);
        insertMapper.insertTeacher(info);
    }

    /*
     * 添加学生信息
     * @param info 学生信息
     */
    public void insertStudent(StudentBean info) throws Exception {
        insertMapper.insertLogin(info.getCode(), info.getPwd(), 3);
        insertMapper.insertStudent(info);
    }

    /*
     * 给科目分配老师
     * @param info 要分配的教师科目信息
     */
    public void insertTeacherClass(TeacherClassBean info) throws Exception {
        TeacherClassBean teacherClass = insertMapper.queryTeacherClass(info.getTeacherId(), info.getClassId(), info.getSubjectId());

        if (teacherClass != null) {
            insertMapper.deleteTeacherClass(info.getTeacherId(), info.getClassId(), info.getSubjectId());
        }

        insertMapper.insertTeacherClass(info);
    }

    /*
     * 给老师分配科目
     * @param info 要分配的教师科目信息
     */
    public void insertClassTeacher(TeacherClassBean info) throws Exception {
        TeacherClassBean teacherClass = insertMapper.queryTeacherClass(0, info.getClassId(), info.getSubjectId());
        if (teacherClass != null) {
            insertMapper.deleteTeacherClass(0, info.getClassId(), info.getSubjectId());
        }

        insertMapper.insertTeacherClass(info);
    }

    /*
     * 添加年级信息
     * @param info 年级信息
     */
    public void insertGrade(GradeBean info) throws Exception {
        int gradeCode = insertMapper.queryGradeCode();
        gradeCode++;
        info.setGradeCode(String.valueOf(gradeCode));

        insertMapper.insertGrade(info);
    }

    /*
     * 添加班级信息
     * @param info 班级信息
     */
    public void insertClass(ClassBean info) throws Exception {
        insertMapper.insertClass(info);
    }

    /*
     * 添加科目信息
     * @param info 科目信息
     */
    public void insertSubject(SubjectBean info) throws Exception {
        int subjectCode = insertMapper.querySubjectCode();
        subjectCode++;
        info.setSubjectCode(String.valueOf(subjectCode));

        insertMapper.insertSubject(info);
    }

    /*
     * 添加学生成绩
     * @param 学生成绩信息列表
     */
    public void insertResult(List<ResultBean> resultList) throws Exception {
        for (ResultBean info : resultList) {
            if (info.getsId() == 0 || info.getSubId() == 0)
                continue;

            insertMapper.insertResult(info);
        }
    }

    /*
     * 添加考勤信息
     * @param 考勤信息列表
     */
    public void insertAttendance(List<AttendanceBean> attendanceList) throws Exception {
        for (AttendanceBean info : attendanceList) {
            if (info.getsId() == 0 || info.getSubId() == 0 || info.getClassId() == 0)
                continue;

            insertMapper.insertAttendance(info);
        }
    }

    /*
     * 添加修改首页个性化设置
     * @param info 个性化设置信息
     */
    public void insertHabit(HabitBean info) throws Exception {
        HabitBean habitBean = insertMapper.queryHabit(info.getCode());
        if (habitBean != null) {
            insertMapper.deleteHabit(info.getCode());
        }

        insertMapper.insertHabit(info);
    }
}
