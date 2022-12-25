package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.LoginBean;
import com.sims.springbootsims.entity.StudentBean;
import com.sims.springbootsims.entity.TeacherBean;
import com.sims.springbootsims.mapper.LoginMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class LoginDao {

    @Resource
    private LoginMapper loginMapper;

    /*
     * 用户登录
     * @param code 用户名
     * @param pwd 密码
     * @param stateId 用户类型
     * @return LoginBean 返回登录信息
     */
    public LoginBean login(LoginBean loginBean) throws Exception {
        LoginBean result = loginMapper.queryLogin(loginBean);
        if (result != null) {
            switch (result.getStateId()) {
                case 1:
                    break;
                case 2:
                    TeacherBean teacherBean = loginMapper.queryTeacher(result.getCode());
                    if (teacherBean == null) {
                        throw new Exception("获取用户名失败");
                    }
                    break;
                case 3:
                    StudentBean studentBean = loginMapper.queryStudent(result.getCode());
                    if (studentBean == null) {
                        throw new Exception("获取用户名失败");
                    }
                    break;
            }
        } else {
            throw new Exception("登录失败，用户名和密码错误");
        }

        loginBean.setUsername(loginBean.getCode());

        return loginBean;
    }

    /*
     * 修改密码
     * @param code 用户名
     * @param pwd 旧密码
     * @param newPwd 新密码
     */
    public void changePwd(String code, String pwd, String newPwd) throws Exception {
        LoginBean result = loginMapper.queryLoginPwd(code, pwd);
        if (result != null) {
            loginMapper.updateLoginPwd(code, newPwd);
        } else {
            throw new Exception("用户名和密码错误");
        }
    }
}
