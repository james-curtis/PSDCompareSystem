package com.example.compare.mapper;

import com.example.compare.entity.OrderLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 支付订单表 Mapper 接口
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Mapper
public interface OrderLogMapper extends BaseMapper<OrderLog> {
    String getCompareIdByOrderId(String id);
}
