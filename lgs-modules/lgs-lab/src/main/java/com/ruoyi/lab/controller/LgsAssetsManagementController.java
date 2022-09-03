package com.ruoyi.lab.controller;

import java.util.List;

import com.ruoyi.lab.domain.*;
import com.ruoyi.lab.service.ILgsAssetsManagementService;
import com.ruoyi.lab.service.ILgsGroupManagementService;
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
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;

/**
 * 正式环境搭建Controller
 * 
 * @author lgn
 * @date 2022-07-28
 */
@Api(tags = "入组管理-正式环境搭建Controller")
@RestController
@RequestMapping("/assets")
public class LgsAssetsManagementController extends BaseController
{
    @Autowired
    private ILgsAssetsManagementService lgsAssetsManagementService;
    @Autowired
    private ILgsGroupManagementService lgsGroupManagementService;
    /**
     * 获取正式环境搭建详细信息
     */
    //@RequiresPermissions("lab:management:query")
    @ApiOperation(value = "获取正式环境搭建详细信息", notes = "获取正式环境搭建详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lgsAssetsManagementService.selectLgsAssetsManagementById(id));
    }

    /**
    　　* @description: 根据需求单id获取正式环境搭建详细信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:27
    　　*/
    @ApiOperation(value = "根据需求单id获取正式环境搭建详细信息", notes = "获取正式环境搭建详细信息", httpMethod = "GET")
    @GetMapping(value = "ByDemandId/{demandId}")
    public AjaxResult getInfoByDemandId(@PathVariable("demandId") Long demandId)
    {
        return AjaxResult.success(lgsAssetsManagementService.getInfoByDemandId(demandId));
    }

    /**
     * 新增正式环境搭建
     */
    //@RequiresPermissions("lab:management:add")
    @ApiOperation(value = "新增正式环境搭建", notes = "新增正式环境搭建", httpMethod = "POST")
    @PostMapping
    public AjaxResult add(@RequestBody LgsAssetsManagement lgsAssetsManagement)
    {
        return toAjax(lgsAssetsManagementService.insertLgsAssetsManagement(lgsAssetsManagement));
    }

    /**
     * 修改正式环境搭建
     */
    //@RequiresPermissions("lab:management:edit")
    @ApiOperation(value = "修改正式环境搭建", notes = "修改正式环境搭建", httpMethod = "PUT")
    @PutMapping
    public AjaxResult edit(@RequestBody LgsAssetsManagement lgsAssetsManagement)
    {
        return toAjax(lgsAssetsManagementService.updateLgsAssetsManagement(lgsAssetsManagement));
    }

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:48 
    　　*/
    @ApiOperation(value = "新增入组管理正式环境搭建实验室计算机信息", notes = "新增入组管理正式环境搭建实验室计算机信息", httpMethod = "POST")
    @PostMapping(value = "addHardware")
    public AjaxResult addHardware(@RequestBody LgsAssetsHardware lgsAssetsHardware)
    {
        return AjaxResult.success(lgsAssetsManagementService.addHardware(lgsAssetsHardware));
    }

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:48
    　　*/
    @ApiOperation(value = "新增入组管理正式环境搭建服务器信息/单机版计算机信息", notes = "新增入组管理正式环境搭建服务器信息/单机版计算机信息", httpMethod = "POST")
    @PostMapping(value = "addClient")
    public AjaxResult addClient(@RequestBody LgsAssetsClient lgsAssetsClient)
    {
        return AjaxResult.success(lgsAssetsManagementService.addClient(lgsAssetsClient));
    }

    /**
    　　* @description: TODO
    　　* @param 修改入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:04 
    　　*/
    @ApiOperation(value = "修改入组管理正式环境搭建实验室计算机信息", notes = "修改入组管理正式环境搭建实验室计算机信息", httpMethod = "POST")
    @PostMapping(value = "updateHardware")
    public AjaxResult updateHardware(@RequestBody LgsAssetsHardware lgsAssetsHardware)
    {
        return AjaxResult.success(lgsAssetsManagementService.updateHardware(lgsAssetsHardware));
    }

    /**
    　　* @description: 修改入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:07
    　　*/
    @ApiOperation(value = "修改入组管理正式环境搭建服务器信息/单机版计算机信息", notes = "修改入组管理正式环境搭建服务器信息/单机版计算机信息", httpMethod = "POST")
    @PostMapping(value = "updateClient")
    public AjaxResult updateClient(@RequestBody LgsAssetsClient lgsAssetsClient)
    {
        return AjaxResult.success(lgsAssetsManagementService.updateClient(lgsAssetsClient));
    }

    /**
    　　* @description: TODO
    　　* @param 批量保存正式环境搭建
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 11:32 
    　　*/
    @ApiOperation(value = "批量保存正式环境搭建", notes = "批量保存正式环境搭建", httpMethod = "POST")
    @PostMapping(value = "batchSaveAssets")
    public AjaxResult batchSaveAssets(@RequestBody LgsAssetsSystem lgsAssetsSystem)
    {
        return AjaxResult.success(lgsAssetsManagementService.batchSaveAssets(lgsAssetsSystem));
    }

    /**
    　　* @description: 批量保存正式环境搭建并完成该流程
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 15:06
    　　*/
    @ApiOperation(value = "批量保存正式环境搭建并完成该流程", notes = "批量保存正式环境搭建并完成该流程", httpMethod = "POST")
    @PostMapping(value = "batchSaveAssetsAndComplete")
    public AjaxResult batchSaveAssetsAndComplete(@RequestBody LgsAssetsSystem lgsAssetsSystem,Integer demandId,Integer groupManagementId)
    {
        int i=lgsAssetsManagementService.batchSaveAssets(lgsAssetsSystem);
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
