package com.ruoyi.lab.controller;

import java.util.List;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.lab.service.IlgsEmailService;
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
import com.ruoyi.lab.domain.LgsMail;
import com.ruoyi.lab.service.ILgsMailService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 站内信Controller
 * 
 * @author lgn
 * @date 2022-08-05
 */
@Api(tags = "站内信Controller")
@RestController
@RequestMapping("/mail")
public class LgsMailController extends BaseController
{
    @Autowired
    private ILgsMailService lgsMailService;
    @Autowired
    private IlgsEmailService lgsEmailService;
    /**
     * 查询站内信列表
     */
    @ApiOperation(value = "查询站内信列表", notes = "查询站内信列表", httpMethod = "GET")
    @GetMapping("/list")
    public TableDataInfo list(LgsMail lgsMail)
    {
        startPage();
        List<LgsMail> list = lgsMailService.selectLgsMailList(lgsMail);
        return getDataTable(list);
    }

    /**
     * 导出站内信列表
     */
    @RequiresPermissions("lab:mail:export")
    @Log(title = "站内信", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LgsMail lgsMail)
    {
        List<LgsMail> list = lgsMailService.selectLgsMailList(lgsMail);
        ExcelUtil<LgsMail> util = new ExcelUtil<LgsMail>(LgsMail.class);
        util.exportExcel(response, list, "站内信数据");
    }

    /**
     * 获取站内信详细信息
     */
    @ApiOperation(value = "获取站内信详细信息", notes = "获取站内信详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsMailService.selectLgsMailById(id));
    }

    /**
     * 新增站内信
     */
    @ApiOperation(value = "新增站内信", notes = "新增站内信", httpMethod = "POST")
    @Log(title = "站内信", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LgsMail lgsMail)
    {
        return toAjax(lgsMailService.insertLgsMail(lgsMail));
    }

    /**
     * 修改站内信
     */
    @ApiOperation(value = "修改站内信", notes = "修改站内信", httpMethod = "PUT")
    @Log(title = "站内信", businessType = BusinessType.UPDATE)
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody LgsMail lgsMail)
    {
        return toAjax(lgsMailService.updateLgsMail(lgsMail));
    }

    /**
     * 删除站内信
     */
    @RequiresPermissions("lab:mail:remove")
    @Log(title = "站内信", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lgsMailService.deleteLgsMailByIds(ids));
    }

    /**
     * 失败邮件获取接口
     */
    @ApiOperation(value = "失败邮件获取接口", notes = "失败邮件获取接口", httpMethod = "POST")
    @PostMapping("/getFailedEmailList")
    public AjaxResult getFailedEmailList(@RequestBody Map<String, String> map)
    {
        return AjaxResult.success(lgsEmailService.GetFailedEmailList(map));
    }

   /**
     * 邮件发送接口
     */
    @ApiOperation(value = "邮件发送接口", notes = "邮件发送接口", httpMethod = "POST")
    @Log(title = "邮件发送接口", businessType = BusinessType.INSERT)
    @PostMapping("/sendEmail")
    public AjaxResult sendEmail(@RequestBody Map<String, String> map)
    {
        return AjaxResult.success(lgsEmailService.SendEmail(map));
    }
}
