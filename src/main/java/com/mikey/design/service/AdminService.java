package com.mikey.design.service;

import com.mikey.design.entity.Admin;

/**
 * @author Mikey
 * @Title: 管理员
 * @Description: 统计志愿填报，总学生人数，已经填报人数，未填报人数，教师人数，毕业设计题目总数
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:44
 * @Version 1.0
 */
public interface AdminService {
    /**
     * 统计教师人数
     * @return
     */
    public long getTeacherNum();

    /**
     * 统计学生人数
     * @return
     */
    public long getStudentNum();

    /**
     * 统计已经填报志愿的学生个数
     * @return
     */
    public long alreadyFillWishStudetnNum() ;

    /**
     * 统计未填报志愿的学生个数
     * @return
     */
    public long notFillWishStudetnNum() ;

    /**
     * 统计所有毕设题目总数
     * @return
     */
    public long allTitleNum() ;
    /**
     * 查看信息、登入
     * @param AdminId
     * @return
     */
    public Admin getAdmin(int AdminId);

    /**
     * 更新数据
     * @param admin
     */
    public void updataAdmin(Admin admin);
}
