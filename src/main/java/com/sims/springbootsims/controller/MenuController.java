package com.sims.springbootsims.controller;

import com.sims.springbootsims.entity.BaseBean;
import com.sims.springbootsims.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menu")
    @ResponseBody
    public BaseBean menu(String character, int currentPage, boolean getId) {
        BaseBean baseBean = new BaseBean();
        try {
            baseBean = menuService.getMenu(character, currentPage, getId);
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }

    @RequestMapping("/updateMenu")
    @ResponseBody
    public BaseBean updateMenu(String character, int menuId, boolean update) {
        BaseBean baseBean = new BaseBean();
        try {
            menuService.updateMenu(character, menuId, update);
            baseBean.setCode(BaseBean.SUCCESS);
            baseBean.setMessage("更新菜单权限成功");
        } catch (Exception e) {
            baseBean.setCode(BaseBean.FAILED);
            baseBean.setMessage(e.getMessage());
        }
        return baseBean;
    }
}
