package com.example.compare.service;

import com.example.compare.entity.CompareLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 对比记录表 服务类
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
public interface CompareLogService extends IService<CompareLog>{

    /**
     * 保存CompareLog信息
     * @param compareLog
     * @return
     */
    public Integer saveCompareLog(CompareLog compareLog);

}
