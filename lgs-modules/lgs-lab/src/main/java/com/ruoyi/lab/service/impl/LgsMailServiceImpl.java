package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsMailMapper;
import com.ruoyi.lab.domain.LgsMail;
import com.ruoyi.lab.service.ILgsMailService;

/**
 * 站内信Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-05
 */
@Service
public class LgsMailServiceImpl implements ILgsMailService 
{
    @Autowired
    private LgsMailMapper lgsMailMapper;

    /**
     * 查询站内信
     * 
     * @param id 站内信主键
     * @return 站内信
     */
    @Override
    public LgsMail selectLgsMailById(Long id)
    {
        return lgsMailMapper.selectLgsMailById(id);
    }

    /**
     * 查询站内信列表
     * 
     * @param lgsMail 站内信
     * @return 站内信
     */
    @Override
    public List<LgsMail> selectLgsMailList(LgsMail lgsMail)
    {
        return lgsMailMapper.selectLgsMailList(lgsMail);
    }

    /**
     * 新增站内信
     * 
     * @param lgsMail 站内信
     * @return 结果
     */
    @Override
    public int insertLgsMail(LgsMail lgsMail)
    {
        return lgsMailMapper.insertLgsMail(lgsMail);
    }

    /**
     * 修改站内信
     * 
     * @param lgsMail 站内信
     * @return 结果
     */
    @Override
    public int updateLgsMail(LgsMail lgsMail)
    {
        return lgsMailMapper.updateLgsMail(lgsMail);
    }

    /**
     * 批量删除站内信
     * 
     * @param ids 需要删除的站内信主键
     * @return 结果
     */
    @Override
    public int deleteLgsMailByIds(Long[] ids)
    {
        return lgsMailMapper.deleteLgsMailByIds(ids);
    }

    /**
     * 删除站内信信息
     * 
     * @param id 站内信主键
     * @return 结果
     */
    @Override
    public int deleteLgsMailById(Long id)
    {
        return lgsMailMapper.deleteLgsMailById(id);
    }
}
