package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.LgsMail;

/**
 * 站内信Service接口
 * 
 * @author lgn
 * @date 2022-08-05
 */
public interface ILgsMailService 
{
    /**
     * 查询站内信
     * 
     * @param id 站内信主键
     * @return 站内信
     */
    public LgsMail selectLgsMailById(Long id);

    /**
     * 查询站内信列表
     * 
     * @param lgsMail 站内信
     * @return 站内信集合
     */
    public List<LgsMail> selectLgsMailList(LgsMail lgsMail);

    /**
     * 新增站内信
     * 
     * @param lgsMail 站内信
     * @return 结果
     */
    public int insertLgsMail(LgsMail lgsMail);

    /**
     * 修改站内信
     * 
     * @param lgsMail 站内信
     * @return 结果
     */
    public int updateLgsMail(LgsMail lgsMail);

    /**
     * 批量删除站内信
     * 
     * @param ids 需要删除的站内信主键集合
     * @return 结果
     */
    public int deleteLgsMailByIds(Long[] ids);

    /**
     * 删除站内信信息
     * 
     * @param id 站内信主键
     * @return 结果
     */
    public int deleteLgsMailById(Long id);
}
