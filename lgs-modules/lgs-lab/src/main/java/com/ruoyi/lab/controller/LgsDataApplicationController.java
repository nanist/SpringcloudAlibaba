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
import com.ruoyi.lab.domain.LgsDataApplication;
import com.ruoyi.lab.service.ILgsDataApplicationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 数据备份/还原申请Controller
 * 
 * @author lgn
 * @date 2022-08-30
 */
@Api(tags = "入组管理-数据备份/还原申请Controller")
@RestController
@RequestMapping("/application")
public class LgsDataApplicationController extends BaseController
{
    @Autowired
    private ILgsDataApplicationService lgsDataApplicationService;

    /**
     * 查询数据备份/还原申请列表
     */
    @ApiOperation(value = "查询数据备份/还原申请列表", notes = "查询数据备份/还原申请列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsDataApplication lgsDataApplication)
    {
        startPage();
        List<LgsDataApplication> list = lgsDataApplicationService.selectLgsDataApplicationList(lgsDataApplication);
        return getDataTable(list);
    }

    /**
     * 导出数据备份/还原申请列表
     */
    @RequiresPermissions("lab:application:export")
    @Log(title = "数据备份/还原申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsDataApplication lgsDataApplication)
    {
        List<LgsDataApplication> list = lgsDataApplicationService.selectLgsDataApplicationList(lgsDataApplication);
        ExcelUtil<LgsDataApplication> util = new ExcelUtil<LgsDataApplication>(LgsDataApplication.class);
        util.exportExcel(response, list, "数据备份/还原申请数据");
    }

    /**
     * 获取数据备份/还原申请详细信息
     */
    @ApiOperation(value = "获取数据备份/还原申请详细信息", notes = "获取数据备份/还原申请详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsDataApplicationService.selectLgsDataApplicationById(id));
    }

    /**
     * 新增数据备份/还原申请
     */
    @ApiOperation(value = "新增数据备份/还原申请", notes = "新增数据备份/还原申请", httpMethod = "POST")
    @Log(title = "数据备份/还原申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsDataApplication lgsDataApplication)
    {
        return toAjax(lgsDataApplicationService.insertLgsDataApplication(lgsDataApplication));
    }

    /**
     * 修改数据备份/还原申请
     */
    @ApiOperation(value = "修改数据备份/还原申请", notes = "修改数据备份/还原申请", httpMethod = "PUT")
    @Log(title = "数据备份/还原申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsDataApplication lgsDataApplication)
    {
        return toAjax(lgsDataApplicationService.updateLgsDataApplication(lgsDataApplication));
    }

/*    *//**
     * 删除数据备份/还原申请
     *//*
    @RequiresPermissions("lab:application:remove")
    @Log(title = "数据备份/还原申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsDataApplicationService.deleteLgsDataApplicationByIds(ids));
    }*/
}
