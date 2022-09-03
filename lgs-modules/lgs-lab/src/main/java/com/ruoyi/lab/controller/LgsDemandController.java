package com.ruoyi.lab.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.system.api.domain.SysDictData;
import com.ruoyi.system.api.domain.SysDictType;
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
import com.ruoyi.lab.domain.LgsDemand;
import com.ruoyi.lab.service.ILgsDemandService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 需求单Controller
 * 
 * @author lgn
 * @date 2022-08-08
 */
@Api(tags = "需求单Controller")
@RestController
@RequestMapping("/demand")
public class LgsDemandController extends BaseController
{
    @Autowired
    private ILgsDemandService lgsDemandService;

    /**
     * 查询需求单列表
     */
    @ApiOperation(value = "查询需求单列表", notes = "查询需求单列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsDemand lgsDemand)
    {
        startPage();
        List<LgsDemand> list = lgsDemandService.selectLgsDemandList(lgsDemand);
        return getDataTable(list);
    }

    /**
     * 导出需求单列表
     */
    @RequiresPermissions("lab:demand:export")
    @Log(title = "需求单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsDemand lgsDemand)
    {
        List<LgsDemand> list = lgsDemandService.selectLgsDemandList(lgsDemand);
        ExcelUtil<LgsDemand> util = new ExcelUtil<LgsDemand>(LgsDemand.class);
        util.exportExcel(response, list, "需求单数据");
    }

    /**
     * 获取需求单详细信息
     */
    @ApiOperation(value = "获取需求单详细信息", notes = "获取需求单详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsDemandService.selectLgsDemandById(id));
    }

    /**
     * 新增需求单
     */
    @ApiOperation(value = "新增需求单", notes = "新增需求单", httpMethod = "POST")
    @Log(title = "需求单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsDemand lgsDemand)
    {
        return toAjax(lgsDemandService.insertLgsDemand(lgsDemand));
    }

    /**
     * 修改需求单
     */
    @ApiOperation(value = "修改需求单", notes = "修改需求单", httpMethod = "PUT")
    @Log(title = "需求单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsDemand lgsDemand)
    {
        return toAjax(lgsDemandService.updateLgsDemand(lgsDemand));
    }

/*    *//**
     * 删除需求单
     *//*
    @RequiresPermissions("lab:demand:remove")
    @Log(title = "需求单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsDemandService.deleteLgsDemandByIds(ids));
    }*/

    /**
     * 获取字典选择框列表
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect()
    {
        JSONObject data = lgsDemandService.selectDictTypeAll();
        return AjaxResult.success(data);
    }

    /**
     * 取消/激活工单
     * {"demandTitle":"华为工作站（已取消）","departmentId":105,"id":3,"isComplete":2,"owner":"张老师"}
     */
    @ApiOperation(value = "取消/激活工单", notes = "取消/激活工单", httpMethod = "POST")
    @Log(title = "取消/激活工单", businessType = BusinessType.UPDATE)
    @PostMapping("/updateDemandState")
    public AjaxResult updateDemandState(@RequestBody LgsDemand lgsDemand)
    {
        return AjaxResult.success(lgsDemandService.updateDemandState(lgsDemand));
    }
}
