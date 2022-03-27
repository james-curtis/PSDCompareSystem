package com.example.compare.service;

import com.example.compare.entity.OrderLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 支付订单表 服务类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
public interface OrderLogService{
    /**
     * 根据订单号获取订单
     * @param outTradeId
     * @return
     */
    OrderLog getOrderLog(String outTradeId);

    /**
     * 插入新的订单
     * @return
     */
    OrderLog insertOrderLog();
}
