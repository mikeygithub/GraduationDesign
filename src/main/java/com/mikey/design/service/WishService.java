package com.mikey.design.service;

import com.mikey.design.entity.Wish;

import java.util.List;

/**
 * @author Mikey
 * @Title:
 * @Description:
 * @Email:1625017540@qq.com
 * @date 2018/11/28 18:45
 * @Version 1.0
 */
public interface WishService {
    public void addWish(Wish wish);
    public void updateWish(Wish wish);
    public Wish getWish(int wishId);
    public List<Wish> getAllWish();
}
