package com.sims.springbootsims.service;

import com.sims.springbootsims.dao.SelectDao;
import com.sims.springbootsims.entity.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectService {

    @Autowired
    private SelectDao selectDao;

    /*
     * 获取表格信息
     * @param 表名
     * @param code 查询账号
     * @param name 查询用户名
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @param collegeId 学院id
     * @param majorId 专业id
     * @result 返回表格信息
     */
    public BaseBean select(String tableName, String code, String name, String gradeId, String classId, String subjectId, String collegeId, String majorId,String currentPage,String desc) throws Exception {
        BaseBean result = null;
        switch (tableName) {
            case "Teacher":
                result = selectDao.selectTeacher(collegeId,majorId,code, name, Integer.parseInt(currentPage));
                break;
            case "Student":
                result = selectDao.selectStudent(collegeId,majorId,code, name, Integer.parseInt(currentPage));
                break;
            case "StudentOnly":
                result = selectDao.selectStudentOnly(collegeId,majorId,code, name, Integer.parseInt(currentPage));
                break;
            case "Grade":
                result = selectDao.selectGrade(collegeId,majorId,handleGradeId(gradeId), Integer.parseInt(currentPage));
                break;
            case "Class":
                result = selectDao.selectClass(collegeId,majorId,code, name, Integer.parseInt(currentPage));
                break;
            case "Subject":
                result = selectDao.selectSubject(collegeId,majorId,code, name, Integer.parseInt(currentPage));
                break;
            case "GradeAll":
                result = selectDao.selectGradeAll();
                break;
            case "TeacherClass":
                result = selectDao.selectTeacherClass(collegeId,majorId,handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage));
                break;
            case "Result":
                result = selectDao.selectResult(code, name, handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage),desc,collegeId,majorId);
                break;
            case "ResultCheck":
                result = selectDao.selectResultCheck(code, name, handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage),collegeId,majorId);
                break;
            case "AddResult":
                result = selectDao.selectAddResult(handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage),collegeId,majorId);
                break;
            case "Attendance":
                result = selectDao.selectAttendance(code, name, handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage));
                break;
            case "AddAttendance":
                result = selectDao.selectAddAttendance(handleGradeId(gradeId), Integer.parseInt(classId), Integer.parseInt(subjectId), Integer.parseInt(currentPage));
                break;
            case "Habit":
                result = selectDao.selectHabit(code);
                break;
            case "College":
                result = selectDao.selectCollege(code,name,Integer.parseInt(currentPage));
                break;
            case "CollegeAll":
                result = selectDao.selectAllCollege();
                break;
            case "Major":
                result = selectDao.selectMajor(code,collegeId,name,Integer.parseInt(currentPage));
                break;
            case "MajorAll":
                result = selectDao.selectAllMajor();
                break;
        }

        return result;
    }

    private int handleGradeId(String gradeId) {
        if (gradeId == null || gradeId.isEmpty()) {
            return 0;
        } else {
            return Integer.parseInt(gradeId);
        }
    }
}
