package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SelectController {

    @Autowired
    private SelectService selectService;

    @RequestMapping("/select")
    @ResponseBody
    public BaseBean select(String tableName, String code, String name, String gradeId, String classId, String subjectId, String currentPage) {
        BaseBean baseBean = new BaseBean();
        try {
            baseBean = selectService.select(tableName, code, name, gradeId, classId, subjectId, currentPage);
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
