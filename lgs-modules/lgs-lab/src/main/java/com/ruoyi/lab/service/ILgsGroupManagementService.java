package com.ruoyi.lab.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsDemandGroup;
import com.ruoyi.lab.domain.LgsGroupManagement;

/**
 * 入组管理Service接口
 * 
 * @author lgn
 * @date 2022-08-02
 */
public interface ILgsGroupManagementService 
{
    /**
     * 查询入组管理
     * 
     * @param id 入组管理主键
     * @return 入组管理
     */
    public LgsGroupManagement selectLgsGroupManagementById(Long id);

    /**
     * 查询入组管理列表
     * 
     * @param lgsGroupManagement 入组管理
     * @return 入组管理集合
     */
    public List<LgsGroupManagement> selectLgsGroupManagementList(LgsGroupManagement lgsGroupManagement);

    /**
     * 新增入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    public int insertLgsGroupManagement(LgsGroupManagement lgsGroupManagement);

    /**
     * 修改入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    public int updateLgsGroupManagement(LgsGroupManagement lgsGroupManagement);

    /**
     * 批量删除入组管理
     * 
     * @param ids 需要删除的入组管理主键集合
     * @return 结果
     */
    public int deleteLgsGroupManagementByIds(Long[] ids);

    /**
     * 删除入组管理信息
     * 
     * @param id 入组管理主键
     * @return 结果
     */
    public int deleteLgsGroupManagementById(Long id);

    /**
     * 查询分组管理通用子流程详情
     * @param lgsGroup
     * @return
     */
    JSONObject getSubprocessInfo(LgsGroupManagement lgsGroup);

    /**
    　　* @description: TODO
    　　* @param 入组管理子流程标记完成
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/30 13:58 
    　　*/
    int groupSubprocessComplete(LgsDemandGroup demandGroup);

    /**
    　　* @description: TODO
    　　* @param 获取入组管理子流程进度列表
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/30 14:06 
    　　*/
    List<LgsGroupManagement> groupSubprocessList(LgsGroupManagement lgsGroup);

    /**
    　　* @description: 入组管理流程完毕-设备放行
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 17:23
    　　*/
    int groupSubprocessCompleteAndRelease(LgsDemandGroup demandGroup);
}
