package com.ruoyi.lab.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsDemandChangeRecord;

/**
 * 需求变更记录Service接口
 * 
 * @author lgn
 * @date 2022-08-09
 */
public interface ILgsDemandChangeRecordService
{
    /**
     * 查询需求变更记录
     * 
     * @param id 需求变更记录主键
     * @return 需求变更记录
     */
    public LgsDemandChangeRecord selectDemandChangeRecordById(Long id);

    /**
     * 查询需求变更记录列表
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 需求变更记录集合
     */
    public List<LgsDemandChangeRecord> selectDemandChangeRecordList(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 新增需求变更记录
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 结果
     */
    public int insertDemandChangeRecord(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 修改需求变更记录
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 结果
     */
    public int updateDemandChangeRecord(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 批量删除需求变更记录
     * 
     * @param ids 需要删除的需求变更记录主键集合
     * @return 结果
     */
    public int deleteDemandChangeRecordByIds(Long[] ids);

    /**
     * 删除需求变更记录信息
     * 
     * @param id 需求变更记录主键
     * @return 结果
     */
    public int deleteDemandChangeRecordById(Long id);

    /**
     * 根据变更id查看需求变更记录详细信息
     * @param demandChangeRecord
     * @return
     */
    JSONObject getChangeInfoById(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 取消/激活需求变更单
     * @param demandChangeRecord
     * @return
     */
    String updateDemandChangeRecordState(LgsDemandChangeRecord demandChangeRecord);
}
