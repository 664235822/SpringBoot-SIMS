package com.sims.springbootsims.dao;

import com.sims.springbootsims.entity.*;
import com.sims.springbootsims.mapper.MenuMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDao {

    @Resource
    private MenuMapper menuMapper;

    /*
     * 获取主界面菜单
     * @param character 登录角色
     * @param currentPage 当前页码
     * @return BaseBean 返回菜单信息
     */
    public BaseBean getMenu(String character) throws Exception {
        List<MenuBean> list = menuMapper.queryMenu(character);

        BaseBean result = new BaseBean();
        List<MenuParentBean> listParent = new ArrayList<>();

        for (MenuBean menu : list) {
            if (menu.getParent() == 0) {
                MenuParentBean parent = new MenuParentBean();
                parent.setMenuId(menu.getMenuId());
                parent.setMenuName(menu.getMenuName());
                parent.setItems(new ArrayList<MenuItemBean>());
                listParent.add(parent);
            } else {
                MenuItemBean item = new MenuItemBean();
                item.setMenuId(menu.getMenuId());
                item.setMenuName(menu.getMenuName());
                item.setUrl(menu.getUrl());
                item.setIcon(menu.getIcon());

                for (int i = 0; i < (list).size(); i++) {
                    if (listParent.get(i).getMenuId() == menu.getParent()) {
                        listParent.get(i).getItems().add(item);
                        break;
                    }
                }
            }
        }

        result.setCode(BaseBean.SUCCESS);
        result.setData(listParent);
        result.setMessage("查看菜单成功");

        return result;
    }

    /*
     * 查看菜单权限表
     * @param 当前页码
     * @return BaseBean 返回菜单权限表
     */
    public BaseBean getMenuTable(int currentPage) throws Exception {

        BaseBean result = new BaseBean();
        TableBean table = new TableBean();
        List<MenuBean> list = menuMapper.queryMenuTable(currentPage);

        table.setList(list);

        int count = menuMapper.queryMenuCount();

        table.setDataCount(count);
        table.setPageCount((count + 10 - 1) / 10);

        result.setCode(BaseBean.SUCCESS);
        result.setData(table);
        result.setMessage("查看菜单成功");

        return result;
    }

    /*
     * 获取菜单权限Id
     * @param character 登录角色
     * @return BaseBean 返回菜单Id信息
     */
    public BaseBean getMenuId(String character) throws Exception {
        BaseBean result = new BaseBean();
        List<Integer> list = menuMapper.queryMenuId(character);

        result.setCode(BaseBean.SUCCESS);
        result.setData(list);
        result.setMessage("查看菜单Id成功");

        return result;
    }

    /*
     * 更新菜单权限
     * @param 登录角色
     * @param menuId 菜单编号
     * @param update 更新行为
     */
    public void updateMenu(String character, int menuId, boolean update) throws Exception {
        if (update) {
            menuMapper.insertMenu(character, menuId);
        } else {
            menuMapper.deleteMenu(character, menuId);
        }
    }
}
