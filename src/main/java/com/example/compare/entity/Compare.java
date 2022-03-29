package com.example.compare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("compare")
public class Compare {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 工作码
     */
    private String workCode;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 状态
     */
    private String status;

    /**
     * 流水号
     */
    private String serialNumber;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
