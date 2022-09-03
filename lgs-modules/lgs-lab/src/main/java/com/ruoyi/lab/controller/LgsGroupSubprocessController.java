package com.ruoyi.lab.controller;

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
import com.ruoyi.lab.domain.LgsGroupSubprocess;
import com.ruoyi.lab.service.ILgsGroupSubprocessService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 入组管理通用子流程Controller
 * 
 * @author lgn
 * @date 2022-08-10
 */
@Api(tags = "入组管理通用子流程Controller")
@RestController
@RequestMapping("/subprocess")
public class LgsGroupSubprocessController extends BaseController
{
    @Autowired
    private ILgsGroupSubprocessService lgsGroupSubprocessService;

    /**
     * 查询分组管理通用子流程列表
     */
    @ApiOperation(value = "查询分组管理通用子流程列表", notes = "查询分组管理通用子流程列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsGroupSubprocess lgsGroupSubprocess)
    {
        startPage();
        List<LgsGroupSubprocess> list = lgsGroupSubprocessService.selectLgsGroupSubprocessList(lgsGroupSubprocess);
        return getDataTable(list);
    }

    /**
     * 导出分组管理通用子流程列表
     */
    @RequiresPermissions("lab:subprocess:export")
    @Log(title = "分组管理通用子流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsGroupSubprocess lgsGroupSubprocess)
    {
        List<LgsGroupSubprocess> list = lgsGroupSubprocessService.selectLgsGroupSubprocessList(lgsGroupSubprocess);
        ExcelUtil<LgsGroupSubprocess> util = new ExcelUtil<LgsGroupSubprocess>(LgsGroupSubprocess.class);
        util.exportExcel(response, list, "分组管理通用子流程数据");
    }

    /**
     * 获取分组管理通用子流程详细信息
     */
    @ApiOperation(value = "获取分组管理通用子流程详细信息", notes = "获取分组管理通用子流程详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsGroupSubprocessService.selectLgsGroupSubprocessById(id));
    }

    /**
     * 新增分组管理通用子流程
     */
    @ApiOperation(value = "新增分组管理通用子流程", notes = "新增分组管理通用子流程", httpMethod = "POST")
    @Log(title = "分组管理通用子流程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsGroupSubprocess lgsGroupSubprocess)
    {
        return toAjax(lgsGroupSubprocessService.insertLgsGroupSubprocess(lgsGroupSubprocess));
    }

    /**
     * 修改分组管理通用子流程
     */
    @ApiOperation(value = "修改分组管理通用子流程", notes = "修改分组管理通用子流程", httpMethod = "PUT")
    @Log(title = "分组管理通用子流程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsGroupSubprocess lgsGroupSubprocess)
    {
        return toAjax(lgsGroupSubprocessService.updateLgsGroupSubprocess(lgsGroupSubprocess));
    }

    /**
     * 批量完成子流程
     *
     */
    @ApiOperation(value = "批量完成子流程", notes = "批量完成子流程", httpMethod = "POST")
    @Log(title = "batchCompleteGroupSubprocess", businessType = BusinessType.UPDATE)
    @PostMapping("/batchCompleteGroupSubprocess")
    public AjaxResult batchCompleteGroupSubprocess(@RequestBody Map<String, Object> param)
    {
        return AjaxResult.success(lgsGroupSubprocessService.batchCompleteGroupSubprocess(param));
    }


/*    *//**
     * 删除分组管理通用子流程
     *//*
    @RequiresPermissions("lab:subprocess:remove")
    @Log(title = "分组管理通用子流程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsGroupSubprocessService.deleteLgsGroupSubprocessByIds(ids));
    }*/


}
