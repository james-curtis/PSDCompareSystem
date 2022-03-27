package com.example.compare.mapper;

import com.example.compare.entity.CompareLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 对比记录表 Mapper 接口
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */

public interface CompareLogMapper extends BaseMapper<CompareLog> {
    /**
     * 分页查询
     * @return
     */
    List<CompareLog> search(String keywords, String startTime, String endTime, int index, int maxPage);

    /**
     * 多表删除
     * @return
     */
    int allDelete(int id);
}
