package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsDemand;

/**
 * 需求单Mapper接口
 * 
 * @author lgn
 * @date 2022-08-08
 */
public interface LgsDemandMapper 
{
    /**
     * 查询需求单
     * 
     * @param id 需求单主键
     * @return 需求单
     */
    public LgsDemand selectLgsDemandById(Long id);

    /**
     * 查询需求单列表
     * 
     * @param lgsDemand 需求单
     * @return 需求单集合
     */
    public List<LgsDemand> selectLgsDemandList(LgsDemand lgsDemand);

    /**
     * 新增需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    public int insertLgsDemand(LgsDemand lgsDemand);

    /**
     * 修改需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    public int updateLgsDemand(LgsDemand lgsDemand);

    /**
     * 删除需求单
     * 
     * @param id 需求单主键
     * @return 结果
     */
    public int deleteLgsDemandById(Long id);

    /**
     * 批量删除需求单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsDemandByIds(Long[] ids);
}
