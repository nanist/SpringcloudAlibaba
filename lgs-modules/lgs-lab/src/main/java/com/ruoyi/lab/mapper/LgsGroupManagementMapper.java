package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsGroupManagement;

/**
 * 入组管理Mapper接口
 * 
 * @author lgn
 * @date 2022-08-02
 */
public interface LgsGroupManagementMapper 
{
    /**
     * 查询入组管理
     * 
     * @param id 入组管理主键
     * @return 入组管理
     */
    public LgsGroupManagement selectLgsGroupManagementById(Long id);

    /**
     * 查询入组管理列表
     * 
     * @param lgsGroupManagement 入组管理
     * @return 入组管理集合
     */
    public List<LgsGroupManagement> selectLgsGroupManagementList(LgsGroupManagement lgsGroupManagement);

    /**
     * 新增入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    public int insertLgsGroupManagement(LgsGroupManagement lgsGroupManagement);

    /**
     * 修改入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    public int updateLgsGroupManagement(LgsGroupManagement lgsGroupManagement);

    /**
     * 删除入组管理
     * 
     * @param id 入组管理主键
     * @return 结果
     */
    public int deleteLgsGroupManagementById(Long id);

    /**
     * 批量删除入组管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsGroupManagementByIds(Long[] ids);

    /**
    　　* @description: TODO
    　　* @param 获取入组管理子流程进度列表
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/30 14:28
    　　*/
    List<LgsGroupManagement> groupSubprocessList(LgsGroupManagement lgsGroup);
}
