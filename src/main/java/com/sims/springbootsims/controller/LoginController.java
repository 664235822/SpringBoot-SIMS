package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.entity.LoginBean;
import com.sims.springbootsims.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    @ResponseBody
    public BaseBean login(LoginBean loginBean) {
        BaseBean baseBean = new BaseBean();
        try {
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setData(loginService.login(loginBean));
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
            loginService.changePwd(code, pwd, newPwd);
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("修改密码成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
