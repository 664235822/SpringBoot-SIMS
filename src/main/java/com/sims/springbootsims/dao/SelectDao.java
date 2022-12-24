package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.*;
import com.sims.springbootsims.mapper.SelectMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SelectDao {

    @Resource
    private SelectMapper selectMapper;

    /*
     * 查询教师信息表
     * @param code 查询账号
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回教师信息
     */
    public BaseBean selectTeacher(String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<TeacherBean> list = selectMapper.queryTeacherList(code, name, currentPage);

        for (TeacherBean teacherBean : list) {
            teacherBean.setPwd(selectPwd(teacherBean.getCode()));
        }

        table.setList(list);

        selectCount("Teacher", code, name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看教师信息成功");

        return result;
    }

    /*
     * 单独查看学生信息表
     * @param code 查询账号
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学生信息
     */
    public BaseBean selectStudentOnly(String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryStudentOnlyList(code, name, currentPage);

        table.setList(list);

        selectCount("Student", code, name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("单独查看学生信息成功");

        return result;
    }

    /*
     * 查看学生信息表
     * @param code 查询账号
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学生信息
     */
    public BaseBean selectStudent(String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryStudentList(code, name, currentPage);

        for (StudentBean studentBean : list) {
            studentBean.setPwd(selectPwd(studentBean.getCode()));
        }

        table.setList(list);

        selectCount("Student", code, name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看学生信息成功");

        return result;
    }

    /*
     * 获取年级信息
     * @param 年级Id
     * @param currentPage 当前页号
     * @return BaseBean 返回年级信息
     */
    public BaseBean selectGrade(int gradeId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<GradeBean> list = selectMapper.queryGradeList(gradeId, currentPage);

        table.setList(list);

        selectCount("Grade", "", "", table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看年级信息成功");

        return result;
    }

    /*
     * 获取班级信息
     * @param code 查询班级编号
     * @param name 查询班级名
     * @param currentPage 当前页号
     * @return BaseBean 返回班级信息
     */
    public BaseBean selectClass(String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<ClassBean> list = selectMapper.queryClassList(code, name, currentPage);

        table.setList(list);

        selectCount("Class", "", "", table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看班级信息成功");

        return result;
    }

    /*
     * 获取科目信息
     * @param code 查询科目编号
     * @param name 查询科目名
     * @param currentPage 当前页号
     * @return BaseBean 返回班级信息
     * @throws SQLException
     */
    public BaseBean selectSubject(String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<SubjectBean> list = selectMapper.querySubjectList(code, name, currentPage);

        table.setList(list);

        selectCount("Subject", "", "", table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看科目信息成功");

        return result;
    }

    /*
     * 获取年级班级科目信息
     * @return BaseBean 返回年级班级科目信息
     */
    public BaseBean selectGradeAll() throws Exception {
        BaseBean result = new BaseBean();
        List<GradeBean> list = new ArrayList<>();

        List<GradeBean> tempGradelist = selectMapper.queryGradeList(0, 0);
        int gradeId = 0;
        for (GradeBean grade : tempGradelist) {
            if (grade.getId() != gradeId) {
                gradeId = grade.getId();

                grade.setClasses(new ArrayList<>());
                list.add(grade);
            }
        }


        List<ClassBean> tempClassList = selectMapper.queryClassList(null, null, 0);

        gradeId = 0;
        for (ClassBean _class : tempClassList) {
            if (_class.getGradeId() != gradeId) {
                gradeId = _class.getGradeId();
            }

            for (GradeBean gradeBean : list) {
                if (gradeBean.getId() == gradeId) {
                    _class.setSubjects(new ArrayList<>());
                    gradeBean.getClasses().add(_class);
                }
            }
        }

        List<TeacherClassBean> teacherClassList = new ArrayList<>();
        List<TeacherClassBean> tempTeacherClassList = selectMapper.queryTeacherClassOnlyList();
        for (TeacherClassBean teacherClass : tempTeacherClassList) {
            for (GradeBean gradeBean : list) {
                for (int j = 0; j < gradeBean.getClasses().size(); j++) {
                    if (teacherClass.getClassId() == gradeBean.getClasses().get(j).getId()) {
                        teacherClassList.add(teacherClass);
                        break;
                    }
                }
            }
        }

        List<SubjectBean> tempSubjectList = selectMapper.querySubject();
        for (GradeBean gradeBean : list) {
            for (ClassBean classBean : gradeBean.getClasses()) {
                classBean.setSubjects(new ArrayList<>());
                for (SubjectBean subjectBean : tempSubjectList) {
                    if (subjectBean.getGradeId() == gradeBean.getId()) {
                        classBean.getSubjects().add(subjectBean);
                    }
                }
            }
        }

        result.setCode(BaseBean.SUCCESS);
        result.setData(list);
        result.setMessage("获取年级班级科目信息成功");

        return result;
    }

    /*
     * 获取教师科目信息
     * @param gradeId 年级编号
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @return BaseBean 返回教师科目信息
     */
    public BaseBean selectTeacherClass(int gradeId, int classId, int subjectId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<TeacherClassBean> list = selectMapper.queryTeacherClassList(gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryTeacherClassCount(gradeId, classId, subjectId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看教师科目信息成功");

        return result;
    }

    /*
     * 查看学生成绩表
     * @param code 查询账号
     * @param name 查询用户名
     * @param gradeId 年级编号
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @return BaseBean 返回学生成绩信息
     */
    public BaseBean selectResult(String code, String name, int gradeId, int classId, int subjectId, int currentPage) throws
            Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<ResultBean> list = selectMapper.queryResultList(code, name, gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryResultCount(code, name, gradeId, classId, subjectId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看学生成绩成功");

        return result;
    }

    /*
     * 查看添加学生成绩信息
     * @param gradeId 年级编号
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @return BaseBean 返回添加学生成绩信息
     */
    public BaseBean selectAddResult(int gradeId, int classId, int subjectId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryAddResultList(gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryAddResultCount(gradeId, classId, subjectId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看添加学生成绩信息成功");

        return result;
    }

    /*
     * 查看考勤信息
     * @param code 查询学生编号
     * @param name 查询学生姓名
     * @param gradeId 年级编号
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @return BaseBean 返回考勤信息
     */
    public BaseBean selectAttendance(String code, String name, int gradeId, int classId, int subjectId,
                                     int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<AttendanceBean> list = selectMapper.queryAttendanceList(code, name, gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryAttendanceCount(code, name, gradeId, classId, subjectId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看考勤信息成功");

        return result;
    }

    /*
     * 查看添加考勤信息
     * @param code 查询学生编号
     * @param name 查询学生姓名
     * @param gradeId 年级编号
     * @param classId 班级编号
     * @param subjectId 科目编号
     * @param currentPage 当前页号
     * @return BaseBean 返回考勤信息
     */
    public BaseBean selectAddAttendance(int gradeId, int classId, int subjectId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryAddAttendanceList(gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryAddAttendanceCount(gradeId, classId, subjectId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看添加考勤信息成功");

        return result;
    }

    /*
     * 查看个性化设置
     * @param code 用户名
     * @return BaseBean 返回个性化设置
     */
    public BaseBean selectHabit(String code) throws Exception {
        BaseBean result = new BaseBean();
        HabitBean habit = selectMapper.queryHabit(code);

        int[] cols = new int[8];
        cols[0] = habit.getCol0();
        cols[1] = habit.getCol1();
        cols[2] = habit.getCol2();
        cols[3] = habit.getCol3();
        cols[4] = habit.getCol4();
        cols[5] = habit.getCol5();
        cols[6] = habit.getCol6();
        cols[7] = habit.getCol7();

        habit.setCols(cols);

        result.setCode(BaseBean.SUCCESS);
        result.setData(habit);
        result.setMessage("获取个性化设置成功");

        return result;
    }


    /*
     * 获取表格行数和页数
     * @param 数据库表名
     * @param 查询账号
     * @param 查询用户名
     * @param 返回表格实体类
     */
    void selectCount(String tableName, String code, String name, TableBean obj) throws Exception {
        int count = selectMapper.queryCount(tableName, code, name);

        obj.setDataCount(count);
        obj.setPageCount((count + 10 - 1) / 10);
    }

    /*
     * 获取密码
     * @param 查询账号
     * @return String 密码
     */
    String selectPwd(String code) throws Exception {
        LoginBean loginBean = selectMapper.queryPwd(code);
        return loginBean.getPwd();
    }
}
