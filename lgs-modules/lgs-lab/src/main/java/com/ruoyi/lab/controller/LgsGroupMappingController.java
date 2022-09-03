package com.ruoyi.lab.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.lab.domain.LgsDemandGroup;
import com.ruoyi.lab.service.ILgsGroupManagementService;
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
import com.ruoyi.lab.domain.LgsGroupMapping;
import com.ruoyi.lab.service.ILgsGroupMappingService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 需求单入组管理映射Controller
 * 
 * @author lgn
 * @date 2022-08-29
 */
@Api(tags = "需求单入组管理映射Controller")
@RestController
@RequestMapping("/group_mapping")
public class LgsGroupMappingController extends BaseController
{
    @Autowired
    private ILgsGroupMappingService lgsGroupMappingService;
    @Autowired
    private ILgsGroupManagementService lgsGroupManagementService;
    /**
     * 查询需求单入组管理映射列表
     */
    @ApiOperation(value = "查询需求单入组管理映射列表", notes = "查询需求单入组管理映射列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsGroupMapping lgsGroupMapping)
    {
        startPage();
        List<LgsGroupMapping> list = lgsGroupMappingService.selectLgsGroupMappingList(lgsGroupMapping);
        return getDataTable(list);
    }

    /**
     * 导出需求单入组管理映射列表
     */
    @RequiresPermissions("lab:group_mapping:export")
    @Log(title = "需求单入组管理映射", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsGroupMapping lgsGroupMapping)
    {
        List<LgsGroupMapping> list = lgsGroupMappingService.selectLgsGroupMappingList(lgsGroupMapping);
        ExcelUtil<LgsGroupMapping> util = new ExcelUtil<LgsGroupMapping>(LgsGroupMapping.class);
        util.exportExcel(response, list, "需求单入组管理映射数据");
    }

    /**
     * 获取需求单入组管理映射详细信息
     */
    @ApiOperation(value = "获取需求单入组管理映射详细信息", notes = "获取需求单入组管理映射详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsGroupMappingService.selectLgsGroupMappingById(id));
    }

    /**
     * 新增需求单入组管理映射
     */
    @ApiOperation(value = "需求单入组管理映射", notes = "需求单入组管理映射", httpMethod = "POST")
    @Log(title = "需求单入组管理映射", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsGroupMapping lgsGroupMapping)
    {
        return toAjax(lgsGroupMappingService.insertLgsGroupMapping(lgsGroupMapping));
    }

    /**
     * 完成需求单入组管理映射
     */
    @ApiOperation(value = "完成需求单入组管理映射", notes = "完成需求单入组管理映射", httpMethod = "PUT")
    @Log(title = "完成需求单入组管理映射", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsGroupMapping lgsGroupMapping)
    {
        return toAjax(lgsGroupMappingService.updateLgsGroupMapping(lgsGroupMapping));
    }

/*    *//**
     * 删除需求单入组管理映射
     *//*
    @RequiresPermissions("lab:group_mapping:remove")
    @Log(title = "需求单入组管理映射", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsGroupMappingService.deleteLgsGroupMappingByIds(ids));
    }*/

    /**
     * 根据需求单id获取需求单入组管理映射详细信息
     */
    @ApiOperation(value = "根据需求单id获取需求单入组管理映射详细信息", notes = "根据需求单id获取需求单入组管理映射详细信息", httpMethod = "POST")
    @PostMapping(value = "getGroupMappingInfoByDemandId")
    public AjaxResult getGroupMappingInfoByDemandId(@RequestBody LgsGroupMapping lgsGroupMapping)
    {
        return AjaxResult.success(lgsGroupMappingService.getGroupMappingInfoByDemandId(lgsGroupMapping));
    }

    /**
    　　* @description: TODO
    　　* @param 批量保存子任务
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 18:35 
    　　*/
    @ApiOperation(value = "批量保存子任务", notes = "批量保存子任务", httpMethod = "POST")
    @PostMapping(value = "batchSaveGroupMapping")
    public AjaxResult batchSaveGroupMapping(@RequestBody List<LgsGroupMapping> list)
    {
        return AjaxResult.success(lgsGroupMappingService.batchSaveGroupMapping(list));
    }

    /**
    　　* @description: TODO
    　　* @param 批量保存流程子任务并完成该流程
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 10:49
    　　*/
    @ApiOperation(value = "批量保存流程子任务并完成该流程", notes = "批量保存流程子任务并完成该流程", httpMethod = "POST")
    @PostMapping(value = "batchSaveGroupMappingAndComplete")
    public AjaxResult batchSaveGroupMappingAndComplete(@RequestBody List<LgsGroupMapping> list,Integer demandId,Integer groupManagementId)
    {
        int i=lgsGroupMappingService.batchSaveGroupMapping(list);
        if (i>0){
            if (null!= demandId && null !=groupManagementId){
                LgsDemandGroup demandGroup=new LgsDemandGroup();
                demandGroup.setDemandId(demandId.longValue());
                demandGroup.setGroupManagementId(groupManagementId.longValue());
                AjaxResult.success(lgsGroupManagementService.groupSubprocessComplete(demandGroup));
            }
        }else {
            AjaxResult.error();
        }
        return AjaxResult.success();
    }
}
