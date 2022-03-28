package com.example.compare.service.impl;

import com.example.compare.entity.CompareLog;
import com.example.compare.mapper.CompareLogMapper;
import com.example.compare.service.CompareLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 对比记录表 服务实现类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Service
public class CompareLogServiceImpl extends ServiceImpl<CompareLogMapper, CompareLog> implements CompareLogService {
    @Autowired
    CompareLogMapper compareLogMapper;

    @Override
    public Integer saveCompareLog(CompareLog compareLog) {
        compareLogMapper.insert(compareLog);
        Integer id = compareLog.getId();
        return id;
    }

    @Override
    public List<CompareLog> search(String keywords, String startTime, String endTime, int index, int maxPage) {
        return compareLogMapper.search(keywords,startTime,endTime,index,maxPage);
    }

    @Override
    public int allDelete(int orderId) {
        return compareLogMapper.allDelete(orderId);
    }

    @Override
    public CompareLog select(int id) {
        return compareLogMapper.selectById(id);
    }

    @Override
    public List<CompareLog> selectList() {
        return compareLogMapper.selectList(null);
    }
}
