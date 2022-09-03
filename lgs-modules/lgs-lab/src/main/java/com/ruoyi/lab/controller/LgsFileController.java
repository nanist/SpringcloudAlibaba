package com.ruoyi.lab.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.lab.domain.LgsFile;
import com.ruoyi.lab.service.ILgsFileService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
　　* @description: TODO
　　* @param
　　* @return 
　　* @throws
　　* @author lgn
　　* @date 2022/8/4 16:04 
　　*/
@Api(tags = "lgs文件Controller")
@RestController
@RequestMapping("/file")
public class LgsFileController extends BaseController
{
    @Autowired
    private ILgsFileService lgsFileService;

/**
　　* @description: TODO
　　* @param 
　　* @return 
　　* @throws
　　* @author lgn
　　* @date 2022/8/4 16:07 
　　*/
    @ApiOperation(value = "查询lgs文件列表", notes = "查询lgs文件列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsFile lgsFile)
    {
        startPage();
        List<LgsFile> list = lgsFileService.selectLgsFileList(lgsFile);
        return getDataTable(list);
    }

    /**
     * 导出lgs文件列表
     */
    @RequiresPermissions("lab:file:export")
    @Log(title = "lgs文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsFile lgsFile)
    {
        List<LgsFile> list = lgsFileService.selectLgsFileList(lgsFile);
        ExcelUtil<LgsFile> util = new ExcelUtil<LgsFile>(LgsFile.class);
        util.exportExcel(response, list, "lgs文件数据");
    }

    /**
     * 获取lgs文件详细信息
     */
    @ApiOperation(value = "获取lgs文件详细信息", notes = "获取lgs文件详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsFileService.selectLgsFileById(id));
    }

    /**
     * 新增lgs文件
     */
    @ApiOperation(value = "新增lgs文件", notes = "新增lgs文件", httpMethod = "POST")
    @Log(title = "lgs文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsFile lgsFile)
    {
        return toAjax(lgsFileService.insertLgsFile(lgsFile));
    }

    /**
     * 修改lgs文件
     */
    @ApiOperation(value = "修改lgs文件", notes = "修改lgs文件", httpMethod = "PUT")
    @Log(title = "lgs文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsFile lgsFile)
    {
        return toAjax(lgsFileService.updateLgsFile(lgsFile));
    }

    /**
     * 批量插入文件
     * {"fileData":[{"name":"接口_20220823193722A001.txt","url":"http://10.10.11.79:9300/statics/2022/08/23/接口_20220823193722A001.txt"},
     * {"name":"接口_20220823193722A002.docx","url":"http://10.10.11.79:9300/statics/2022/08/23/接口_20220823193722A002.docx"}]}
     * @param map
     * @return
     */
    @ApiOperation(value = "批量插入文件", notes = "批量插入文件", httpMethod = "POST")
    @Log(title = "批量插入文件", businessType = BusinessType.INSERT)
    @PostMapping("/batchInsertFile")
    public AjaxResult batchInsertFile(@RequestBody Map<String, List<Map<String,String>>> map)
    {
        List<Map<String,String>> list=map.get("fileData");
        return AjaxResult.success(lgsFileService.batchInsertFile(list));
    }
}
