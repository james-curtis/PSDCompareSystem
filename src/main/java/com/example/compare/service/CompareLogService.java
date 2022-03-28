package com.example.compare.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.compare.entity.CompareLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.compare.entity.OrderLog;

import java.util.List;
import java.util.Map;

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
     */
    Integer saveCompareLog(CompareLog compareLog);

    /**
     * 历史记录分页查询
     */
    List<CompareLog> search(String keywords, String startTime, String endTime, int index, int maxPage);

    /**
     * 多表删除
     */
    int allDelete(int orderId);

    /**
     * 根据id获取数据
     */
    CompareLog select(int id);

    /**
     * 获取所有数据
     */
    List<CompareLog> selectList();

    /**
     * 得到比较日志分页和文件名
     *
     * @param current 当前
     * @param size    大小
     * @return {@link IPage}<{@link Map}<{@link String}, {@link Object}>>
     */
    IPage<Map<String, Object>> getCompareLogPageAndFilename(Long current, Long size);

    /**
     * 根据对比记录表id 获取相应的订单编号
     *
     * @param id
     * @return
     */
    String getOutTradeId(int id);
}
