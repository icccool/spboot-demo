package com.spboot.mapper;


import com.spboot.bean.Twareunitegeneralname;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TwareunitegeneralnameMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Twareunitegeneralname record);

    int insertSelective(Twareunitegeneralname record);

    Twareunitegeneralname selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Twareunitegeneralname record);

    int updateByPrimaryKey(Twareunitegeneralname record);
}