package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsDemandGroup;

/**
 * 需求管理入组进度Mapper接口
 * 
 * @author lgn
 * @date 2022-08-30
 */
public interface LgsDemandGroupMapper 
{
    /**
     * 查询需求管理入组进度
     * 
     * @param id 需求管理入组进度主键
     * @return 需求管理入组进度
     */
    public LgsDemandGroup selectLgsDemandGroupById(Long id);

    /**
     * 查询需求管理入组进度列表
     * 
     * @param lgsDemandGroup 需求管理入组进度
     * @return 需求管理入组进度集合
     */
    public List<LgsDemandGroup> selectLgsDemandGroupList(LgsDemandGroup lgsDemandGroup);

    /**
     * 新增需求管理入组进度
     * 
     * @param lgsDemandGroup 需求管理入组进度
     * @return 结果
     */
    public int insertLgsDemandGroup(LgsDemandGroup lgsDemandGroup);

    /**
     * 修改需求管理入组进度
     * 
     * @param lgsDemandGroup 需求管理入组进度
     * @return 结果
     */
    public int updateLgsDemandGroup(LgsDemandGroup lgsDemandGroup);

    /**
     * 删除需求管理入组进度
     * 
     * @param id 需求管理入组进度主键
     * @return 结果
     */
    public int deleteLgsDemandGroupById(Long id);

    /**
     * 批量删除需求管理入组进度
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsDemandGroupByIds(Long[] ids);
}
