package com.ruoyi.lab.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.lab.domain.LgsDemandChangeRecord;
import com.ruoyi.lab.service.ILgsDemandChangeRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 需求变更记录Controller
 * 
 * @author lgn
 * @date 2022-08-09
 */
@Api(tags = "需求变更记录Controller")
@RestController
@RequestMapping("/demandRecord")
public class LgsDemandChangeRecordController extends BaseController
{
    @Autowired
    private ILgsDemandChangeRecordService demandChangeRecordService;

    /**
     * 查询需求变更记录列表
     */
    @ApiOperation(value = "查询需求变更记录列表", notes = "查询需求变更记录列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsDemandChangeRecord demandChangeRecord)
    {
        startPage();
        List<LgsDemandChangeRecord> list = demandChangeRecordService.selectDemandChangeRecordList(demandChangeRecord);
        return getDataTable(list);
    }

    /**
     * 导出需求变更记录列表
     */
    @RequiresPermissions("lab:record:export")
    @Log(title = "需求变更记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsDemandChangeRecord demandChangeRecord)
    {
        List<LgsDemandChangeRecord> list = demandChangeRecordService.selectDemandChangeRecordList(demandChangeRecord);
        ExcelUtil<LgsDemandChangeRecord> util = new ExcelUtil<LgsDemandChangeRecord>(LgsDemandChangeRecord.class);
        util.exportExcel(response, list, "需求变更记录数据");
    }

    /**
     * 获取需求变更记录详细信息
     */
    @ApiOperation(value = "获取需求变更记录详细信息", notes = "获取需求变更记录详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(demandChangeRecordService.selectDemandChangeRecordById(id));
    }

    /**
     * 新增需求变更记录
     */
    @ApiOperation(value = "新增需求变更记录", notes = "新增需求变更记录", httpMethod = "POST")
    @Log(title = "需求变更记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsDemandChangeRecord demandChangeRecord)
    {
        return toAjax(demandChangeRecordService.insertDemandChangeRecord(demandChangeRecord));
    }

    /**
     * 修改需求变更记录
     */
    @ApiOperation(value = "修改需求变更记录", notes = "修改需求变更记录", httpMethod = "PUT")
    @Log(title = "需求变更记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsDemandChangeRecord demandChangeRecord)
    {
        return toAjax(demandChangeRecordService.updateDemandChangeRecord(demandChangeRecord));
    }

/*    *//**
     * 删除需求变更记录
     *//*
    @RequiresPermissions("lab:record:remove")
    @Log(title = "需求变更记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(demandChangeRecordService.deleteDemandChangeRecordByIds(ids));
    }*/

    /**
     * 根据变更id查看需求变更记录详细信息
     */
    @ApiOperation(value = "根据变更id查看需求变更记录详细信息", notes = "根据变更id查看需求变更记录详细信息", httpMethod = "GET")
    @GetMapping("/getChangeInfoById")
    public AjaxResult getChangeInfoById(LgsDemandChangeRecord demandChangeRecord)
    {
        return AjaxResult.success(demandChangeRecordService.getChangeInfoById(demandChangeRecord));
    }

    /**
     * 取消/激活需求变更单
     * {"id":7,"isComplete":0,"lgsDemandId":30}
     */
    @ApiOperation(value = "取消/激活需求变更单", notes = "取消/激活需求变更单", httpMethod = "POST")
    @Log(title = "取消/激活需求变更单", businessType = BusinessType.UPDATE)
    @PostMapping("/updateDemandChangeRecordState")
    public AjaxResult updateDemandChangeRecordState(@RequestBody LgsDemandChangeRecord demandChangeRecord)
    {
        return AjaxResult.success(demandChangeRecordService.updateDemandChangeRecordState(demandChangeRecord));
    }
}
