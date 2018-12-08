package com.mikey.design.entity;

public class TitleOfStudent {
    private Integer desOfStuId;

    private Integer desOfStu;

    private Integer desOfTitle;

    private Integer desState;

    private Integer desWishOrder;

    public Integer getDesOfStuId() {
        return desOfStuId;
    }

    public void setDesOfStuId(Integer desOfStuId) {
        this.desOfStuId = desOfStuId;
    }

    public Integer getDesOfStu() {
        return desOfStu;
    }

    public void setDesOfStu(Integer desOfStu) {
        this.desOfStu = desOfStu;
    }

    public Integer getDesOfTitle() {
        return desOfTitle;
    }

    public void setDesOfTitle(Integer desOfTitle) {
        this.desOfTitle = desOfTitle;
    }

    public Integer getDesState() {
        return desState;
    }

    public void setDesState(Integer desState) {
        this.desState = desState;
    }

    public Integer getDesWishOrder() {
        return desWishOrder;
    }

    public void setDesWishOrder(Integer desWishOrder) {
        this.desWishOrder = desWishOrder;
    }
    private Student student;

    private Design design;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Design getDesign() {
        return design;
    }

    public void setDesign(Design design) {
        this.design = design;
    }
}