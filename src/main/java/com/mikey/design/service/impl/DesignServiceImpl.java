package com.mikey.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mikey.design.entity.Design;
import com.mikey.design.entity.DesignExample;
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
        designMapper.insert(design);
    }

    /**
     * 更新毕业设计
     * @param design
     */
    @Override
    public void updateDesign(Design design) {
        designMapper.updateByPrimaryKey(design);
    }

    /**
     * 删除毕业设计
     * @param designId
     */
    @Override
    public void deleteDesign(int designId) {
        designMapper.deleteByPrimaryKey(designId);
    }

    /**
     * 获取全部毕业设计信息
     * @return
     */
    @Override
    public List<Design> getAllDesign() {
        return designMapper.selectByExample(null);
    }

    /**
     * 分页查询毕业设计题目
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getDesignByPage(int currentPage, int pageSize) {

        PageHelper.startPage(currentPage,pageSize);

        List<Design> allBook=designMapper.selectByExample(null);

        PageInfo pageData = new PageInfo(allBook, pageSize);

        return pageData;
    }

    /**
     * 通过教师id获取他发布的题目
     * @param teacherId
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo getSelfDesignByPage(int teacherId, int currentPage, int pageSize) {

        DesignExample designExample=new DesignExample();

        DesignExample.Criteria criteria = designExample.createCriteria();

        criteria.andDesignOfTeacherEqualTo(teacherId);

        PageHelper.startPage(currentPage,pageSize);

        List<Design> allBook=designMapper.selectByExample(designExample);

        PageInfo pageData = new PageInfo(allBook, pageSize);

        return pageData;
    }
}
