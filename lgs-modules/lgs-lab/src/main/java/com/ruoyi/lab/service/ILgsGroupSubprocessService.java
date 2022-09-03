package com.ruoyi.lab.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsGroupSubprocess;

/**
 * 分组管理通用子流程Service接口
 * 
 * @author lgn
 * @date 2022-08-10
 */
public interface ILgsGroupSubprocessService 
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
     * 批量删除分组管理通用子流程
     * 
     * @param ids 需要删除的分组管理通用子流程主键集合
     * @return 结果
     */
    public int deleteLgsGroupSubprocessByIds(Long[] ids);

    /**
     * 删除分组管理通用子流程信息
     * 
     * @param id 分组管理通用子流程主键
     * @return 结果
     */
    public int deleteLgsGroupSubprocessById(Long id);

    /**
     * 批量完成子流程
     * @param param
     * @return
     */
    int batchCompleteGroupSubprocess(Map<String, Object> param);
}
