package com.ruoyi.lab.service.impl;

import java.util.List;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsDataApplicationMapper;
import com.ruoyi.lab.domain.LgsDataApplication;
import com.ruoyi.lab.service.ILgsDataApplicationService;

import javax.annotation.Resource;

/**
 * 数据备份/还原申请Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-30
 */
@Service
public class LgsDataApplicationServiceImpl implements ILgsDataApplicationService 
{
    @Resource
    private LgsDataApplicationMapper lgsDataApplicationMapper;

    /**
     * 查询数据备份/还原申请
     * 
     * @param id 数据备份/还原申请主键
     * @return 数据备份/还原申请
     */
    @Override
    public LgsDataApplication selectLgsDataApplicationById(Long id)
    {
        return lgsDataApplicationMapper.selectLgsDataApplicationById(id);
    }

    /**
     * 查询数据备份/还原申请列表
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 数据备份/还原申请
     */
    @Override
    public List<LgsDataApplication> selectLgsDataApplicationList(LgsDataApplication lgsDataApplication)
    {
        return lgsDataApplicationMapper.selectLgsDataApplicationList(lgsDataApplication);
    }

    /**
     * 新增数据备份/还原申请
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 结果
     */
    @Override
    public int insertLgsDataApplication(LgsDataApplication lgsDataApplication)
    {
        lgsDataApplication.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsDataApplicationMapper.insertLgsDataApplication(lgsDataApplication);
    }

    /**
     * 修改数据备份/还原申请
     * 
     * @param lgsDataApplication 数据备份/还原申请
     * @return 结果
     */
    @Override
    public int updateLgsDataApplication(LgsDataApplication lgsDataApplication)
    {
        lgsDataApplication.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsDataApplicationMapper.updateLgsDataApplication(lgsDataApplication);
    }

    /**
     * 批量删除数据备份/还原申请
     * 
     * @param ids 需要删除的数据备份/还原申请主键
     * @return 结果
     */
    @Override
    public int deleteLgsDataApplicationByIds(Long[] ids)
    {
        return lgsDataApplicationMapper.deleteLgsDataApplicationByIds(ids);
    }

    /**
     * 删除数据备份/还原申请信息
     * 
     * @param id 数据备份/还原申请主键
     * @return 结果
     */
    @Override
    public int deleteLgsDataApplicationById(Long id)
    {
        return lgsDataApplicationMapper.deleteLgsDataApplicationById(id);
    }
}
