package com.ruoyi.lab.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.lab.domain.LgsDemandGroup;
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
import com.ruoyi.lab.domain.LgsGroupManagement;
import com.ruoyi.lab.service.ILgsGroupManagementService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 入组管理Controller
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Api(tags = "入组管理Controller")
@RestController
@RequestMapping("/group")
public class LgsGroupManagementController extends BaseController
{
    @Autowired
    private ILgsGroupManagementService lgsGroupManagementService;

    /**
     * 查询入组管理列表
     */
    @ApiOperation(value = "查询入组管理列表", notes = "查询入组管理列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsGroupManagement lgsGroupManagement)
    {
        startPage();
        List<LgsGroupManagement> list = lgsGroupManagementService.selectLgsGroupManagementList(lgsGroupManagement);
        return getDataTable(list);
    }

    /**
     * 导出入组管理列表
     */
    @RequiresPermissions("lab:group:export")
    @Log(title = "入组管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsGroupManagement lgsGroupManagement)
    {
        List<LgsGroupManagement> list = lgsGroupManagementService.selectLgsGroupManagementList(lgsGroupManagement);
        ExcelUtil<LgsGroupManagement> util = new ExcelUtil<LgsGroupManagement>(LgsGroupManagement.class);
        util.exportExcel(response, list, "入组管理数据");
    }

    /**
     * 获取入组管理详细信息
     */
    @ApiOperation(value = "获取入组管理详细信息", notes = "获取入组管理详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsGroupManagementService.selectLgsGroupManagementById(id));
    }

    /**
     * 新增入组管理
     */
    @ApiOperation(value = "新增入组管理", notes = "新增入组管理", httpMethod = "POST")
    @Log(title = "入组管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsGroupManagement lgsGroupManagement)
    {
        return toAjax(lgsGroupManagementService.insertLgsGroupManagement(lgsGroupManagement));
    }

    /**
     * 修改入组管理
     */
    @ApiOperation(value = "修改入组管理", notes = "修改入组管理", httpMethod = "PUT")
    @Log(title = "入组管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsGroupManagement lgsGroupManagement)
    {
        return toAjax(lgsGroupManagementService.updateLgsGroupManagement(lgsGroupManagement));
    }

    /**
     * 删除入组管理
     */
/*    @ApiOperation(value = "删除入组管理", notes = "删除入组管理", httpMethod = "DELETE")
    @Log(title = "入组管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsGroupManagementService.deleteLgsGroupManagementByIds(ids));
    }*/

    /**
     * 查询分组管理通用子流程详情
     */
    @ApiOperation(value = "查询-IT场地确认/预算申请/采购-流程详情", notes = "查询-IT场地确认/预算申请/采购-流程详情", httpMethod = "GET")
    @GetMapping("/getSubprocessInfo")
    public AjaxResult getSubprocessInfo(LgsGroupManagement lgsGroup)
    {
        return AjaxResult.success(lgsGroupManagementService.getSubprocessInfo(lgsGroup));
    }

    /**
     * 根据需求id获取入组管理子流程进度列表
     * @param lgsGroup
     * @return
     */
    @ApiOperation(value = "根据需求id获取该需求下入组管理子流程进度列表", notes = "根据需求id获取该需求下入组管理子流程进度列表", httpMethod = "GET")
    @GetMapping("/groupSubprocessListByDemandId")
    public AjaxResult groupSubprocessList(LgsGroupManagement lgsGroup)
    {
        return AjaxResult.success(lgsGroupManagementService.groupSubprocessList(lgsGroup));
    }

    /**
     * 入组管理所有子流程标记完成通用接口
     */
    @ApiOperation(value = "入组管理所有子流程标记完成通用接口", notes = "入组管理所有子流程标记完成通用接口", httpMethod = "POST")
    @PostMapping(value = "groupSubprocessComplete")
    public AjaxResult groupSubprocessComplete(@RequestBody LgsDemandGroup demandGroup)
    {
        return AjaxResult.success(lgsGroupManagementService.groupSubprocessComplete(demandGroup));
    }

    /**
    　　* @description: 入组管理资产登记标记完成-进入设备放行
    　　* @param
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 17:20 
    　　*/
    @ApiOperation(value = "入组管理资产登记标记完成-进入设备放行", notes = "入组管理资产登记标记完成-进入设备放行", httpMethod = "POST")
    @PostMapping(value = "groupSubprocessCompleteAndRelease")
    public AjaxResult groupSubprocessCompleteAndRelease(@RequestBody LgsDemandGroup demandGroup)
    {
        return AjaxResult.success(lgsGroupManagementService.groupSubprocessCompleteAndRelease(demandGroup));
    }
}
