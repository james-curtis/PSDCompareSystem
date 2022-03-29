package com.example.compare.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.compare.entity.Compare;
import com.example.compare.mapper.CompareMapper;
import com.example.compare.service.CompareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompareServiceImpl implements CompareService {
    @Autowired
    CompareMapper mapper;
    @Override
    public String getOrderIdById(Integer id) {
        return mapper.getOrderIdByid(id);
    }

    @Override
    public boolean updateCompareStatus(Integer id) {
        UpdateWrapper<Compare> q1=new UpdateWrapper<>();
        q1.eq("order_id",id);
        q1.set("status","未完成");
        int update = mapper.update(null, q1);
        if(update==1){
            return true;
        }
            return false;

    }
}
