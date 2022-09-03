package com.ruoyi.lab.service.impl;

import java.util.List;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsOperationTaskRulesMapper;
import com.ruoyi.lab.domain.LgsOperationTaskRules;
import com.ruoyi.lab.service.ILgsOperationTaskRulesService;

/**
 * 运维任务规则Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-18
 */
@Service
public class LgsOperationTaskRulesServiceImpl implements ILgsOperationTaskRulesService 
{
    @Autowired
    private LgsOperationTaskRulesMapper lgsOperationTaskRulesMapper;

    /**
     * 查询运维任务规则
     * 
     * @param id 运维任务规则主键
     * @return 运维任务规则
     */
    @Override
    public LgsOperationTaskRules selectLgsOperationTaskRulesById(Long id)
    {
        return lgsOperationTaskRulesMapper.selectLgsOperationTaskRulesById(id);
    }

    /**
     * 查询运维任务规则列表
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 运维任务规则
     */
    @Override
    public List<LgsOperationTaskRules> selectLgsOperationTaskRulesList(LgsOperationTaskRules lgsOperationTaskRules)
    {
        return lgsOperationTaskRulesMapper.selectLgsOperationTaskRulesList(lgsOperationTaskRules);
    }

    /**
     * 新增运维任务规则
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 结果
     */
    @Override
    public int insertLgsOperationTaskRules(LgsOperationTaskRules lgsOperationTaskRules)
    {
        lgsOperationTaskRules.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationTaskRulesMapper.insertLgsOperationTaskRules(lgsOperationTaskRules);
    }

    /**
     * 修改运维任务规则
     * 
     * @param lgsOperationTaskRules 运维任务规则
     * @return 结果
     */
    @Override
    public int updateLgsOperationTaskRules(LgsOperationTaskRules lgsOperationTaskRules)
    {
        lgsOperationTaskRules.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationTaskRulesMapper.updateLgsOperationTaskRules(lgsOperationTaskRules);
    }

    /**
     * 批量删除运维任务规则
     * 
     * @param ids 需要删除的运维任务规则主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationTaskRulesByIds(Long[] ids)
    {
        return lgsOperationTaskRulesMapper.deleteLgsOperationTaskRulesByIds(ids);
    }

    /**
     * 删除运维任务规则信息
     * 
     * @param id 运维任务规则主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationTaskRulesById(Long id)
    {
        return lgsOperationTaskRulesMapper.deleteLgsOperationTaskRulesById(id);
    }

    /**
     * 初始化默认的定时任务
     * @param lgsOperationTaskRules
     */
    @Override
    public void initializationTaskRules(LgsOperationTaskRules lgsOperationTaskRules) {

        LgsOperationTaskRules taskRules=new LgsOperationTaskRules();
        taskRules.setSiteId(lgsOperationTaskRules.getSiteId());//查询该站点下是否有默认任务
        taskRules.setIsInitialization(1);
        List<LgsOperationTaskRules> list=lgsOperationTaskRulesMapper.selectLgsOperationTaskRulesList(taskRules);

        if (list.size()<1){//没有默认任务 需要初始化
            lgsOperationTaskRulesMapper.initializationTaskRules(lgsOperationTaskRules);
        }

    }
}
