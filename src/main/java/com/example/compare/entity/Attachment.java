package com.example.compare.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author nosguar
 * @since 2022-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("attachment")
public class Attachment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 图片ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    public Attachment(Integer filesize, Integer resolutionX, Integer resolutionY, String path) {
        this.filesize = filesize;
        this.resolutionX = resolutionX;
        this.resolutionY = resolutionY;
        this.path = path;
    }

    /**
     * 文件名
     */
    private String fileName;

    /**

     * 图片大小，单位MB
     */
    private Integer filesize;

    /**
     * 图片分辨率X轴
     */
    private Integer resolutionX;

    /**
     * 图片分辨率Y轴
     */
    private Integer resolutionY;

    /**
     * 图片路径
     */
    private String path;




}
