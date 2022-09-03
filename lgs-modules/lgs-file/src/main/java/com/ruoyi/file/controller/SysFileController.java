package com.ruoyi.file.controller;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.core.web.domain.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.file.FileUtils;
import com.ruoyi.file.service.ISysFileService;
import com.ruoyi.system.api.domain.SysFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.Map;

/**
 * 文件请求处理
 * 
 * @author ruoyi
 */
@RestController
public class SysFileController
{
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Autowired
    private ISysFileService sysFileService;

    /**
     * 文件上传请求
     */
    /**
     * 文件上传请求
     */
    @PostMapping(value ="upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "文件上传请求")
    public R<SysFile> upload(@RequestPart("file") MultipartFile file)
    {
        try
        {
            // 上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            SysFile sysFile = new SysFile();
            sysFile.setName(FileUtils.getName(url));
            sysFile.setUrl(url);
            return R.ok(sysFile);
        }
        catch (Exception e)
        {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    /**
     * 批量上传
     * @param files
     * @return
     */
    @PostMapping(value ="batchUploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "文件上传请求")
    public R<JSONArray> batchUploadFile(@RequestPart("files") MultipartFile[] files)
    {
        try
        {
            JSONArray jsonArray=new JSONArray();

            for(MultipartFile file : files) {//循环单个上传
                // 上传并返回访问地址
                String url = sysFileService.uploadFile(file);
                SysFile sysFile = new SysFile();
                sysFile.setName(FileUtils.getName(url));
                sysFile.setUrl(url);
                jsonArray.add(sysFile);
            }
            return R.ok(jsonArray);
        }
        catch (Exception e)
        {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    /**
 　　* @description: TODO
 　　* @param
 　　* @return
 　　* @throws
 　　* @author lgn
 　　* @date 2022/8/23 9:31
 　　*/
    @ApiOperation(value = "动态生成pdf", notes = "动态生成pdf", httpMethod = "POST")
    @PostMapping("/generatePDF")
    public AjaxResult generatePDF(@RequestBody Map<String, String> map)
    {
        return AjaxResult.success(sysFileService.generatePDF(map));
    }

    /**
     * 根据文件路径下载文件
     * @param name
     * @param downloadPath
     * @param request
     * @param response
     * @throws Exception
     */
    @ApiOperation(value = "根据文件路径下载文件", notes = "根据文件路径下载文件", httpMethod = "GET")
    @GetMapping("/downloadByFilePath")
    public void downloadByFilePath(String name, String downloadPath, HttpServletRequest request, HttpServletResponse response) throws Exception {

        String fileName=null;
        if (StringUtils.isEmpty(name)){
            File htmlFile = new File(downloadPath);
            fileName=htmlFile.getName();
        }else{
            fileName=name;
        }

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        String agent = request.getHeader("USER-AGENT"); //获取浏览器的信息
        if(agent != null && agent.toLowerCase().indexOf("firefox")>0){
            //火狐浏览器自己会对URL进行一次URL转码所以区别处理
            response.setHeader("Content-Disposition",
                    "attachment; filename="+ new String(fileName.getBytes("GB2312"),"ISO-8859-1"));
        }else if(agent.toLowerCase().indexOf("safari")>0){
            //苹果浏览器需要用ISO 而且文件名得用UTF-8
            response.setHeader("Content-Disposition",
                    "attachment; filename="+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));
        }else {
            //其他的浏览器
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        }
        FileUtils.writeBytes(downloadPath, response.getOutputStream());//根据文件路径下载文件
    }

}