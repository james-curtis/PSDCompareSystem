package com.example.compare.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.compare.entity.OrderLog;
import com.example.compare.mapper.OrderLogMapper;
import com.example.compare.service.OrderLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * <p>
 * 支付订单表 服务实现类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Service
public class OrderLogServiceImpl implements OrderLogService {
    @Autowired
    OrderLogMapper mapper;

    @Override
    public OrderLog getOrderLog(String outTradeId) {
        OrderLog orderLog = mapper.selectOne(new QueryWrapper<OrderLog>().eq("out_trade_id",outTradeId));
        return orderLog;
    }

    @Override
    public OrderLog insertOrderLog() {
        OrderLog orderLog = new OrderLog();
        orderLog.setOutTradeId(UUID.randomUUID().toString());
        orderLog.setStatus("unpaid");
        orderLog.setTitle("test");
        orderLog.setFee(new BigDecimal(100));
        mapper.insert(orderLog);
        return orderLog;
    }
}
