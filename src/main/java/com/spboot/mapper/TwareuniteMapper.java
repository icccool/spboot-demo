package com.spboot.mapper;

import com.spboot.bean.Twareunite;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TwareuniteMapper {
    int deleteByPrimaryKey(Long uniteId);

    int insert(Twareunite record);

    int insertSelective(Twareunite record);

    Twareunite selectByPrimaryKey(Long uniteId);

    int updateByPrimaryKeySelective(Twareunite record);

    int updateByPrimaryKey(Twareunite record);
}