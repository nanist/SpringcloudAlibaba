package com.ruoyi.lab.service.impl;

import java.util.List;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsRetirementManagementMapper;
import com.ruoyi.lab.domain.LgsRetirementManagement;
import com.ruoyi.lab.service.ILgsRetirementManagementService;

/**
 * 退役管理Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Service
public class LgsRetirementManagementServiceImpl implements ILgsRetirementManagementService 
{
    @Autowired
    private LgsRetirementManagementMapper lgsRetirementManagementMapper;

    /**
     * 查询退役管理
     * 
     * @param id 退役管理主键
     * @return 退役管理
     */
    @Override
    public LgsRetirementManagement selectLgsRetirementManagementById(Long id)
    {
        return lgsRetirementManagementMapper.selectLgsRetirementManagementById(id);
    }

    /**
     * 查询退役管理列表
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 退役管理
     */
    @Override
    public List<LgsRetirementManagement> selectLgsRetirementManagementList(LgsRetirementManagement lgsRetirementManagement)
    {
        return lgsRetirementManagementMapper.selectLgsRetirementManagementList(lgsRetirementManagement);
    }

    /**
     * 新增退役管理
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 结果
     */
    @Override
    public int insertLgsRetirementManagement(LgsRetirementManagement lgsRetirementManagement)
    {
        lgsRetirementManagement.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsRetirementManagementMapper.insertLgsRetirementManagement(lgsRetirementManagement);
    }

    /**
     * 修改退役管理
     * 
     * @param lgsRetirementManagement 退役管理
     * @return 结果
     */
    @Override
    public int updateLgsRetirementManagement(LgsRetirementManagement lgsRetirementManagement)
    {
        lgsRetirementManagement.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsRetirementManagementMapper.updateLgsRetirementManagement(lgsRetirementManagement);
    }

    /**
     * 批量删除退役管理
     * 
     * @param ids 需要删除的退役管理主键
     * @return 结果
     */
    @Override
    public int deleteLgsRetirementManagementByIds(Long[] ids)
    {
        return lgsRetirementManagementMapper.deleteLgsRetirementManagementByIds(ids);
    }

    /**
     * 删除退役管理信息
     * 
     * @param id 退役管理主键
     * @return 结果
     */
    @Override
    public int deleteLgsRetirementManagementById(Long id)
    {
        return lgsRetirementManagementMapper.deleteLgsRetirementManagementById(id);
    }
}
