package com.example.compare.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.compare.entity.CompareLog;
import com.example.compare.mapper.AttachmentMapper;
import com.example.compare.mapper.CompareLogMapper;
import com.example.compare.service.CompareLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private CompareLogMapper compareLogMapper;
    @Resource
    private AttachmentMapper attachmentMapper;

    @Override
    public Integer saveCompareLog(CompareLog compareLog) {
        compareLogMapper.insert(compareLog);
        return compareLog.getId();
    }

    @Override
    public List<CompareLog> search(String keywords, String startTime, String endTime, int index, int maxPage) {
        return compareLogMapper.search(keywords, startTime, endTime, index, maxPage);
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

    @Override
    public IPage<Map<String, Object>> getCompareLogPageAndFilename(Long current, Long size) {
        IPage<CompareLog> page = new Page<>(current, size);
        IPage<Map<String, Object>> mapIPage = compareLogMapper.selectMapsPage(page, null);
        for (Map<String, Object> record : mapIPage.getRecords()) {
            String compare_file_1 = attachmentMapper.selectFileNameById((Integer) record.get("compare_file_1"));
            String compare_file_2 = attachmentMapper.selectFileNameById((Integer) record.get("compare_file_2"));
            record.put("compare_file_name_1", compare_file_1 == null ? "" : compare_file_1);
            record.put("compare_file_name_2", compare_file_2 == null ? "" : compare_file_2);
        }
        return mapIPage;
    }
}
