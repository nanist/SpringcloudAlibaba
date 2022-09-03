package com.ruoyi.lab.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsGroupMapping;
import com.ruoyi.lab.domain.LgsGroupSubprocess;

/**
 * 需求单入组管理映射Service接口
 * 
 * @author lgn
 * @date 2022-08-29
 */
public interface ILgsGroupMappingService 
{
    /**
     * 查询需求单入组管理映射
     * 
     * @param id 需求单入组管理映射主键
     * @return 需求单入组管理映射
     */
    public LgsGroupMapping selectLgsGroupMappingById(Long id);

    /**
     * 查询需求单入组管理映射列表
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 需求单入组管理映射集合
     */
    public List<LgsGroupMapping> selectLgsGroupMappingList(LgsGroupMapping lgsGroupMapping);

    /**
     * 新增需求单入组管理映射
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 结果
     */
    public int insertLgsGroupMapping(LgsGroupMapping lgsGroupMapping);

    /**
     * 修改需求单入组管理映射
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 结果
     */
    public int updateLgsGroupMapping(LgsGroupMapping lgsGroupMapping);

    /**
     * 批量删除需求单入组管理映射
     * 
     * @param ids 需要删除的需求单入组管理映射主键集合
     * @return 结果
     */
    public int deleteLgsGroupMappingByIds(Long[] ids);

    /**
     * 删除需求单入组管理映射信息
     * 
     * @param id 需求单入组管理映射主键
     * @return 结果
     */
    public int deleteLgsGroupMappingById(Long id);

    /**
    　　* @description: TODO
    　　* @param 获取需求单入组管理映射详细信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 11:17
    　　*/
    List<LgsGroupSubprocess> getGroupMappingInfoByDemandId(LgsGroupMapping lgsGroupMapping);

    /**
    　　* @description: TODO
    　　* @param 批量保存子任务
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 18:37 
    　　*/
    int batchSaveGroupMapping(List<LgsGroupMapping> list);
}
