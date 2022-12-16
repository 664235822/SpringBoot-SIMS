package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UpdateController {

    @Autowired
    private UpdateService updateService;

    @RequestMapping("/update")
    @ResponseBody
    public BaseBean update(String tableName, String info) {
        BaseBean baseBean = new BaseBean();
        try {
            updateService.update(tableName, info);
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("更新信息成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
