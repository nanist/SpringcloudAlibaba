package com.ruoyi.lab.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.lab.domain.LgsOperationPersonnel;

/**
 * 运维人员信息Service接口
 * 
 * @author lgn
 * @date 2022-08-11
 */
public interface ILgsOperationPersonnelService 
{
    /**
     * 查询运维人员信息
     * 
     * @param id 运维人员信息主键
     * @return 运维人员信息
     */
    public LgsOperationPersonnel selectLgsOperationPersonnelById(Long id);

    /**
     * 查询运维人员信息列表
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 运维人员信息集合
     */
    public List<LgsOperationPersonnel> selectLgsOperationPersonnelList(LgsOperationPersonnel lgsOperationPersonnel);

    /**
     * 新增运维人员信息
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 结果
     */
    public int insertLgsOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel);

    /**
     * 修改运维人员信息
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 结果
     */
    public int updateLgsOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel);

    /**
     * 批量删除运维人员信息
     * 
     * @param ids 需要删除的运维人员信息主键集合
     * @return 结果
     */
    public int deleteLgsOperationPersonnelByIds(Long[] ids);

    /**
     * 删除运维人员信息信息
     * 
     * @param id 运维人员信息主键
     * @return 结果
     */
    public int deleteLgsOperationPersonnelById(Long id);

    /**
    　　* @description: TODO
    　　* @param 查询运维人员信息详细信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/11 17:17 
    　　*/
    Map<String, List<LgsOperationPersonnel>> getOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel);
}
