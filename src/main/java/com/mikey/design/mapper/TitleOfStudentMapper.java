package com.mikey.design.mapper;

import com.mikey.design.entity.TitleOfStudent;
import com.mikey.design.entity.TitleOfStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TitleOfStudentMapper {
    long countByExample(TitleOfStudentExample example);

    int deleteByExample(TitleOfStudentExample example);

    int deleteByPrimaryKey(Integer desOfStuId);

    int insert(TitleOfStudent record);

    int insertSelective(TitleOfStudent record);

    List<TitleOfStudent> selectByExample(TitleOfStudentExample example);

    TitleOfStudent selectByPrimaryKey(Integer desOfStuId);

    int updateByExampleSelective(@Param("record") TitleOfStudent record, @Param("example") TitleOfStudentExample example);

    int updateByExample(@Param("record") TitleOfStudent record, @Param("example") TitleOfStudentExample example);

    int updateByPrimaryKeySelective(TitleOfStudent record);

    int updateByPrimaryKey(TitleOfStudent record);

    //回档第二志愿
    void backSecondWish(Integer studentId);
    //回档第一志愿
    void backFirstWish(Integer studentId);
}