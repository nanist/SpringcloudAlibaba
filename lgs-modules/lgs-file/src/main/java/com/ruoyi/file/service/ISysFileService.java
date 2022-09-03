package com.ruoyi.file.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 文件上传接口
 * 
 * @author ruoyi
 */
public interface ISysFileService
{
    /**
     * 文件上传接口
     * 
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    public String uploadFile(MultipartFile file) throws Exception;

    /**
    　　* @description: TODO
    　　* @param 动态生成pdf
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/23 9:57
    　　*/
    JSONObject generatePDF(Map<String, String> map);
}
