package com.sims.springbootsims.service;

import com.sims.springbootsims.dao.DeleteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteService {

    @Autowired
    private DeleteDao deleteDao;

    /*
     * 删除信息
     * @param 数据库表名
     * @param 要删除行的账号字段列表
     */
    public void delete(String tableName, List<Integer> codeList) throws Exception {
        switch (tableName) {
            case "Teacher":
                deleteDao.deleteTeacher(codeList);
                break;
            case "Student":
                deleteDao.deleteStudent(codeList);
                break;
            case "Class":
                deleteDao.deleteClass(codeList);
                break;
            case "Subject":
                deleteDao.deleteSubject(codeList);
                break;
            case "TeacherClass":
                deleteDao.deleteTeacherClass(codeList);
                break;
        }
    }
}
