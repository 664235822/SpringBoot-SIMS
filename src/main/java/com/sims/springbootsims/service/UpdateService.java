package com.sims.springbootsims.service;

import com.alibaba.fastjson2.JSON;
import com.sims.springbootsims.dao.UpdateDao;
import com.sims.springbootsims.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateService {

    @Autowired
    private UpdateDao updateDao;

    /*
     * 更新信息
     * @param tableName 数据库表名
     * @param info 要更新的信息Json字符串
     */
    public void update(String tableName, String info) throws Exception {
        switch (tableName) {
            case "Teacher":
                TeacherBean teacherInfo = JSON.parseObject(info, TeacherBean.class);
                updateDao.updateTeacher(teacherInfo);
                break;
            case "Student":
                StudentBean studentInfo = JSON.parseObject(info, StudentBean.class);
                updateDao.updateStudent(studentInfo);
                break;
            case "ClassId":
                List<StudentBean> ClassList = JSON.parseArray(info, StudentBean.class);
                updateDao.updateClassId(ClassList);
                break;
            case "GradeId":
                List<ClassBean> gradeList = JSON.parseArray(info, ClassBean.class);
                updateDao.updateGradeId(gradeList);
                break;
            case "SubjectId":
                List<SubjectBean> subjectList = JSON.parseArray(info, SubjectBean.class);
                updateDao.updateSubjectId(subjectList);
                break;
            case "AttendanceType":
                List<AttendanceBean> attendanceList = JSON.parseArray(info, AttendanceBean.class);
                updateDao.updateAttendanceType(attendanceList);
                break;
            case "Class":
                ClassBean classInfo = JSON.parseObject(info, ClassBean.class);
                updateDao.updateClass(classInfo);
                break;
            case "Subject":
                SubjectBean subjectInfo = JSON.parseObject(info, SubjectBean.class);
                updateDao.updateSubject(subjectInfo);
                break;
            case "College":
                CollegeBean collegeBean = JSON.parseObject(info, CollegeBean.class);
                updateDao.updateCollege(collegeBean);
                break;
            case "Major":
                MajorBean majorBean = JSON.parseObject(info, MajorBean.class);
                updateDao.updateMajor(majorBean);
                break;
            case "ResultUpdate":
                ResultBean resultBean = JSON.parseObject(info, ResultBean.class);
                updateDao.updateResult(resultBean);
                break;
            case "CheckResult":
                ResultBean checkUpdate = JSON.parseObject(info, ResultBean.class);
                updateDao.CheckUpdate(checkUpdate);
                break;

        }
    }
}
