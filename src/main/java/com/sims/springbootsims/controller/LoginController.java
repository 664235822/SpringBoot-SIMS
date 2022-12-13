package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.entity.LoginBean;
import com.sims.springbootsims.entity.StudentBean;
import com.sims.springbootsims.entity.TeacherBean;
import com.sims.springbootsims.mapper.LoginMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private LoginMapper loginMapper;

    @RequestMapping("/login")
    @ResponseBody
    public BaseBean login(LoginBean loginBean) {
        BaseBean baseBean = new BaseBean();
        try {
            LoginBean result = loginMapper.queryLogin(loginBean);
            if (result != null) {
                switch (result.getStateId()) {
                    case 1:
                        break;
                    case 2:
                        TeacherBean teacherBean = loginMapper.queryTeacher(result.getCode());
                        if (teacherBean != null) {
                            throw new Exception("获取用户名失败");
                        }
                        break;
                    case 3:
                        StudentBean studentBean = loginMapper.queryStudent(result.getCode());
                        if (studentBean != null) {
                            throw new Exception("获取用户名失败");
                        }
                        break;
                }
            } else {
                throw new Exception("登录失败，用户名和密码错误");
            }
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setData(result);
            baseBean.setMessage("登录成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }

    @RequestMapping("/changePwd")
    @ResponseBody
    public BaseBean changePwd(String code, String pwd, String newPwd) {
        BaseBean baseBean = new BaseBean();
        try {
            LoginBean result = loginMapper.queryLoginPwd(code, pwd);
            if (result != null) {
                loginMapper.updateLoginPwd(code, newPwd);
            } else {
                throw new Exception("用户名和密码错误");
            }
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("修改密码成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
