package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class SelectController {

    @Autowired
    private SelectService selectService;

    @RequestMapping("/select")
    @ResponseBody//@ResponseBody注释告诉控制器返回的对象自动序列化为 JSON
    public BaseBean select(String tableName, String code, String name, String gradeId, String classId, String subjectId, String collegeId, String majorId, String currentPage,String desc) {
        BaseBean baseBean = new BaseBean();
        try {
            baseBean = selectService.select(tableName, code, name, gradeId, classId, subjectId,collegeId, majorId,currentPage,desc);
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
            System.out.println(e.getMessage());
        }
        return baseBean;
    }



//    @RequestMapping("/select")
//    @ResponseBody
//    public BaseBean selectCollege(@RequestParam Map map) {
//        BaseBean baseBean = new BaseBean();
//        try {
//            baseBean = selectService.selectCollege(map);
//        } catch (Exception e) {
//            baseBean.setCode(BaseBean.FAILED);
//            baseBean.setMessage(e.getMessage());
//        }
//        return baseBean;
//    }


}
