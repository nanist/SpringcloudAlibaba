package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsAssetsClient;

/**
 * 资产管理客户端信息Mapper接口
 * 
 * @author lgn
 * @date 2022-08-11
 */
public interface LgsAssetsClientMapper 
{
    /**
     * 查询资产管理客户端信息
     * 
     * @param id 资产管理客户端信息主键
     * @return 资产管理客户端信息
     */
    public LgsAssetsClient selectLgsAssetsClientById(Long id);

    /**
     * 查询资产管理客户端信息列表
     * 
     * @param lgsAssetsClient 资产管理客户端信息
     * @return 资产管理客户端信息集合
     */
    public List<LgsAssetsClient> selectLgsAssetsClientList(LgsAssetsClient lgsAssetsClient);

    /**
     * 新增资产管理客户端信息
     * 
     * @param lgsAssetsClient 资产管理客户端信息
     * @return 结果
     */
    public int insertLgsAssetsClient(LgsAssetsClient lgsAssetsClient);

    /**
     * 修改资产管理客户端信息
     * 
     * @param lgsAssetsClient 资产管理客户端信息
     * @return 结果
     */
    public int updateLgsAssetsClient(LgsAssetsClient lgsAssetsClient);

    /**
     * 删除资产管理客户端信息
     * 
     * @param id 资产管理客户端信息主键
     * @return 结果
     */
    public int deleteLgsAssetsClientById(Long id);

    /**
     * 批量删除资产管理客户端信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsAssetsClientByIds(Long[] ids);
}
