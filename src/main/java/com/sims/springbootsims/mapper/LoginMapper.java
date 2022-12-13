package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.LoginBean;
import com.sims.springbootsims.entity.StudentBean;
import com.sims.springbootsims.entity.TeacherBean;

public interface LoginMapper {

    public LoginBean queryLogin(LoginBean loginBean);

    public TeacherBean queryTeacher(String code);

    public StudentBean queryStudent(String code);

    public LoginBean queryLoginPwd(String code, String pwd);

    public void updateLoginPwd(String code, String newPwd);
}
