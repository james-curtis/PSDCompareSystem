package com.example.compare.service;

import com.example.compare.entity.Compare;

import java.util.List;

public interface CompareService {
    String getOrderIdById(Integer id);

    /**
     * 保存CompareLog信息
     * @param compareLog
     * @return
     */
    public Integer saveCompareLog(Compare compareLog);

    /**
     * 历史记录分页查询
     * @return
     */
    List<Compare> search(String keywords, String startTime, String endTime, int index, int maxPage);

    /**
     * 多表删除
     * @return
     */
    int allDelete(int orderId);

    /**
     * 根据id获取数据
     * @return
     */
    Compare select(int id);

    /**
     * 获取所有数据
     * @return
     */
    List<Compare> selectList();
}
