package com.example.compare.service.impl;

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
}
