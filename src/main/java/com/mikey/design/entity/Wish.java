package com.mikey.design.entity;

public class Wish {
    private Integer wishId;

    private String wishFist;

    private String wishSecond;

    public Integer getWishId() {
        return wishId;
    }

    public void setWishId(Integer wishId) {
        this.wishId = wishId;
    }

    public String getWishFist() {
        return wishFist;
    }

    public void setWishFist(String wishFist) {
        this.wishFist = wishFist == null ? null : wishFist.trim();
    }

    public String getWishSecond() {
        return wishSecond;
    }

    public void setWishSecond(String wishSecond) {
        this.wishSecond = wishSecond == null ? null : wishSecond.trim();
    }
}