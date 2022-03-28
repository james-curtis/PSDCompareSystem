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
public interface OrderLogService extends IService<OrderLog>{

    /**
     * 保存OrderLog信息
     * @param orderLog
     * @return
     */
    public Integer saveOrderLog(OrderLog orderLog);

}
