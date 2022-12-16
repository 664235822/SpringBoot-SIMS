package com.sims.springbootsims.controller;

import com.alibaba.fastjson2.JSON;
import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeleteController {

    @Autowired
    private DeleteService deleteService;

    @RequestMapping("/delete")
    @ResponseBody
    public BaseBean delete(String tableName, String codeList) {
        BaseBean baseBean = new BaseBean();
        try {
            List<Integer> codeListObj = JSON.parseObject(codeList, List.class);
            deleteService.delete(tableName, codeListObj);
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("删除信息成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
