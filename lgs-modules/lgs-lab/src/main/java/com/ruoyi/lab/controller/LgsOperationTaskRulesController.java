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
import com.ruoyi.lab.domain.LgsOperationTaskRules;
import com.ruoyi.lab.service.ILgsOperationTaskRulesService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 运维任务规则Controller
 * 
 * @author lgn
 * @date 2022-08-18
 */
@Api(tags = "运维任务规则Controller")
@RestController
@RequestMapping("/rules")
public class LgsOperationTaskRulesController extends BaseController
{
    @Autowired
    private ILgsOperationTaskRulesService lgsOperationTaskRulesService;

    /**
     * 查询运维任务规则列表
     */
    @ApiOperation(value = "查询运维任务规则列表", notes = "查询运维任务规则列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsOperationTaskRules lgsOperationTaskRules)
    {
        startPage();
        lgsOperationTaskRulesService.initializationTaskRules(lgsOperationTaskRules);//初始化默认的定时任务。
        List<LgsOperationTaskRules> list = lgsOperationTaskRulesService.selectLgsOperationTaskRulesList(lgsOperationTaskRules);
        return getDataTable(list);
    }

    /**
     * 导出运维任务规则列表
     */
    @RequiresPermissions("lab:rules:export")
    @Log(title = "运维任务规则", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsOperationTaskRules lgsOperationTaskRules)
    {
        List<LgsOperationTaskRules> list = lgsOperationTaskRulesService.selectLgsOperationTaskRulesList(lgsOperationTaskRules);
        ExcelUtil<LgsOperationTaskRules> util = new ExcelUtil<LgsOperationTaskRules>(LgsOperationTaskRules.class);
        util.exportExcel(response, list, "运维任务规则数据");
    }

    /**
     * 获取运维任务规则详细信息
     */
    @ApiOperation(value = "获取运维任务规则详细信息", notes = "获取运维任务规则详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsOperationTaskRulesService.selectLgsOperationTaskRulesById(id));
    }

    /**
     * 新增运维任务规则
     */
    @ApiOperation(value = "新增运维任务规则", notes = "新增运维任务规则", httpMethod = "POST")
    @Log(title = "运维任务规则", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsOperationTaskRules lgsOperationTaskRules)
    {
        return toAjax(lgsOperationTaskRulesService.insertLgsOperationTaskRules(lgsOperationTaskRules));
    }

    /**
     * 修改运维任务规则
     */
    @ApiOperation(value = "修改运维任务规则", notes = "修改运维任务规则", httpMethod = "PUT")
    @Log(title = "运维任务规则", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsOperationTaskRules lgsOperationTaskRules)
    {
        return toAjax(lgsOperationTaskRulesService.updateLgsOperationTaskRules(lgsOperationTaskRules));
    }

/*    *//**
     * 删除运维任务规则
     *//*
    @RequiresPermissions("lab:rules:remove")
    @Log(title = "运维任务规则", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsOperationTaskRulesService.deleteLgsOperationTaskRulesByIds(ids));
    }*/
}
