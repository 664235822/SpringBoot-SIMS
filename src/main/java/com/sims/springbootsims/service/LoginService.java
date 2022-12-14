package com.sims.springbootsims.service;

import com.sims.springbootsims.dao.LoginDao;
import com.sims.springbootsims.entity.LoginBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;

    /*
     * 用户登录
     * @param code 用户名
     * @param pwd 密码
     * @param stateId 用户类型
     * @return BaseBean 返回登录信息
     */
    public LoginBean login(LoginBean loginBean) throws Exception {
        return loginDao.login(loginBean);
    }

    /*
     * 修改密码
     * @param code 用户名
     * @param pwd 旧密码
     * @param newPwd 新密码
     */
    public void changePwd(String code, String pwd, String newPwd) throws Exception {
        loginDao.changePwd(code, pwd, newPwd);
    }
}
