package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.AttendanceBean;
import com.sims.springbootsims.entity.ResultBean;
import com.sims.springbootsims.entity.TeacherClassBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteMapper {

    public int queryTeacherId(String code);

    public TeacherClassBean queryTeacherClass(int id, int tId, int classId, int subId);

    public void deleteTeacherClassBytId(int id);


    public void deleteCollege(int id);

    public void deleteMajor(int id);

    public void deleteTeacher(String code);

    public int queryStudentId(String code);

    public ResultBean queryResult(int sId, int subId);

    public void deleteResult(int sId, int subId);

    public void deleteStudent(String code);

    public void deleteLogin(String code);

    public int queryClassId(String code);

    public void deleteTeacherClassByClassId(int id);

    public void deleteClass(String code);

    public int querySubjectId(String code);

    public void deleteTeacherClassBySubId(int id);

    public AttendanceBean queryAttendance(int id);

    public void deleteAttendance(int id);

    public void deleteSubject(String code);

    public void deleteTeacherClassById(int id);
}
