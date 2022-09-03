package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsAssetsHardware;

/**
 * lgs资产管理实验室仪器硬件信息Mapper接口
 * 
 * @author lgn
 * @date 2022-08-11
 */
public interface LgsAssetsHardwareMapper 
{
    /**
     * 查询lgs资产管理实验室仪器硬件信息
     * 
     * @param id lgs资产管理实验室仪器硬件信息主键
     * @return lgs资产管理实验室仪器硬件信息
     */
    public LgsAssetsHardware selectLgsAssetsHardwareById(Long id);

    /**
     * 查询lgs资产管理实验室仪器硬件信息列表
     * 
     * @param lgsAssetsHardware lgs资产管理实验室仪器硬件信息
     * @return lgs资产管理实验室仪器硬件信息集合
     */
    public List<LgsAssetsHardware> selectLgsAssetsHardwareList(LgsAssetsHardware lgsAssetsHardware);

    /**
     * 新增lgs资产管理实验室仪器硬件信息
     * 
     * @param lgsAssetsHardware lgs资产管理实验室仪器硬件信息
     * @return 结果
     */
    public int insertLgsAssetsHardware(LgsAssetsHardware lgsAssetsHardware);

    /**
     * 修改lgs资产管理实验室仪器硬件信息
     * 
     * @param lgsAssetsHardware lgs资产管理实验室仪器硬件信息
     * @return 结果
     */
    public int updateLgsAssetsHardware(LgsAssetsHardware lgsAssetsHardware);

    /**
     * 删除lgs资产管理实验室仪器硬件信息
     * 
     * @param id lgs资产管理实验室仪器硬件信息主键
     * @return 结果
     */
    public int deleteLgsAssetsHardwareById(Long id);

    /**
     * 批量删除lgs资产管理实验室仪器硬件信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsAssetsHardwareByIds(Long[] ids);
}
