package com.example.newcompare.service;

import com.example.newcompare.entity.OrderLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 支付订单表 服务类
 * </p>
 *
 * @author nosgua
 * @since 2022-04-10
 */
public interface OrderLogService extends IService<OrderLog> {

    OrderLog getOrderLog(String outTradeId);

    String useAlipayUtils(OrderLog orderLog);

    boolean checkOrderAndUpdateDatabase(String outTradeNo);

    OrderLog getByWorkCode(@Param("workCode") String workCode);

    void insertOrderLog(OrderLog orderLog);

    int orderDelete(String[] Ids);


    OrderLog getDiffInformation(String out_trade_no);

    boolean updateStatus(OrderLog out_trade_no);
}
