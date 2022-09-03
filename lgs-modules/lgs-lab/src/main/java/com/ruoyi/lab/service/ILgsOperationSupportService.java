package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.LgsOperationSupport;

/**
 * 运维支持Service接口
 * 
 * @author lgn
 * @date 2022-08-02
 */
public interface ILgsOperationSupportService 
{
    /**
     * 查询运维支持
     * 
     * @param id 运维支持主键
     * @return 运维支持
     */
    public LgsOperationSupport selectLgsOperationSupportById(Long id);

    /**
     * 查询运维支持列表
     * 
     * @param lgsOperationSupport 运维支持
     * @return 运维支持集合
     */
    public List<LgsOperationSupport> selectLgsOperationSupportList(LgsOperationSupport lgsOperationSupport);

    /**
     * 新增运维支持
     * 
     * @param lgsOperationSupport 运维支持
     * @return 结果
     */
    public int insertLgsOperationSupport(LgsOperationSupport lgsOperationSupport);

    /**
     * 修改运维支持
     * 
     * @param lgsOperationSupport 运维支持
     * @return 结果
     */
    public int updateLgsOperationSupport(LgsOperationSupport lgsOperationSupport);

    /**
     * 批量删除运维支持
     * 
     * @param ids 需要删除的运维支持主键集合
     * @return 结果
     */
    public int deleteLgsOperationSupportByIds(Long[] ids);

    /**
     * 删除运维支持信息
     * 
     * @param id 运维支持主键
     * @return 结果
     */
    public int deleteLgsOperationSupportById(Long id);

    /**
     * 轮询运维任务
     * @return
     */
    String pollingOperationTask();

    /**
    　　* @description: 查询运维任务列表
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/9/1 17:37
    　　*/
    List<LgsOperationSupport> getOperationlistByDemandId(Long demandId);
}
