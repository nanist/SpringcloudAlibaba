package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsDemandChangeRecord;

/**
 * 需求变更记录Mapper接口
 * 
 * @author lgn
 * @date 2022-08-09
 */
public interface LgsDemandChangeRecordMapper
{
    /**
     * 查询需求变更记录
     * 
     * @param id 需求变更记录主键
     * @return 需求变更记录
     */
    public LgsDemandChangeRecord selectLgsDemandChangeRecordById(Long id);

    /**
     * 查询需求变更记录列表
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 需求变更记录集合
     */
    public List<LgsDemandChangeRecord> selectLgsDemandChangeRecordList(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 新增需求变更记录
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 结果
     */
    public int insertLgsDemandChangeRecord(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 修改需求变更记录
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 结果
     */
    public int updateLgsDemandChangeRecord(LgsDemandChangeRecord demandChangeRecord);

    /**
     * 删除需求变更记录
     * 
     * @param id 需求变更记录主键
     * @return 结果
     */
    public int deleteDemandChangeRecordById(Long id);

    /**
     * 批量删除需求变更记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDemandChangeRecordByIds(Long[] ids);
}
