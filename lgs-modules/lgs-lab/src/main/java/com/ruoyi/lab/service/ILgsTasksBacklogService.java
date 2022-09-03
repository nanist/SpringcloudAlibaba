package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.LgsTasksBacklog;

/**
 * 定时任务待办Service接口
 * 
 * @author lgn
 * @date 2022-08-19
 */
public interface ILgsTasksBacklogService 
{
    /**
     * 查询定时任务待办
     * 
     * @param id 定时任务待办主键
     * @return 定时任务待办
     */
    public LgsTasksBacklog selectLgsTasksBacklogById(Long id);

    /**
     * 查询定时任务待办列表
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 定时任务待办集合
     */
    public List<LgsTasksBacklog> selectLgsTasksBacklogList(LgsTasksBacklog lgsTasksBacklog);

    /**
     * 新增定时任务待办
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 结果
     */
    public int insertLgsTasksBacklog(LgsTasksBacklog lgsTasksBacklog);

    /**
     * 修改定时任务待办
     * 
     * @param lgsTasksBacklog 定时任务待办
     * @return 结果
     */
    public int updateLgsTasksBacklog(LgsTasksBacklog lgsTasksBacklog);

    /**
     * 批量删除定时任务待办
     * 
     * @param ids 需要删除的定时任务待办主键集合
     * @return 结果
     */
    public int deleteLgsTasksBacklogByIds(Long[] ids);

    /**
     * 删除定时任务待办信息
     * 
     * @param id 定时任务待办主键
     * @return 结果
     */
    public int deleteLgsTasksBacklogById(Long id);
}
