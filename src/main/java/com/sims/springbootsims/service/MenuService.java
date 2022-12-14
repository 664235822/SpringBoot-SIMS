package com.sims.springbootsims.service;

import com.sims.springbootsims.dao.MenuDao;
import com.sims.springbootsims.entity.BaseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    /*
     * 获取主界面菜单
     * @param character 登录角色
     * @param currentPage 当前页号
     * @param getId 是否只返回页码id
     * @return BaseBean 返货菜单信息
     */
    public BaseBean getMenu(String character, int currentPage, boolean getId) throws Exception {
        BaseBean result = null;
        if (!getId) {
            if (currentPage == 0) {
                result = menuDao.getMenu(character);
            } else {
                result = menuDao.getMenuTable(currentPage);
            }
        } else {
            result = menuDao.getMenuId(character);
        }
        return result;
    }

    /*
     * 更新菜单权限
     * @param 登录角色
     * @param menuId 菜单编号
     * @param update 更新行为
     */
    public void updateMenu(String character, int menuId, boolean update) throws Exception {
        menuDao.updateMenu(character, menuId, update);
    }
}
