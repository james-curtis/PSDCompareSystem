package com.example.compare.mapper;

import com.example.compare.entity.Attachment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 附件表 Mapper 接口
 * </p>
 *
 * @author nosguar
 * @since 2022-03-26
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

    @Select("select file_name from attachment where id = #{id}")
    String selectFileNameById(@Param("id") Integer id);
}
