package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsOperationSupport;

/**
 * 运维支持Mapper接口
 * 
 * @author lgn
 * @date 2022-08-02
 */
public interface LgsOperationSupportMapper 
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
     * 删除运维支持
     * 
     * @param id 运维支持主键
     * @return 结果
     */
    public int deleteLgsOperationSupportById(Long id);

    /**
     * 批量删除运维支持
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsOperationSupportByIds(Long[] ids);

    /**
     * 查询所有有效的任务
     * @param lgsOperationSupport
     */
    public List<LgsOperationSupport> selectLgsOperationTaskList(LgsOperationSupport lgsOperationSupport);

    /**
    　　* @description: 查询运维任务列表
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/9/1 17:38
    　　*/
    List<LgsOperationSupport> getOperationlistByDemandId(Long demandId);
}
