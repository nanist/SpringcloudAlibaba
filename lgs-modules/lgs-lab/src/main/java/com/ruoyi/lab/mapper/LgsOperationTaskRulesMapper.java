package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsOperationTaskRules;

/**
 * 运维任务规则Mapper接口
 * 
 * @author lgn
 * @date 2022-08-18
 */
public interface LgsOperationTaskRulesMapper 
{
    /**
     * 查询运维任务规则
     * 
     * @param id 运维任务规则主键
     * @return 运维任务规则
     */
    public LgsOperationTaskRules selectLgsOperationTaskRulesById(Long id);

    /**
     * 查询运维任务规则列表
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 运维任务规则集合
     */
    public List<LgsOperationTaskRules> selectLgsOperationTaskRulesList(LgsOperationTaskRules lgsOperationTaskRules);

    /**
     * 新增运维任务规则
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 结果
     */
    public int insertLgsOperationTaskRules(LgsOperationTaskRules lgsOperationTaskRules);

    /**
     * 修改运维任务规则
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 结果
     */
    public int updateLgsOperationTaskRules(LgsOperationTaskRules lgsOperationTaskRules);

    /**
     * 删除运维任务规则
     * 
     * @param id 运维任务规则主键
     * @return 结果
     */
    public int deleteLgsOperationTaskRulesById(Long id);

    /**
     * 批量删除运维任务规则
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsOperationTaskRulesByIds(Long[] ids);

    /**
     * 初始化默认的定时任务
     * @param lgsOperationTaskRules
     */
    void initializationTaskRules(LgsOperationTaskRules lgsOperationTaskRules);
}
