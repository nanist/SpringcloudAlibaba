package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsOperationPersonnel;

/**
 * 运维人员信息Mapper接口
 * 
 * @author lgn
 * @date 2022-08-11
 */
public interface LgsOperationPersonnelMapper 
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
     * 删除运维人员信息
     * 
     * @param id 运维人员信息主键
     * @return 结果
     */
    public int deleteLgsOperationPersonnelById(Long id);

    /**
     * 批量删除运维人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsOperationPersonnelByIds(Long[] ids);

    /**
    　　* @description: 取出运维人员名单
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/9/1 16:24
    　　*/
    List<Long> selectOperationUserIdList(List<String> codes);
}
