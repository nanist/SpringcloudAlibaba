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
import com.ruoyi.lab.domain.LgsOperationSupport;
import com.ruoyi.lab.service.ILgsOperationSupportService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 资产登记-运维任务Controller
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Api(tags = "入组管理-资产登记-运维任务Controller")
@RestController
@RequestMapping("/support")
public class LgsOperationSupportController extends BaseController
{
    @Autowired
    private ILgsOperationSupportService lgsOperationSupportService;

    /**
     * 查询运维支持列表
     */
    @ApiOperation(value = "查询运维支持列表", notes = "查询运维支持列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsOperationSupport lgsOperationSupport)
    {
        startPage();
        List<LgsOperationSupport> list = lgsOperationSupportService.selectLgsOperationSupportList(lgsOperationSupport);
        return getDataTable(list);
    }

    /**
     * 导出运维支持列表
     */
    @RequiresPermissions("lab:support:export")
    @Log(title = "运维支持", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsOperationSupport lgsOperationSupport)
    {
        List<LgsOperationSupport> list = lgsOperationSupportService.selectLgsOperationSupportList(lgsOperationSupport);
        ExcelUtil<LgsOperationSupport> util = new ExcelUtil<LgsOperationSupport>(LgsOperationSupport.class);
        util.exportExcel(response, list, "运维支持数据");
    }

    /**
     * 获取运维支持详细信息
     */
    @ApiOperation(value = "获取运维支持详细信息", notes = "获取运维支持详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsOperationSupportService.selectLgsOperationSupportById(id));
    }

    /**
     * 新增运维支持
     */
    @ApiOperation(value = "新增运维支持", notes = "新增运维支持", httpMethod = "POST")
    @Log(title = "运维支持", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsOperationSupport lgsOperationSupport)
    {
        return toAjax(lgsOperationSupportService.insertLgsOperationSupport(lgsOperationSupport));
    }

    /**
     * 修改运维任务
     */
    @ApiOperation(value = "修改运维任务", notes = "修改运维任务", httpMethod = "PUT")
    @Log(title = "运维支持", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LgsOperationSupport lgsOperationSupport)
    {
        return toAjax(lgsOperationSupportService.updateLgsOperationSupport(lgsOperationSupport));
    }

    /**
     * 删除运维支持
     */
/*    @RequiresPermissions("lab:support:remove")
    @Log(title = "运维支持", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsOperationSupportService.deleteLgsOperationSupportByIds(ids));
    }*/

    /**
     * 根据需求单id查询运维任务列表
     */
    @ApiOperation(value = "根据需求单id查询运维任务列表", notes = "根据需求单id查询运维任务列表", httpMethod = "GET")
    @GetMapping("/getOperationlistByDemandId/{demandId}")
    public TableDataInfo getOperationlistByDemandId(@PathVariable("demandId") Long demandId)
    {
        startPage();
        List<LgsOperationSupport> list = lgsOperationSupportService.getOperationlistByDemandId(demandId);
        return getDataTable(list);
    }

    /**
     * 轮询运维任务
     */
    @ApiOperation(value = "轮询运维任务", notes = "轮询运维任务", httpMethod = "POST")
    @Log(title = "轮询运维任务", businessType = BusinessType.INSERT)
    @PostMapping("/pollingOperationTask")
    public AjaxResult pollingOperationTask()
    {
        return AjaxResult.success(lgsOperationSupportService.pollingOperationTask());
    }


}
