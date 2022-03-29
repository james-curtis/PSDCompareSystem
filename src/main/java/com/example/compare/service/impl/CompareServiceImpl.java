package com.example.compare.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.compare.entity.Compare;
import com.example.compare.mapper.CompareMapper;
import com.example.compare.service.CompareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompareServiceImpl extends ServiceImpl<CompareMapper, Compare> implements CompareService {
    @Resource
    private CompareMapper mapper;

    @Override
    public String getOrderIdById(Integer id) {
        return mapper.getOrderIdByid(id);
    }

    @Override
    public Integer saveCompareLog(Compare compareLog) {
        mapper.insert(compareLog);
        return compareLog.getId();
    }

    @Override
    public List<Compare> search(String keywords, String startTime, String endTime, int index, int maxPage) {
        return mapper.search(keywords, startTime, endTime, index, maxPage);
    }

    @Override
    public int allDelete(int orderId) {
        return mapper.allDelete(orderId);
    }

    @Override
    public Compare select(int id) {
        return mapper.selectById(id);
    }

    @Override
    public List<Compare> selectList() {
        return mapper.selectList(null);
    }
}
