package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.InsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InsertController {

    @Autowired
    private InsertService insertService;

    @RequestMapping("/insert")
    @ResponseBody
    public BaseBean insert(String tableName, String info) {
        BaseBean baseBean = new BaseBean();
        try {
            insertService.Insert(tableName, info);
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("添加信息成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
