package com.mikey.design.service.impl;

import com.mikey.design.entity.Wish;
import com.mikey.design.mapper.WishMapper;
import com.mikey.design.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:49
 * @Version 1.0
 */
@Service
public class WishServiceImpl implements WishService {

    @Autowired
    private WishMapper wishMapper;

    /**
     * 添加志愿
     * @param wish
     */
    @Override
    public void addWish(Wish wish) {

    }

    /**
     * 修改志愿
     * @param wish
     */
    @Override
    public void updateWish(Wish wish) {

    }

    /**
     * 获取志愿信息
     * @param wishId
     * @return
     */
    @Override
    public Wish getWish(int wishId) {
        return null;
    }

    /**
     * 获取全部志愿
     * @return
     */
    @Override
    public List<Wish> getAllWish() {
        return null;
    }
}
