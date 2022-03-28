package com.example.compare.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.compare.common.utils.QiniuCloudUtil;
import com.example.compare.entity.Attachment;
import com.example.compare.mapper.AttachmentMapper;
import com.example.compare.service.AttachmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;



/**
 * <p>
 * 附件表 服务实现类
 * </p>
 *
 * @author nosguar
 * @since 2022-03-26
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper,Attachment> implements AttachmentService {


    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public Integer insertAttachment(Attachment attachment)
    {
        attachmentMapper.insert(attachment);
        Integer id = attachment.getId();
        return id;
    }

    @Override
    public JSONObject getQiniuPolicy(String suffix)
    {
        JSONObject json = new JSONObject();
        StringMap putPolicy = new StringMap();
        putPolicy.put("returnBody",
                "{\"key\":\"$(key)\"," +
                        "\"hash\":\"$(etag)\"," +
                        "\"bucket\":\"$(bucket)\"," +
                        "\"fsize\":\"$(fsize)\"," +
                        "\"mimeType\":\"$(mimeType)\"}");
        putPolicy.put("mimeLimit","!application/json;text/plain");
        json.put("token", QiniuCloudUtil.getAuth().uploadToken(QiniuCloudUtil.getBucket(), null, QiniuCloudUtil.getExpireSeconds(), putPolicy));
        json.put("url", "http://r91jzctnn.hn-bkt.clouddn.com/"+ UUID.randomUUID().toString()+suffix);
        json.put("dirPrefix", LocalDate.now() + "/");
        return json;
    }

    @Override
    public Boolean deleteAttachment(Integer id) {
        return attachmentMapper.deleteById(id) > 0;
    }


}
