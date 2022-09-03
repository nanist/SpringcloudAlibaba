package com.ruoyi.file.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.file.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.file.utils.FileUploadUtils;

import java.io.File;
import java.util.Map;

/**
 * 本地文件存储
 * 
 * @author ruoyi
 */
@Primary
@Service
@RefreshScope //热刷新
public class LocalSysFileServiceImpl implements ISysFileService
{
    /**
     * 资源映射路径 前缀
     */
    @Value("${file.prefix}")
    public String localFilePrefix;

    /**
     * 域名或本机访问地址
     */
    @Value("${file.domain}")
    public String domain;
    
    /**
     * 上传文件存储在本地的根路径
     */
    @Value("${file.path}")
    private String localFilePath;

    /**
     * 备份申请单模板存储在本地的根路径
     */
    @Value("${file.backupRequestPath}")
    private String backupRequestPath;

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
        String name = FileUploadUtils.upload(localFilePath, file);
        String url = domain + localFilePrefix + name;
        return url;
    }

    /**
    　　* @description: TODO
    　　* @param
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/23 9:57 
    　　*/
    @Override
    public JSONObject generatePDF(Map<String, String> map) {
        //String out_path="C:\\Users\\lgn\\Desktop\\result.pdf";

        String userName=map.get("userid");
        String fileType=map.get("fileType");//


        // 获取绝对路径
        File file = new File(backupRequestPath);
        String parentPath = file.getParent(); //获取父级目录
        String fileName = file.getName(); //获取文件名

        //在父级目录里面 以登陆人名称建一个专属的pdf文件
        String out_path=parentPath+File.separator+userName+"_backupRequest.pdf";
        PdfUtils.export(backupRequestPath,out_path,map);//动态生成pdf

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("filePath",out_path);
        jsonObject.put("fileName",fileName);

        return jsonObject;
    }
}
