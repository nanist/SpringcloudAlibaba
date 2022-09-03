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
import com.ruoyi.lab.domain.LgsOperationPersonnel;
import com.ruoyi.lab.service.ILgsOperationPersonnelService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 运维人员信息Controller
 * 
 * @author lgn
 * @date 2022-08-11
 */
@Api(tags = "入组管理-资产管理-运维人员信息Controller")
@RestController
@RequestMapping("/personnel")
public class LgsOperationPersonnelController extends BaseController
{
    @Autowired
    private ILgsOperationPersonnelService lgsOperationPersonnelService;

    /**
     * 查询运维人员信息列表
     */
    @ApiOperation(value = "查询运维人员信息列表", notes = "查询运维人员信息列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsOperationPersonnel lgsOperationPersonnel)
    {
        startPage();
        List<LgsOperationPersonnel> list = lgsOperationPersonnelService.selectLgsOperationPersonnelList(lgsOperationPersonnel);
        return getDataTable(list);
    }

    /**
     * 导出运维人员信息列表
     */
    @Log(title = "运维人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsOperationPersonnel lgsOperationPersonnel)
    {
        List<LgsOperationPersonnel> list = lgsOperationPersonnelService.selectLgsOperationPersonnelList(lgsOperationPersonnel);
        ExcelUtil<LgsOperationPersonnel> util = new ExcelUtil<LgsOperationPersonnel>(LgsOperationPersonnel.class);
        util.exportExcel(response, list, "运维人员信息数据");
    }

    /**
     * 获取运维人员信息详细信息
     */
    @ApiOperation(value = "获取运维人员信息详细信息", notes = "获取运维人员信息详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsOperationPersonnelService.selectLgsOperationPersonnelById(id));
    }

    /**
     * 新增运维人员信息
     */
    @ApiOperation(value = "新增运维人员信息", notes = "新增运维人员信息", httpMethod = "POST")
    @Log(title = "运维人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsOperationPersonnel lgsOperationPersonnel)
    {
        return toAjax(lgsOperationPersonnelService.insertLgsOperationPersonnel(lgsOperationPersonnel));
    }

    /**
     * 修改运维人员信息
     */
    @ApiOperation(value = "修改运维人员信息", notes = "修改运维人员信息", httpMethod = "PUT")
    @Log(title = "运维人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsOperationPersonnel lgsOperationPersonnel)
    {
        return toAjax(lgsOperationPersonnelService.updateLgsOperationPersonnel(lgsOperationPersonnel));
    }

/*    *//**
     * 删除运维人员信息
     *//*
    @RequiresPermissions("lab:personnel:remove")
    @Log(title = "运维人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsOperationPersonnelService.deleteLgsOperationPersonnelByIds(ids));
    }*/

    /**
     * 查询运维人员信息详细信息
     * @param lgsOperationPersonnel
     * @return
     */
    @ApiOperation(value = "查询运维人员信息详细信息", notes = "查询运维人员信息详细信息", httpMethod = "GET")
    @GetMapping("/getOperationPersonnel")
    public AjaxResult getOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel) {
        return AjaxResult.success(lgsOperationPersonnelService.getOperationPersonnel(lgsOperationPersonnel));
    }

}
