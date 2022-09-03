package com.ruoyi.lab.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsGroupSubprocessMapper;
import com.ruoyi.lab.domain.LgsGroupSubprocess;
import com.ruoyi.lab.service.ILgsGroupSubprocessService;

import javax.annotation.Resource;

/**
 * 分组管理通用子流程Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-10
 */
@Service
public class LgsGroupSubprocessServiceImpl implements ILgsGroupSubprocessService 
{
    @Resource
    private LgsGroupSubprocessMapper lgsGroupSubprocessMapper;

    /**
     * 查询分组管理通用子流程
     * 
     * @param id 分组管理通用子流程主键
     * @return 分组管理通用子流程
     */
    @Override
    public LgsGroupSubprocess selectLgsGroupSubprocessById(Long id)
    {
        return lgsGroupSubprocessMapper.selectLgsGroupSubprocessById(id);
    }

    /**
     * 查询分组管理通用子流程列表
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 分组管理通用子流程
     */
    @Override
    public List<LgsGroupSubprocess> selectLgsGroupSubprocessList(LgsGroupSubprocess lgsGroupSubprocess)
    {
        return lgsGroupSubprocessMapper.selectLgsGroupSubprocessList(lgsGroupSubprocess);
    }

    /**
     * 新增分组管理通用子流程
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 结果
     */
    @Override
    public int insertLgsGroupSubprocess(LgsGroupSubprocess lgsGroupSubprocess)
    {
        lgsGroupSubprocess.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupSubprocessMapper.insertLgsGroupSubprocess(lgsGroupSubprocess);
    }

    /**
     * 修改分组管理通用子流程
     * 
     * @param lgsGroupSubprocess 分组管理通用子流程
     * @return 结果
     */
    @Override
    public int updateLgsGroupSubprocess(LgsGroupSubprocess lgsGroupSubprocess)
    {
        if (1==lgsGroupSubprocess.getIsComplete()){//已完成
            lgsGroupSubprocess.setCompletedBy(SecurityUtils.getUserId().toString());
            lgsGroupSubprocess.setCompletionTime(new Date());
        }
        lgsGroupSubprocess.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupSubprocessMapper.updateLgsGroupSubprocess(lgsGroupSubprocess);
    }

    /**
     * 批量删除分组管理通用子流程
     * 
     * @param ids 需要删除的分组管理通用子流程主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupSubprocessByIds(Long[] ids)
    {
        return lgsGroupSubprocessMapper.deleteLgsGroupSubprocessByIds(ids);
    }

    /**
     * 删除分组管理通用子流程信息
     * 
     * @param id 分组管理通用子流程主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupSubprocessById(Long id)
    {
        return lgsGroupSubprocessMapper.deleteLgsGroupSubprocessById(id);
    }

    /**
     * 批量完成子流程
     * @param param
     * @return
     */
    @Override
    public int batchCompleteGroupSubprocess(Map<String, Object> param) {
        List<Long> list=(List<Long>) param.get("ids");

        LgsGroupSubprocess lgsGroupSubprocess=new LgsGroupSubprocess();

        lgsGroupSubprocess.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        lgsGroupSubprocess.setCompletedBy(SecurityUtils.getLoginUser().getUserid().toString());
        lgsGroupSubprocess.setCompletionTime(new Date());
        lgsGroupSubprocess.setIds(list);

        return lgsGroupSubprocessMapper.batchCompleteGroupSubprocess(lgsGroupSubprocess);
    }

}
