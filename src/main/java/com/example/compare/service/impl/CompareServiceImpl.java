package com.example.compare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.compare.entity.Compare;
import com.example.compare.mapper.CompareMapper;
import com.example.compare.service.CompareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompareServiceImpl extends ServiceImpl<CompareMapper, Compare> implements CompareService {
    @Resource
    private CompareMapper mapper;

    @Override
    public String getOrderIdById(Integer id) {
        return mapper.getOrderIdByid(id);
    }
}
