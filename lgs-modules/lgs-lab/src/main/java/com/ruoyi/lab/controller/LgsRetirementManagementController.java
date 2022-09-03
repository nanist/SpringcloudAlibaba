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
import com.ruoyi.lab.domain.LgsRetirementManagement;
import com.ruoyi.lab.service.ILgsRetirementManagementService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 退役管理Controller
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Api(tags = "退役管理Controller")
@RestController
@RequestMapping("/retirement")
public class LgsRetirementManagementController extends BaseController
{
    @Autowired
    private ILgsRetirementManagementService lgsRetirementManagementService;

    /**
     * 查询退役管理列表
     */
    @ApiOperation(value = "查询退役管理列表", notes = "查询退役管理列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsRetirementManagement lgsRetirementManagement)
    {
        startPage();
        List<LgsRetirementManagement> list = lgsRetirementManagementService.selectLgsRetirementManagementList(lgsRetirementManagement);
        return getDataTable(list);
    }

    /**
     * 导出退役管理列表
     */
    @RequiresPermissions("lab:retirement:export")
    @Log(title = "退役管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsRetirementManagement lgsRetirementManagement)
    {
        List<LgsRetirementManagement> list = lgsRetirementManagementService.selectLgsRetirementManagementList(lgsRetirementManagement);
        ExcelUtil<LgsRetirementManagement> util = new ExcelUtil<LgsRetirementManagement>(LgsRetirementManagement.class);
        util.exportExcel(response, list, "退役管理数据");
    }

    /**
     * 获取退役管理详细信息
     */
    @ApiOperation(value = "获取退役管理详细信息", notes = "获取退役管理详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsRetirementManagementService.selectLgsRetirementManagementById(id));
    }

    /**
     * 新增退役管理
     */
    @ApiOperation(value = "新增退役管理", notes = "新增退役管理", httpMethod = "POST")
    @Log(title = "退役管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsRetirementManagement lgsRetirementManagement)
    {
        return toAjax(lgsRetirementManagementService.insertLgsRetirementManagement(lgsRetirementManagement));
    }

    /**
     * 修改退役管理
     */
    @ApiOperation(value = "修改退役管理", notes = "修改退役管理", httpMethod = "PUT")
    @Log(title = "退役管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsRetirementManagement lgsRetirementManagement)
    {
        return toAjax(lgsRetirementManagementService.updateLgsRetirementManagement(lgsRetirementManagement));
    }

    /**
     * 删除退役管理
     */
/*    @ApiOperation(value = "删除退役管理", notes = "删除退役管理", httpMethod = "DELETE")
    @Log(title = "退役管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsRetirementManagementService.deleteLgsRetirementManagementByIds(ids));
    }*/
}
