package com.mikey.design.mapper;

import com.mikey.design.entity.Design;
import com.mikey.design.entity.DesignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DesignMapper {
    long countByExample(DesignExample example);

    int deleteByExample(DesignExample example);

    int deleteByPrimaryKey(Integer designId);

    int insert(Design record);

    int insertSelective(Design record);

    List<Design> selectByExample(DesignExample example);

    Design selectByPrimaryKey(Integer designId);

    int updateByExampleSelective(@Param("record") Design record, @Param("example") DesignExample example);

    int updateByExample(@Param("record") Design record, @Param("example") DesignExample example);

    int updateByPrimaryKeySelective(Design record);

    int updateByPrimaryKey(Design record);
}