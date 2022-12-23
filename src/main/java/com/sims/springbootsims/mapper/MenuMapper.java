package com.sims.springbootsims.mapper;

import com.sims.springbootsims.entity.MenuBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    public List<MenuBean> queryMenu(String character);

    public List<MenuBean> queryMenuTable(int currentPage);

    public int queryMenuCount();

    public List<Integer> queryMenuId(String character);

    public void insertMenu(String character, int menuId);

    public void deleteMenu(String character, int menuId);
}
