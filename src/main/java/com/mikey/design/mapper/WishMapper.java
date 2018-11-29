package com.mikey.design.mapper;

import com.mikey.design.entity.Wish;
import com.mikey.design.entity.WishExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface WishMapper {
    long countByExample(WishExample example);

    int deleteByExample(WishExample example);

    int deleteByPrimaryKey(Integer wishId);

    int insert(Wish record);

    int insertSelective(Wish record);

    List<Wish> selectByExample(WishExample example);

    Wish selectByPrimaryKey(Integer wishId);

    int updateByExampleSelective(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByExample(@Param("record") Wish record, @Param("example") WishExample example);

    int updateByPrimaryKeySelective(Wish record);

    int updateByPrimaryKey(Wish record);
}