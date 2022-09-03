package com.ruoyi.lab.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsAssetsClient;
import com.ruoyi.lab.domain.LgsAssetsHardware;
import com.ruoyi.lab.domain.LgsAssetsManagement;
import com.ruoyi.lab.domain.LgsAssetsSystem;

import java.util.List;

/**
 * 资产管理Service接口
 * 
 * @author lgn
 * @date 2022-07-28
 */
public interface ILgsAssetsManagementService 
{
    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    public LgsAssetsManagement selectLgsAssetsManagementById(Long id);

    /**
     * 新增资产管理
     * 
     * @param lgsAssetsManagement 资产管理
     * @return 结果
     */
    public int insertLgsAssetsManagement(LgsAssetsManagement lgsAssetsManagement);

    /**
     * 修改资产管理
     * 
     * @param lgsAssetsManagement 资产管理
     * @return 结果
     */
    public int updateLgsAssetsManagement(LgsAssetsManagement lgsAssetsManagement);

    /**
    　　* @description: TODO
    　　* @param 批量保存正式环境搭建
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:16 
    　　*/
    int batchSaveAssets(LgsAssetsSystem lgsAssetsSystem);

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:50 
    　　*/
    int addHardware(LgsAssetsHardware lgsAssetsHardware);

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:51 
    　　*/
    int addClient(LgsAssetsClient lgsAssetsClient);

    /**
    　　* @description: TODO
    　　* @param 修改入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:05 
    　　*/
    int updateHardware(LgsAssetsHardware lgsAssetsHardware);

    /**
    　　* @description: 修改入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:08
    　　*/
    int updateClient(LgsAssetsClient lgsAssetsClient);

    /**
    　　* @description: 根据需求单id获取正式环境搭建详细信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:28
    　　*/
    JSONObject getInfoByDemandId(Long demandId);
}
