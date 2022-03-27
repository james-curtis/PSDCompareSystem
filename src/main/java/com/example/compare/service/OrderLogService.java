package com.example.compare.service;

import com.example.compare.entity.OrderLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    /**
     * 调用请求支付
     */

    String AlipayUtils(OrderLog orderLog);

    /**
     * 显示所有记录信息
      * @return
     */

    List<OrderLog> select();


    /**
     *  根据id删除历史记录
     * @param id
     * @return
     */

    int deleteById(int id);

    /**
     * 分页查询
     * @param keywords
     * @param startTime
     * @param endTime
     * @param index
     * @param accountPage
     * @return
     */

    List<OrderLog> Search(String keywords,String startTime,String endTime,int index,int accountPage);
}
