package com.ruoyi.lab.controller;

import java.util.List;
import java.io.IOException;
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
import com.ruoyi.lab.domain.LgsTasksBacklog;
import com.ruoyi.lab.service.ILgsTasksBacklogService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 定时任务待办Controller
 * 
 * @author lgn
 * @date 2022-08-19
 */
@Api(tags = "定时任务待办Controller")
@RestController
@RequestMapping("/backlog")
public class LgsTasksBacklogController extends BaseController
{
    @Autowired
    private ILgsTasksBacklogService lgsTasksBacklogService;

    /**
     * 查询定时任务待办列表
     */
    @ApiOperation(value = "查询定时任务待办列表", notes = "查询定时任务待办列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsTasksBacklog lgsTasksBacklog)
    {
        startPage();
        List<LgsTasksBacklog> list = lgsTasksBacklogService.selectLgsTasksBacklogList(lgsTasksBacklog);
        return getDataTable(list);
    }

    /**
     * 导出定时任务待办列表
     */
    @RequiresPermissions("lab:backlog:export")
    @Log(title = "定时任务待办", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsTasksBacklog lgsTasksBacklog)
    {
        List<LgsTasksBacklog> list = lgsTasksBacklogService.selectLgsTasksBacklogList(lgsTasksBacklog);
        ExcelUtil<LgsTasksBacklog> util = new ExcelUtil<LgsTasksBacklog>(LgsTasksBacklog.class);
        util.exportExcel(response, list, "定时任务待办数据");
    }

    /**
     * 获取定时任务待办详细信息
     */
    @ApiOperation(value = "获取定时任务待办详细信息", notes = "获取定时任务待办详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsTasksBacklogService.selectLgsTasksBacklogById(id));
    }

    /**
     * 新增定时任务待办
     */
    @ApiOperation(value = "新增定时任务待办", notes = "新增定时任务待办", httpMethod = "POST")
    @Log(title = "定时任务待办", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsTasksBacklog lgsTasksBacklog)
    {
        return toAjax(lgsTasksBacklogService.insertLgsTasksBacklog(lgsTasksBacklog));
    }

    /**
     * 修改定时任务待办
     */
    @ApiOperation(value = "修改定时任务待办", notes = "修改定时任务待办", httpMethod = "PUT")
    @Log(title = "定时任务待办", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsTasksBacklog lgsTasksBacklog)
    {
        return toAjax(lgsTasksBacklogService.updateLgsTasksBacklog(lgsTasksBacklog));
    }

/*    *//**
     * 删除定时任务待办
     *//*
    @RequiresPermissions("lab:backlog:remove")
    @Log(title = "定时任务待办", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsTasksBacklogService.deleteLgsTasksBacklogByIds(ids));
    }*/
}
