package com.ruoyi.file.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.file.config.MinioConfig;
import com.ruoyi.file.utils.FileUploadUtils;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;

import java.util.Map;

/**
 * Minio 文件存储
 * 
 * @author ruoyi
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService
{
    @Autowired
    private MinioConfig minioConfig;

    @Autowired
    private MinioClient client;

    /**
     * 本地文件上传接口
     * 
     * @param file 上传的文件
     * @return 访问地址
     * @throws Exception
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception
    {
        String fileName = FileUploadUtils.extractFilename(file);
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        client.putObject(args);
        return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
    }

    @Override
    public JSONObject generatePDF(Map<String, String> map) {
        return null;
    }
}
