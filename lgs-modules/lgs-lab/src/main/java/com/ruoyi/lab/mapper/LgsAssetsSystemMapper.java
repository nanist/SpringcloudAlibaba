package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsAssetsSystem;

/**
 * 资产管理系统信息Mapper接口
 * 
 * @author lgn
 * @date 2022-08-11
 */
public interface LgsAssetsSystemMapper 
{
    /**
     * 查询资产管理系统信息
     * 
     * @param id 资产管理系统信息主键
     * @return 资产管理系统信息
     */
    public LgsAssetsSystem selectLgsAssetsSystemById(Long id);

    /**
     * 查询资产管理系统信息列表
     * 
     * @param lgsAssetsSystem 资产管理系统信息
     * @return 资产管理系统信息集合
     */
    public List<LgsAssetsSystem> selectLgsAssetsSystemList(LgsAssetsSystem lgsAssetsSystem);

    /**
     * 新增资产管理系统信息
     * 
     * @param lgsAssetsSystem 资产管理系统信息
     * @return 结果
     */
    public int insertLgsAssetsSystem(LgsAssetsSystem lgsAssetsSystem);

    /**
     * 修改资产管理系统信息
     * 
     * @param lgsAssetsSystem 资产管理系统信息
     * @return 结果
     */
    public int updateLgsAssetsSystem(LgsAssetsSystem lgsAssetsSystem);

    /**
     * 删除资产管理系统信息
     * 
     * @param id 资产管理系统信息主键
     * @return 结果
     */
    public int deleteLgsAssetsSystemById(Long id);

    /**
     * 批量删除资产管理系统信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsAssetsSystemByIds(Long[] ids);
}
