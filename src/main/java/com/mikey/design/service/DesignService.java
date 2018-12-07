package com.mikey.design.service;

import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Design;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:45
 * @Version 1.0
 */
public interface DesignService {
    public void addDesign(Design design);
    public void updateDesign(Design design);
    public void deleteDesign(int designId);
    public List<Design> getAllDesign();
    PageInfo getDesignByPage(int currentPage, int pageSize);
    PageInfo getSelfDesignByPage(int teacherId,int currentPage, int pageSize);//教师获取自己的毕设题目列表
}
