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

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPwd(selectPwd(list.get(i).getCode()));
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

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setPwd(selectPwd(list.get(i).getCode()));
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
    public BaseBean selectGrade(String gradeId, int currentPage) throws Exception {
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

        List<GradeBean> tempGradelist = selectMapper.queryGradeList(null, 0);
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

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == gradeId) {
                    _class.setSubjects(new ArrayList<>());
                    list.get(i).getClasses().add(_class);
                }
            }
        }

        List<TeacherClassBean> teacherClassList = new ArrayList<>();
        List<TeacherClassBean> tempTeacherClassList = selectMapper.queryTeacherClassOnlyList();
        for (TeacherClassBean teacherClass : tempTeacherClassList) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).getClasses().size(); j++) {
                    if (teacherClass.getClassId() == list.get(i).getClasses().get(j).getId()) {
                        teacherClassList.add(teacherClass);
                        break;
                    }
                }
            }
        }


        for (TeacherClassBean teacherClass : teacherClassList) {
            List<SubjectBean> tempSubjectList = selectMapper.querySubjectById(teacherClass.getSubjectId());

            for (SubjectBean subject : tempSubjectList) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < list.get(i).getClasses().size(); j++) {
                        if (list.get(i).getClasses().get(j).getId() == teacherClass.getClassId()) {
                            list.get(i).getClasses().get(j).getSubjects().add(subject);
                        }
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
//        String sql = "select at.id,st.code,st.name,gr.gradeName,cl.className,su.subjectName,att.AttendanceType,at.AttendanceTime from Attendance at " +
//                "inner join Student st on at.sId=st.id " +
//                "inner join Subject su on at.subId=su.id " +
//                "inner join Class cl on at.classId=cl.id " +
//                "inner join Grade gr on cl.gradeId=gr.id " +
//                "inner join AttendanceType att on at.AttendanceType=att.id " +
//                "where 1=1 ";
//        if (!code.isEmpty()) {
//            sql += "and st.code like '%" + code + "%' ";
//        }
//        if (!name.isEmpty()) {
//            sql += "and st.name like '%" + name + "%' ";
//        }
//        if (gradeId != 0) {
//            sql += "and gr.id='" + gradeId + "' ";
//        }
//        if (classId != 0) {
//            sql += "and cl.id='" + classId + "' ";
//        }
//        if (subjectId != 0) {
//            sql += "and su.id='" + subjectId + "' ";
//        }
//        sql += "order by id desc ";
//        if (currentPage != 0) {
//            sql += "limit " + (currentPage - 1) * 10 + ",10 ";
//        }
//        sql += ";";
//
//        ResultSet rs = querySelect(sql);
//
        BaseBean result = new BaseBean();
//        TableBean table = new TableBean();
//        List<AttendanceBean> list = new ArrayList<>();
//
//        while (rs.next()) {
//            AttendanceBean attendance = new AttendanceBean();
//            attendance.setId(rs.getInt("id"));
//            attendance.setCode(rs.getString("code"));
//            attendance.setName(rs.getString("name"));
//            attendance.setGradeName(rs.getString("gradeName"));
//            attendance.setClassName(rs.getString("className"));
//            attendance.setSubjectName(rs.getString("subjectName"));
//            attendance.setType(rs.getString("AttendanceType"));
//            attendance.setTime(rs.getDate("AttendanceTime").toString());
//
//            list.add(attendance);
//        }
//
//        table.setList(list);
//
//        sql = "select count(*) as count from Attendance at " +
//                "inner join Student st on at.sId=st.id " +
//                "inner join Subject su on at.subId=su.id " +
//                "inner join Class cl on at.classId=cl.id " +
//                "inner join Grade gr on cl.gradeId=gr.id " +
//                "inner join AttendanceType att on at.AttendanceType=att.id " +
//                "where 1=1 ";
//        if (!code.isEmpty()) {
//            sql += "and st.code like '%" + code + "%' ";
//        }
//        if (!name.isEmpty()) {
//            sql += "and st.name like '%" + name + "%' ";
//        }
//        if (gradeId != 0) {
//            sql += "and gr.id='" + gradeId + "' ";
//        }
//        if (classId != 0) {
//            sql += "and cl.id='" + classId + "' ";
//        }
//        if (subjectId != 0) {
//            sql += "and su.id='" + subjectId + "' ";
//        }
//        sql += ";";
//        rs = querySelect(sql);
//        int dataCount = 0;
//        int pageCount = 0;
//        if (rs.next()) {
//            dataCount = rs.getInt("count");
//            pageCount = (dataCount + 10 - 1) / 10;
//        }
//        table.setDataCount(dataCount);
//        table.setPageCount(pageCount);
//
//        result.setCode(BaseBean.SUCCESS);
//        result.setData(table);
//        result.setMessage("查看考勤信息成功");
//        destroy(rs);

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
     * @throws SQLException
     */
    public BaseBean selectAddAttendance(int gradeId, int classId, int subjectId, int currentPage) throws Exception {
//        String sql = "select st.id,su.id subjectId,gr.gradeName,cl.id classId,cl.className,st.code,st.name,su.subjectName from Student st " +
//                "inner join Class cl on st.classId=cl.id " +
//                "inner join Grade gr on cl.gradeId=gr.id " +
//                "inner join TeacherClass tec on tec.classId=cl.id " +
//                "inner join Subject su on tec.subId=su.id " +
//                "where 1=1 ";
//        if (gradeId != 0) {
//            sql += "and gr.id='" + gradeId + "' ";
//        }
//        if (classId != 0) {
//            sql += "and cl.id='" + classId + "' ";
//        }
//        if (subjectId != 0) {
//            sql += "and su.id='" + subjectId + "' ";
//        }
//        sql += "order by id desc ";
//        if (currentPage != 0) {
//            sql += "limit " + (currentPage - 1) * 10 + ",10 ";
//        }
//        sql += ";";
//        ResultSet rs = querySelect(sql);
//
        BaseBean result = new BaseBean();
//        TableBean table = new TableBean();
//        List<AttendanceBean> list = new ArrayList<>();
//
//        while (rs.next()) {
//            AttendanceBean attendance = new AttendanceBean();
//            attendance.setsId(rs.getInt("id"));
//            attendance.setSubId(rs.getInt("subjectId"));
//            attendance.setClassId(rs.getInt("classId"));
//            attendance.setGradeName(rs.getString("gradeName"));
//            attendance.setClassName(rs.getString("className"));
//            attendance.setCode(rs.getString("code"));
//            attendance.setName(rs.getString("name"));
//            attendance.setSubjectName(rs.getString("subjectName"));
//
//            list.add(attendance);
//        }
//
//        table.setList(list);
//
//        sql = "select count(*) as count from Student st " +
//                "inner join Class cl on st.classId=cl.id " +
//                "inner join Grade gr on cl.gradeId=gr.id " +
//                "inner join TeacherClass tec on tec.classId=cl.id " +
//                "inner join Subject su on tec.subId=su.id " +
//                "where 1=1 ";
//        if (gradeId != 0) {
//            sql += "and gr.id='" + gradeId + "' ";
//        }
//        if (classId != 0) {
//            sql += "and cl.id='" + classId + "' ";
//        }
//        if (subjectId != 0) {
//            sql += "and su.id='" + subjectId + "' ";
//        }
//        sql += ";";
//        rs = querySelect(sql);
//        int dataCount = 0;
//        int pageCount = 0;
//        if (rs.next()) {
//            dataCount = rs.getInt("count");
//            pageCount = (dataCount + 10 - 1) / 10;
//        }
//        table.setDataCount(dataCount);
//        table.setPageCount(pageCount);
//
//        result.setCode(BaseBean.SUCCESS);
//        result.setData(table);
//        result.setMessage("查看添加考勤信息成功");
//        destroy(rs);

        return result;
    }

    /*
     * 查看个性化设置
     * @param code 用户名
     * @return BaseBean 返回个性化设置
     * @throws SQLException
     */
    public BaseBean selectHabit(String code) throws Exception {
//        String sql = "select * from Habit where code='" + code + "';";
//        ResultSet rs = querySelect(sql);
//
        BaseBean result = new BaseBean();
//        HabitBean habit = null;
//
//        if (rs.next()) {
//            habit = new HabitBean();
//            habit.setCode(code);
//            int[] cols = new int[7];
//            for (int i = 0; i < 7; i++) {
//                cols[i] = rs.getInt("col" + (i + 1));
//            }
//            habit.setCols(cols);
//        }
//
//        result.setCode(BaseBean.SUCCESS);
//        result.setData(habit);
//        result.setMessage("获取个性化设置成功");
//
//        destroy(rs);
        return result;
    }


    /*
     * 获取表格行数和页数
     * @param 数据库表名
     * @param 查询账号
     * @param 查询用户名
     * @param 返回表格实体类
     * @throws SQLException
     */
    void selectCount(String tableName, String code, String name, TableBean obj) throws SQLException {
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
