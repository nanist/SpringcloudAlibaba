package com.ruoyi.lab.service.impl;

import java.util.List;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsTasksBacklogMapper;
import com.ruoyi.lab.domain.LgsTasksBacklog;
import com.ruoyi.lab.service.ILgsTasksBacklogService;

/**
 * 定时任务待办Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-19
 */
@Service
public class LgsTasksBacklogServiceImpl implements ILgsTasksBacklogService 
{
    @Autowired
    private LgsTasksBacklogMapper lgsTasksBacklogMapper;

    /**
     * 查询定时任务待办
     * 
     * @param id 定时任务待办主键
     * @return 定时任务待办
     */
    @Override
    public LgsTasksBacklog selectLgsTasksBacklogById(Long id)
    {
        return lgsTasksBacklogMapper.selectLgsTasksBacklogById(id);
    }

    /**
     * 查询定时任务待办列表
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 定时任务待办
     */
    @Override
    public List<LgsTasksBacklog> selectLgsTasksBacklogList(LgsTasksBacklog lgsTasksBacklog)
    {
        return lgsTasksBacklogMapper.selectLgsTasksBacklogList(lgsTasksBacklog);
    }

    /**
     * 新增定时任务待办
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 结果
     */
    @Override
    public int insertLgsTasksBacklog(LgsTasksBacklog lgsTasksBacklog)
    {
        lgsTasksBacklog.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsTasksBacklogMapper.insertLgsTasksBacklog(lgsTasksBacklog);
    }

    /**
     * 修改定时任务待办
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 结果
     */
    @Override
    public int updateLgsTasksBacklog(LgsTasksBacklog lgsTasksBacklog)
    {
        lgsTasksBacklog.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsTasksBacklogMapper.updateLgsTasksBacklog(lgsTasksBacklog);
    }

    /**
     * 批量删除定时任务待办
     * 
     * @param ids 需要删除的定时任务待办主键
     * @return 结果
     */
    @Override
    public int deleteLgsTasksBacklogByIds(Long[] ids)
    {
        return lgsTasksBacklogMapper.deleteLgsTasksBacklogByIds(ids);
    }

    /**
     * 删除定时任务待办信息
     * 
     * @param id 定时任务待办主键
     * @return 结果
     */
    @Override
    public int deleteLgsTasksBacklogById(Long id)
    {
        return lgsTasksBacklogMapper.deleteLgsTasksBacklogById(id);
    }
}
