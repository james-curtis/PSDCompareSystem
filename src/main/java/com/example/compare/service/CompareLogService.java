package com.example.compare.service;

import com.example.compare.entity.CompareLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.compare.entity.OrderLog;

import java.util.List;

/**
 * <p>
 * 对比记录表 服务类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
public interface CompareLogService extends IService<CompareLog> {

    /**
     * 保存CompareLog信息
     * @param compareLog
     * @return
     */
    public Integer saveCompareLog(CompareLog compareLog);

    /**
     * 历史记录分页查询
     * @return
     */
    List<CompareLog> search(String keywords, String startTime, String endTime, int index, int maxPage);

    /**
     * 多表删除
     * @return
     */
    int allDelete(int orderId);

    /**
     * 根据id获取数据
     * @return
     */
    CompareLog select(int id);

    /**
     * 获取所有数据
     * @return
     */
    List<CompareLog> selectList();
}
