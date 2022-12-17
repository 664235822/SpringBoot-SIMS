package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.LoginBean;
import com.sims.springbootsims.entity.StudentBean;
import com.sims.springbootsims.entity.TeacherBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    public LoginBean queryLogin(LoginBean loginBean);

    public TeacherBean queryTeacher(String code);

    public StudentBean queryStudent(String code);

    public LoginBean queryLoginPwd(String code, String pwd);

    public void updateLoginPwd(String code, String newPwd);
}
