package com.yum.itsm.ddtalk.busi.mapper;

import com.yum.itsm.ddtalk.busi.entity.SupProjectGroup;
import com.yum.itsm.ddtalk.busi.entity.SupProjectGroupExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SupProjectGroupMapper {
    int countByExample(SupProjectGroupExample example);

    int deleteByExample(SupProjectGroupExample example);

    int deleteByPrimaryKey(Long supProjectGroupId);

    int insert(SupProjectGroup record);

    int insertSelective(SupProjectGroup record);

    List<SupProjectGroup> selectByExample(SupProjectGroupExample example);

    SupProjectGroup selectByPrimaryKey(Long supProjectGroupId);

    int updateByExampleSelective(@Param("record") SupProjectGroup record, @Param("example") SupProjectGroupExample example);

    int updateByExample(@Param("record") SupProjectGroup record, @Param("example") SupProjectGroupExample example);

    int updateByPrimaryKeySelective(SupProjectGroup record);

    int updateByPrimaryKey(SupProjectGroup record);
    
    List<SupProjectGroup> getSupProjectGroupDetails(Map<String, Object> params);
}