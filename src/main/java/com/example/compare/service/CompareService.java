package com.example.compare.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.compare.entity.Compare;

public interface CompareService extends IService<Compare> {
    String getOrderIdById(Integer id);
}
