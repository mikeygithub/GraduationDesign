package com.mikey.design.service;

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
}
