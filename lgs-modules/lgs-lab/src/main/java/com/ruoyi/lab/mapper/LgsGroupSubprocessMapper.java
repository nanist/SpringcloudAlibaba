package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsGroupSubprocess;

/**
 * 分组管理通用子流程Mapper接口
 * 
 * @author lgn
 * @date 2022-08-10
 */
public interface LgsGroupSubprocessMapper 
{
    /**
     * 查询分组管理通用子流程
     * 
     * @param id 分组管理通用子流程主键
     * @return 分组管理通用子流程
     */
    public LgsGroupSubprocess selectLgsGroupSubprocessById(Long id);

    /**
     * 查询分组管理通用子流程列表
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 分组管理通用子流程集合
     */
    public List<LgsGroupSubprocess> selectLgsGroupSubprocessList(LgsGroupSubprocess lgsGroupSubprocess);

    /**
     * 新增分组管理通用子流程
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 结果
     */
    public int insertLgsGroupSubprocess(LgsGroupSubprocess lgsGroupSubprocess);

    /**
     * 修改分组管理通用子流程
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 结果
     */
    public int updateLgsGroupSubprocess(LgsGroupSubprocess lgsGroupSubprocess);

    /**
     * 删除分组管理通用子流程
     * 
     * @param id 分组管理通用子流程主键
     * @return 结果
     */
    public int deleteLgsGroupSubprocessById(Long id);

    /**
     * 批量删除分组管理通用子流程
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsGroupSubprocessByIds(Long[] ids);

    /**
     * 批量完成子流程
     * @param list
     * @return
     */
    int batchCompleteGroupSubprocess(List<Long> list);

    /**
     * 批量完成子流程
     * @param lgsGroupSubprocess
     * @return
     */
    int batchCompleteGroupSubprocess(LgsGroupSubprocess lgsGroupSubprocess);

    List<LgsGroupSubprocess> getGroupMappingInfoByDemandId(LgsGroupSubprocess subprocess);
}
