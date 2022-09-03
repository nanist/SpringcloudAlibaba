package com.ruoyi.lab.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsOperationPersonnelMapper;
import com.ruoyi.lab.domain.LgsOperationPersonnel;
import com.ruoyi.lab.service.ILgsOperationPersonnelService;

import javax.annotation.Resource;

/**
 * 运维人员信息Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-11
 */
@Service
public class LgsOperationPersonnelServiceImpl implements ILgsOperationPersonnelService 
{
    @Resource
    private LgsOperationPersonnelMapper lgsOperationPersonnelMapper;

    /**
     * 查询运维人员信息
     * 
     * @param id 运维人员信息主键
     * @return 运维人员信息
     */
    @Override
    public LgsOperationPersonnel selectLgsOperationPersonnelById(Long id)
    {
        return lgsOperationPersonnelMapper.selectLgsOperationPersonnelById(id);
    }

    /**
     * 查询运维人员信息列表
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 运维人员信息
     */
    @Override
    public List<LgsOperationPersonnel> selectLgsOperationPersonnelList(LgsOperationPersonnel lgsOperationPersonnel)
    {
        return lgsOperationPersonnelMapper.selectLgsOperationPersonnelList(lgsOperationPersonnel);
    }

    /**
     * 新增运维人员信息
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 结果
     */
    @Override
    public int insertLgsOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel)
    {
        lgsOperationPersonnel.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationPersonnelMapper.insertLgsOperationPersonnel(lgsOperationPersonnel);
    }

    /**
     * 修改运维人员信息
     * 
     * @param lgsOperationPersonnel 运维人员信息
     * @return 结果
     */
    @Override
    public int updateLgsOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel)
    {
        lgsOperationPersonnel.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsOperationPersonnelMapper.updateLgsOperationPersonnel(lgsOperationPersonnel);
    }

    /**
     * 批量删除运维人员信息
     * 
     * @param ids 需要删除的运维人员信息主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationPersonnelByIds(Long[] ids)
    {
        return lgsOperationPersonnelMapper.deleteLgsOperationPersonnelByIds(ids);
    }

    /**
     * 删除运维人员信息信息
     * 
     * @param id 运维人员信息主键
     * @return 结果
     */
    @Override
    public int deleteLgsOperationPersonnelById(Long id)
    {
        return lgsOperationPersonnelMapper.deleteLgsOperationPersonnelById(id);
    }

    /**
     * 查询运维人员信息详细信息
     * @param lgsOperationPersonnel
     * @return
     */
    @Override
    public Map<String, List<LgsOperationPersonnel>> getOperationPersonnel(LgsOperationPersonnel lgsOperationPersonnel) {
        Map<String, List<LgsOperationPersonnel>> personnelStrMap=new HashMap<>();
        List<LgsOperationPersonnel> list=new ArrayList<>();


        List<LgsOperationPersonnel> personnelList=lgsOperationPersonnelMapper.selectLgsOperationPersonnelList(lgsOperationPersonnel);
        //按照人员类别分组
        Map<Integer, List<LgsOperationPersonnel>> personnelMap = personnelList.stream().collect(Collectors.groupingBy(LgsOperationPersonnel::getCategory));

        personnelStrMap.put("hardware",Optional.ofNullable(personnelMap.get(0)).orElse(list));
        personnelStrMap.put("software",Optional.ofNullable(personnelMap.get(1)).orElse(list));
        personnelStrMap.put("supplier",Optional.ofNullable(personnelMap.get(2)).orElse(list));

        return personnelStrMap;
    }
}
