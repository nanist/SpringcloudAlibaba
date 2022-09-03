package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.LgsDataApplication;

/**
 * 数据备份/还原申请Service接口
 * 
 * @author lgn
 * @date 2022-08-30
 */
public interface ILgsDataApplicationService 
{
    /**
     * 查询数据备份/还原申请
     * 
     * @param id 数据备份/还原申请主键
     * @return 数据备份/还原申请
     */
    public LgsDataApplication selectLgsDataApplicationById(Long id);

    /**
     * 查询数据备份/还原申请列表
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 数据备份/还原申请集合
     */
    public List<LgsDataApplication> selectLgsDataApplicationList(LgsDataApplication lgsDataApplication);

    /**
     * 新增数据备份/还原申请
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 结果
     */
    public int insertLgsDataApplication(LgsDataApplication lgsDataApplication);

    /**
     * 修改数据备份/还原申请
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 结果
     */
    public int updateLgsDataApplication(LgsDataApplication lgsDataApplication);

    /**
     * 批量删除数据备份/还原申请
     * 
     * @param ids 需要删除的数据备份/还原申请主键集合
     * @return 结果
     */
    public int deleteLgsDataApplicationByIds(Long[] ids);

    /**
     * 删除数据备份/还原申请信息
     * 
     * @param id 数据备份/还原申请主键
     * @return 结果
     */
    public int deleteLgsDataApplicationById(Long id);
}
