package com.example.newcompare.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.newcompare.entity.OrderLog;
import com.example.newcompare.entity.TaskGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskGroupMapper extends BaseMapper<TaskGroup> {

    List<TaskGroup> getTotal(@Param("keyWords") String keyWords, @Param("startTime") String startTime, @Param("endTime") String endTime);

    Page<TaskGroup> getGroups(@Param("Page") Page<TaskGroup> Page, @Param("keyWords") String keyWords, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("defaultSort") String defaultSort);

    Page<OrderLog> getGroup(@Param("Page") Page<OrderLog> Page, @Param("groupId") String groupId);

    String getWorkCodeById(Integer id);
}
