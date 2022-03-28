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
     * 显示所有记录信息
     * @return
     */

    List<CompareLog> select();


    /**
     *  根据id删除历史记录
     * @param id
     * @return
     */

    int allDelete(int id);

    /**
     *  根据id查询历史记录
     * @param id
     * @return
     */

    CompareLog selectById(int id);

    /**
     * 分页查询
     * @param keywords
     * @param startTime
     * @param endTime
     * @param index
     * @param accountPage
     * @return
     */

    List<CompareLog> search( String keywords,String startTime,String endTime,int index,int accountPage);
}
