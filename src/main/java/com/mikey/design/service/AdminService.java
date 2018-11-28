package com.mikey.design.service;

import com.mikey.design.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:44
 * @Version 1.0
 */
public interface AdminService {
    /**
     * 统计教师录取学校
     * @return
     */
    public Object getTeacherMessage();

    /**
     * 统计学生信息。填报情况。未填报人数等等
     * @return
     */
    public Object getStudentMessage();

    /**
     * 查看信息、登入
     * @param AdminId
     * @return
     */
    public Admin getAdmin(int AdminId);
}
