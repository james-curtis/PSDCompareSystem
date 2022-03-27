package com.example.compare.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.compare.common.utils.Result;
import com.example.compare.entity.CompareLog;
import com.example.compare.service.CompareLogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 对比记录表 前端控制器
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/compare-log")
public class CompareLogController {

    @Resource
    private CompareLogService compareLogService;

    /**
     * 对比记录分页查询操作
     *
     * @param current 当前页码
     * @param size    一页最大显示条数
     * @return {@link Result}
     * @author zuojun666
     * @since 2022-03-27
     */
    @ApiOperation(value = "左呈祥===>对比记录分页查询操作   current:当前页码  size:一页最大显示条数")
    @GetMapping("/{current}/{size}")
    public Result page(@PathVariable("current") Long current, @PathVariable("size") Long size) {
        try {
            IPage<CompareLog> page = new Page<>(current, size);
            page = compareLogService.page(page);
            return Result.success(page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(500, "服务器繁忙，请稍后再试", "");
        }
    }
}
