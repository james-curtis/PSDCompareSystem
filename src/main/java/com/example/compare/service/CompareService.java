package com.example.compare.service;

public interface CompareService {
    String getOrderIdById(Integer id);


    /**
     *  修改对比状态
     */

    public boolean updateCompareStatus(Integer id);
}
