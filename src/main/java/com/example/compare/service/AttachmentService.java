package com.example.compare.service;

import com.alibaba.fastjson.JSONObject;
import com.example.compare.entity.Attachment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 附件表 服务类
 * </p>
 *
 * @author nosguar
 * @since 2022-03-26
 */
public interface AttachmentService extends IService<Attachment>{

    /**
     * 插入attachment对象
     * @param attachment
     * @return
     */
    public Integer insertAttachment(Attachment attachment);

    /**
     * 获取七牛云上传凭证
     * @param suffix
     * @return
     */
    public JSONObject getQiniuPolicy(String suffix);

    /**
     * 删除attachment对象
     */
    public Boolean deleteAttachment(Integer integer);
}
