package com.example.compare.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 对比记录表
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("compare_log")
public class CompareLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 流水号
     */
    @TableField("serial_number")
    private Integer serialNumber;

    /**
     * 对比费用
     */
    @TableField("comparison_cost")
    private BigDecimal comparisonCost;

    /**
     * 关联order_log订单记录表的id
     */
    @TableField("order_id")
    private Integer orderId;

    /**
     * 对比文件1的ID
     */
    @TableField("compare_file_1")
    private Integer compareFile1;

    /**
     * 对比文件2的ID
     */
    @TableField("compare_file_2")
    private Integer compareFile2;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
}
