package com.example.newcompare.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.newcompare.entity.OrderLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 支付订单表 Mapper 接口
 * </p>
 *
 * @author nosgua
 * @since 2022-04-10
 */
@Mapper
public interface OrderLogMapper extends BaseMapper<OrderLog> {

    int allDelete(@Param("serialNumbers") String[] serialNumbers);

    Page<OrderLog> getHistory(@Param("Page") Page<OrderLog> Page, @Param("keyWords") String keyWords, @Param("startTime") String startTime, @Param("endTime") String endTime);

}
