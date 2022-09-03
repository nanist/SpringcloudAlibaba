package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsGroupMapping;

/**
 * 需求单入组管理映射Mapper接口
 * 
 * @author lgn
 * @date 2022-08-29
 */
public interface LgsGroupMappingMapper 
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
     * 删除需求单入组管理映射
     * 
     * @param id 需求单入组管理映射主键
     * @return 结果
     */
    public int deleteLgsGroupMappingById(Long id);

    /**
     * 批量删除需求单入组管理映射
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsGroupMappingByIds(Long[] ids);
}
