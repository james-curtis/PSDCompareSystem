package com.example.compare.service.impl;

import com.example.compare.entity.OrderLog;
import com.example.compare.mapper.OrderLogMapper;
import com.example.compare.service.OrderLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付订单表 服务实现类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Service
public class OrderLogServiceImpl extends ServiceImpl<OrderLogMapper,OrderLog> implements OrderLogService {

    @Autowired
    private OrderLogMapper orderLogMapper;

    @Override
    public Integer saveOrderLog(OrderLog orderLog) {
        orderLogMapper.insert(orderLog);
        Integer id = orderLog.getId();
        return id;
    }
}
