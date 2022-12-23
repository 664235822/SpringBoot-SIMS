package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.AttendanceBean;
import com.sims.springbootsims.entity.ResultBean;
import com.sims.springbootsims.entity.TeacherClassBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteMapper {

    public int queryTeacherId(int code);

    public TeacherClassBean queryTeacherClass(int id, int tId, int classId, int subId);

    public void deleteTeacherClassBytId(int id);

    public void deleteTeacher(int code);

    public int queryStudentId(int code);

    public ResultBean queryResult(int sId, int subId);

    public void deleteResult(int sId, int subId);

    public void deleteStudent(int code);

    public void deleteLogin(int code);

    public int queryClassId(int code);

    public void deleteTeacherClassByClassId(int id);

    public void deleteClass(int code);

    public int querySubjectId(int code);

    public void deleteTeacherClassBySubId(int id);

    public AttendanceBean queryAttendance(int id);

    public void deleteAttendance(int id);

    public void deleteSubject(int code);

    public void deleteTeacherClassById(int id);
}
