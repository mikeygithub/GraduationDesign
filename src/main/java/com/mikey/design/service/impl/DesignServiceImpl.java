package com.mikey.design.service.impl;

import com.mikey.design.entity.Design;
import com.mikey.design.mapper.DesignMapper;
import com.mikey.design.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:48
 * @Version 1.0
 */
@Service
public class DesignServiceImpl implements DesignService {
    @Autowired
    private DesignMapper designMapper;

    /**
     * 添加毕业设计
     * @param design
     */
    @Override
    public void addDesign(Design design) {

    }

    /**
     * 更新毕业设计
     * @param design
     */
    @Override
    public void updateDesign(Design design) {

    }

    /**
     * 删除毕业设计
     * @param designId
     */
    @Override
    public void deleteDesign(int designId) {

    }

    /**
     * 获取全部毕业设计信息
     * @return
     */
    @Override
    public List<Design> getAllDesign() {
        return null;
    }
}
