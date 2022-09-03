package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.LgsRetirementManagement;

/**
 * 退役管理Service接口
 * 
 * @author lgn
 * @date 2022-08-02
 */
public interface ILgsRetirementManagementService 
{
    /**
     * 查询退役管理
     * 
     * @param id 退役管理主键
     * @return 退役管理
     */
    public LgsRetirementManagement selectLgsRetirementManagementById(Long id);

    /**
     * 查询退役管理列表
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 退役管理集合
     */
    public List<LgsRetirementManagement> selectLgsRetirementManagementList(LgsRetirementManagement lgsRetirementManagement);

    /**
     * 新增退役管理
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 结果
     */
    public int insertLgsRetirementManagement(LgsRetirementManagement lgsRetirementManagement);

    /**
     * 修改退役管理
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 结果
     */
    public int updateLgsRetirementManagement(LgsRetirementManagement lgsRetirementManagement);

    /**
     * 批量删除退役管理
     * 
     * @param ids 需要删除的退役管理主键集合
     * @return 结果
     */
    public int deleteLgsRetirementManagementByIds(Long[] ids);

    /**
     * 删除退役管理信息
     * 
     * @param id 退役管理主键
     * @return 结果
     */
    public int deleteLgsRetirementManagementById(Long id);
}
