package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.AttendanceBean;
import com.sims.springbootsims.entity.ResultBean;
import com.sims.springbootsims.entity.TeacherClassBean;
import com.sims.springbootsims.mapper.DeleteMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class DeleteDao {

    @Resource
    private DeleteMapper deleteMapper;

    /*
     * 删除教师信息
     * @param 要删除行的账号字段列表
     */
    public void deleteTeacher(List<String> codeList) throws Exception {
        for (String code : codeList) {
            int id = deleteMapper.queryTeacherId(code);

            TeacherClassBean teacherClassBean = deleteMapper.queryTeacherClass(0, id, 0, 0);
            if (teacherClassBean != null) {
                deleteMapper.deleteTeacherClassBytId(id);
            }

            deleteMapper.deleteTeacher(code);

            deleteMapper.deleteLogin(code);
        }
    }

    /*
     * 删除学生信息
     * @param 要删除行的账号字段列表
     */
    public void deleteStudent(List<String> codeList) throws Exception {
        for (String code : codeList) {
            int id = deleteMapper.queryStudentId(code);

            ResultBean resultBean = deleteMapper.queryResult(id, 0);
            if (resultBean != null) {
                deleteMapper.deleteResult(id, 0);
            }

            deleteMapper.deleteStudent(code);

            deleteMapper.deleteLogin(code);
        }
    }

    /*
     * 删除班级信息
     * @param 要删除行的班级编号字段列表
     */
    public void deleteClass(List<String> codeList) throws Exception {
        for (String code : codeList) {
            int id = deleteMapper.queryClassId(code);

            TeacherClassBean teacherClassBean = deleteMapper.queryTeacherClass(0, 0, id, 0);
            if (teacherClassBean != null) {
                deleteMapper.deleteTeacherClassByClassId(id);
            }

            deleteMapper.deleteClass(code);
        }
    }

    /*
     * 删除科目信息
     * @param 要删除行的班级编号字段列表
     */
    public void deleteSubject(List<String> codeList) throws Exception {
        for (String code : codeList) {
            int id = deleteMapper.querySubjectId(code);

            TeacherClassBean teacherClassBean = deleteMapper.queryTeacherClass(0, 0, 0, id);
            if (teacherClassBean != null) {
                deleteMapper.deleteTeacherClassBySubId(id);
            }

            ResultBean resultBean = deleteMapper.queryResult(0, id);
            if (resultBean != null) {
                deleteMapper.deleteResult(0, id);
            }

            AttendanceBean attendanceBean = deleteMapper.queryAttendance(id);
            if (attendanceBean != null) {
                deleteMapper.deleteAttendance(id);
            }

            deleteMapper.deleteSubject(code);
        }

    }

    /*
     * 删除教师班级科目联系
     * @param 要删除行的id字段列表
     */
    public void deleteTeacherClass(List<String> idList) throws Exception {
        for (String id : idList) {
            TeacherClassBean teacherClassBean = deleteMapper.queryTeacherClass(Integer.parseInt(id), 0, 0, 0);
            if (teacherClassBean != null) {
                deleteMapper.deleteTeacherClassById(Integer.parseInt(id));
            }
        }
    }
}
