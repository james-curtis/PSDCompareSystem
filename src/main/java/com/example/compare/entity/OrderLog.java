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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付订单表
 * </p>
 *
 * @author nosgua
 * @since 2022-03-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_log")
public class OrderLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付状态
     */
    @TableField("status")
    private String status;

    /**
     * 应付金额
     */
    @TableField("fee")
    private BigDecimal fee;

    public OrderLog(String status, BigDecimal fee, String outTradeId) {
        this.status = status;
        this.fee = fee;
        this.outTradeId = outTradeId;
    }

    /**
     * 商户订单ID
     */
    @TableField("out_trade_id")
    private String outTradeId;



    /**
     * title
     */
    @TableField("title")
    private String title;

}
