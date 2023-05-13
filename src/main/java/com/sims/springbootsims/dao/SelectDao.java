package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.*;
import com.sims.springbootsims.mapper.SelectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public BaseBean selectTeacher(String collegeId,String majorId,String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<TeacherBean> list = selectMapper.queryTeacherList(collegeId,majorId,code, name, currentPage);

        for (TeacherBean teacherBean : list) {
            teacherBean.setPwd(selectPwd(teacherBean.getCode()));
        }

        table.setList(list);

        selectCount(collegeId,majorId,"Teacher", code, name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看教师信息成功");

        return result;
    }

    /*
     * 查询学院信息表
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学院信息
     */
    public BaseBean selectCollege(String code,String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<CollegeBean> list = selectMapper.queryCollegeList(code,name, currentPage);


        table.setList(list);

        selectCollegeCount("College", "", name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看学院信息成功");

        return result;
    }

    /*
     * 查询学院信息表
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学院信息
     */
    public BaseBean selectAllCollege() throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<CollegeBean> list = selectMapper.queryAllCollegeList();


        table.setList(list);


        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看学院信息成功");

        return result;
    }

    /*
     * 查询专业信息表
     */
    public BaseBean selectAllMajor() throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<MajorBean> list = selectMapper.queryAllMajorList();


        table.setList(list);


        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看学院信息成功");

        return result;
    }

    /*
     * 查询专业信息表
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学院信息
     */
    public BaseBean selectMajor(String code,String collegeId,String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<MajorBean> list = new ArrayList<>();
        try{

            list = selectMapper.queryMajorList(code,collegeId  ,name, currentPage);
        }catch (Exception e){
            System.out.println(e);
        }


        table.setList(list);

        selectMajorCount("Major", code, name, table);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看专业信息成功");

        return result;
    }

    /*
     * 单独查看学生信息表
     * @param code 查询账号
     * @param name 查询用户名
     * @param currentPage 当前页号
     * @return BaseBean 返回学生信息
     */
    public BaseBean selectStudentOnly(String collegeId, String majorId,String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryStudentOnlyList(collegeId,majorId,code, name, currentPage);

        table.setList(list);

        selectCount(collegeId,collegeId,"Student", code, name, table);

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
    public BaseBean selectStudent(String collegeId, String majorId,String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryStudentList(collegeId,majorId,code, name, currentPage);

        for (StudentBean studentBean : list) {
            studentBean.setPwd(selectPwd(studentBean.getCode()));
        }

        table.setList(list);

        selectCount(collegeId,majorId,"Student", code, name, table);

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
    public BaseBean selectGrade(String collegeId,String majorId,int gradeId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<GradeBean> list = selectMapper.queryGradeList(collegeId,majorId,gradeId, currentPage);

        table.setList(list);

        selectCount(collegeId,majorId,"Grade", "", "", table);

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
    public BaseBean selectClass(String collegeId,String majorId,String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<ClassBean> list = selectMapper.queryClassList(collegeId,majorId,code, name, currentPage);

        table.setList(list);

        selectCount(collegeId,majorId,"Class", "", "", table);

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
    public BaseBean selectSubject(String collegeId,String majorId,String code, String name, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<SubjectBean> list = selectMapper.querySubjectList(collegeId,majorId,code, name, currentPage);

        table.setList(list);

        selectCount(collegeId,majorId,"Subject", "", "", table);

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

        List<GradeBean> tempGradelist = selectMapper.queryGradeList(null,null,0, 0);
        int gradeId = 0;
        for (GradeBean grade : tempGradelist) {
            if (grade.getId() != gradeId) {
                gradeId = grade.getId();

                grade.setClasses(new ArrayList<>());
                list.add(grade);
            }
        }


        List<ClassBean> tempClassList = selectMapper.queryClassList(null,null,null, null, 0);

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
    public BaseBean selectTeacherClass(String collegeId, String majorId,int gradeId, int classId, int subjectId, int currentPage) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<TeacherClassBean> list = selectMapper.queryTeacherClassList(collegeId,majorId,gradeId, classId, subjectId, currentPage);

        table.setList(list);

        int count = selectMapper.queryTeacherClassCount(collegeId,majorId,gradeId, classId, subjectId);

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
    public BaseBean selectResult(String code, String name, int gradeId, int classId, int subjectId, int currentPage,String desc, String collegeId, String majorId) throws
            Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<ResultBean> list = selectMapper.queryResultList(code, name, gradeId, classId, subjectId, currentPage,desc,collegeId,majorId);

        table.setList(list);


        int count = selectMapper.queryResultCount(code, name, gradeId, classId, subjectId,collegeId,majorId);
        int best = selectMapper.queryResultCountEcharts(code, name, gradeId, classId, subjectId,2,collegeId,majorId);
        int pass = selectMapper.queryResultCountEcharts(code, name, gradeId, classId, subjectId,1,collegeId,majorId);
        int noPass = selectMapper.queryResultCountEcharts(code, name, gradeId, classId, subjectId,0,collegeId,majorId);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        List<ResultBean> columnEcharts = new ArrayList();
        if(!StringUtils.isEmpty(gradeId)|| !StringUtils.isEmpty(classId) || !StringUtils.isEmpty(subjectId)){
            columnEcharts = selectMapper.queryResultListEcharts(gradeId, classId, subjectId);
        }

        //组装饼图数据结构
        final EchartsBean echartsBeanPass = new EchartsBean();
        final EchartsBean echartsBeanNoPass = new EchartsBean();
        final EchartsBean echartsBeanBest = new EchartsBean();
        echartsBeanPass.setName("良");
        echartsBeanPass.setValue(pass);
        echartsBeanNoPass.setName("不合格");
        echartsBeanNoPass.setValue(noPass);
        echartsBeanBest.setName("优");
        echartsBeanBest.setValue(best);
        List echartsList = new ArrayList();
        echartsList.add(echartsBeanPass);
        echartsList.add(echartsBeanNoPass);
        echartsList.add(echartsBeanBest);

        List nameEcharts = new ArrayList();
        List valueEcharts = new ArrayList();
        //组装柱状图数据
        columnEcharts.stream().forEach(item ->{
            nameEcharts.add(item.getName());
            valueEcharts.add(item.getResult());
        });


        Map resultMap = new HashMap();
        Map columnEchartsMap = new HashMap();
        if(columnEcharts.size()>0){
            columnEchartsMap.put("name",nameEcharts);
            columnEchartsMap.put("value",valueEcharts);
        }else{
            columnEchartsMap.put("name","");
            columnEchartsMap.put("value","");
        }
        resultMap.put("columnEcharts",columnEchartsMap);
        resultMap.put("list",table);
        resultMap.put("echarts",echartsList);

        result.setCode(BaseBean.SUCCESS);
        result.setData(resultMap);
        result.setMessage("查看学生成绩成功");

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
    public BaseBean selectResultCheck(String code, String name, int gradeId, int classId, int subjectId, int currentPage, String collegeId, String majorId) throws
            Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<ResultBean> list = selectMapper.queryResultListCheck(code, name, gradeId, classId, subjectId, currentPage,collegeId,majorId);

        table.setList(list);


        int count = selectMapper.queryResultCount1(code, name, gradeId, classId, subjectId,collegeId,majorId);
        int pass = selectMapper.queryResultCountEcharts(code, name, gradeId, classId, subjectId,1,null,null);
        int noPass = selectMapper.queryResultCountEcharts(code, name, gradeId, classId, subjectId,0,null,null);

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        List<ResultBean> columnEcharts = new ArrayList();
        if(StringUtils.isEmpty(gradeId)|| StringUtils.isEmpty(classId) || StringUtils.isEmpty(subjectId)){
            columnEcharts = selectMapper.queryResultListEcharts(gradeId, classId, subjectId);
        }

        //组装饼图数据结构
        final EchartsBean echartsBeanPass = new EchartsBean();
        final EchartsBean echartsBeanNoPass = new EchartsBean();
        echartsBeanPass.setName("合格");
        echartsBeanPass.setValue(pass);
        echartsBeanNoPass.setName("不合格");
        echartsBeanNoPass.setValue(noPass);
        List echartsList = new ArrayList();
        echartsList.add(echartsBeanPass);
        echartsList.add(echartsBeanNoPass);

        List nameEcharts = new ArrayList();
        List valueEcharts = new ArrayList();
        //组装柱状图数据
        columnEcharts.stream().forEach(item ->{
            nameEcharts.add(item.getName());
            valueEcharts.add(item.getResult());
        });


        Map resultMap = new HashMap();
        Map columnEchartsMap = new HashMap();
        if(columnEcharts.size()>0){
            columnEchartsMap.put("name",nameEcharts);
            columnEchartsMap.put("value",valueEcharts);
        }else{
            columnEchartsMap.put("name","");
            columnEchartsMap.put("value","");
        }
        resultMap.put("columnEcharts",columnEchartsMap);
        resultMap.put("list",table);
        resultMap.put("echarts",echartsList);

        result.setCode(BaseBean.SUCCESS);
        result.setData(resultMap);
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
    public BaseBean selectAddResult(int gradeId, int classId, int subjectId, int currentPage, String collegeId, String majorId) throws Exception {
        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<StudentBean> list = selectMapper.queryAddResultList(gradeId, classId, subjectId, currentPage,collegeId,majorId);

        table.setList(list);

        int count = selectMapper.queryAddResultCount(gradeId, classId, subjectId,collegeId,majorId);

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
        cols[0] = habit.getCol1();
        cols[1] = habit.getCol2();
        cols[2] = habit.getCol3();
        cols[3] = habit.getCol4();
        cols[4] = habit.getCol5();
        cols[5] = habit.getCol6();
        cols[6] = habit.getCol7();

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
    void selectCount(String collegeId,String majorId,String tableName, String code, String name, TableBean obj) throws Exception {
        int count = selectMapper.queryCount(collegeId,majorId,tableName, code, name);

        obj.setDataCount(count);
        obj.setPageCount((count + 10 - 1) / 10);
    }

    /*
     * 获取表格行数和页数
     * @param 数据库表名
     * @param 查询账号
     * @param 查询用户名
     * @param 返回表格实体类
     */
    void selectCollegeCount(String tableName, String code, String name, TableBean obj) throws Exception {
        int count = selectMapper.queryCollegeCount(tableName, code, name);

        obj.setDataCount(count);
        obj.setPageCount((count + 10 - 1) / 10);
    }

    /*
     * 获取表格行数和页数
     * @param 数据库表名
     * @param 查询账号
     * @param 查询用户名
     * @param 返回表格实体类
     */
    void selectMajorCount(String tableName, String code, String name, TableBean obj) throws Exception {
        int count = selectMapper.queryMajorCount(tableName, code, name);

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
