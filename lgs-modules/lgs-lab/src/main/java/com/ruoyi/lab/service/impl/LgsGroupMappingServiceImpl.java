package com.ruoyi.lab.service.impl;

import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.LgsGroupSubprocess;
import com.ruoyi.lab.mapper.LgsGroupSubprocessMapper;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsGroupMappingMapper;
import com.ruoyi.lab.domain.LgsGroupMapping;
import com.ruoyi.lab.service.ILgsGroupMappingService;

import javax.annotation.Resource;

/**
 * 需求单入组管理映射Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-29
 */
@Service
public class LgsGroupMappingServiceImpl implements ILgsGroupMappingService 
{
    Logger logger = LoggerFactory.getLogger(LgsGroupMappingServiceImpl.class);

    @Resource
    private LgsGroupMappingMapper lgsGroupMappingMapper;
    @Resource
    private LgsGroupSubprocessMapper lgsGroupSubprocessMapper;
    /**
     * 查询需求单入组管理映射
     * 
     * @param id 需求单入组管理映射主键
     * @return 需求单入组管理映射
     */
    @Override
    public LgsGroupMapping selectLgsGroupMappingById(Long id)
    {
        return lgsGroupMappingMapper.selectLgsGroupMappingById(id);
    }

    /**
     * 查询需求单入组管理映射列表
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 需求单入组管理映射
     */
    @Override
    public List<LgsGroupMapping> selectLgsGroupMappingList(LgsGroupMapping lgsGroupMapping)
    {
        return lgsGroupMappingMapper.selectLgsGroupMappingList(lgsGroupMapping);
    }

    /**
     * 新增需求单入组管理映射
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 结果
     */
    @Override
    public int insertLgsGroupMapping(LgsGroupMapping lgsGroupMapping)
    {
        lgsGroupMapping.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupMappingMapper.insertLgsGroupMapping(lgsGroupMapping);
    }

    /**
     * 修改需求单入组管理映射
     * 
     * @param lgsGroupMapping 需求单入组管理映射
     * @return 结果
     */
    @Override
    public int updateLgsGroupMapping(LgsGroupMapping lgsGroupMapping)
    {
        logger.info("------------修改需求单开始---------------");
        if (null !=lgsGroupMapping.getIsComplete()&& 1==lgsGroupMapping.getIsComplete()){//已完成
            lgsGroupMapping.setCompletedBy(SecurityUtils.getUserId().toString());
            lgsGroupMapping.setCompletionTime(new Date());
        }
        lgsGroupMapping.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupMappingMapper.updateLgsGroupMapping(lgsGroupMapping);
    }

    /**
     * 批量删除需求单入组管理映射
     * 
     * @param ids 需要删除的需求单入组管理映射主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupMappingByIds(Long[] ids)
    {
        return lgsGroupMappingMapper.deleteLgsGroupMappingByIds(ids);
    }

    /**
     * 删除需求单入组管理映射信息
     * 
     * @param id 需求单入组管理映射主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupMappingById(Long id)
    {
        return lgsGroupMappingMapper.deleteLgsGroupMappingById(id);
    }

    /**
    　　* @description: TODO
    　　* @param 获取需求单入组管理映射详细信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 11:11 
    　　*/
    @Override
    public List<LgsGroupSubprocess> getGroupMappingInfoByDemandId(LgsGroupMapping lgsGroupMapping) {
        JSONArray array=new JSONArray();

        //String ids=Optional.ofNullable(lgsGroupMapping).map(m-> m.getSubprocessIds()).get();
        //String ids=Optional.ofNullable(lgsGroupMapping).map(m-> m.getSubprocessIds()).orElse("[]");
        //JSONArray jsonArray = JSONArray.parseArray(ids);

        logger.info("获取需求单入组管理映射详细信息:"+" DemandId:"+lgsGroupMapping.getDemandId()+" GroupManagementId():"+lgsGroupMapping.getGroupManagementId());
        LgsGroupSubprocess subprocess=new LgsGroupSubprocess();
        subprocess.setDemandId(lgsGroupMapping.getDemandId());
        subprocess.setGroupManagementId(lgsGroupMapping.getGroupManagementId().longValue());
        List<LgsGroupSubprocess> list=lgsGroupSubprocessMapper.getGroupMappingInfoByDemandId(subprocess);

        logger.info("获取需求单入组管理映射详细信息fanhui:"+list.size());

        return list;
    }

    /**
    　　* @description: TODO
    　　* @param 批量保存子任务
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/29 18:37 
    　　*/
    @Override
    public int batchSaveGroupMapping(List<LgsGroupMapping> list) {
        int i=200;
        try {
            list.forEach(item->{
    /*            item.getSubprocessIds();
                item.getDemandId();
                item.getGroupManagementId();*/

                if (StringUtils.isNotEmpty(item.getSubprocessIds())&&null != item.getDemandId()&& null!=item.getGroupManagementId()){
                    LgsGroupMapping lgsGroupMapping=new LgsGroupMapping();
                    lgsGroupMapping.setGroupManagementId(item.getGroupManagementId());
                    lgsGroupMapping.setDemandId(item.getDemandId());
                    lgsGroupMapping.setSubprocessIds(item.getSubprocessIds());
                    List<LgsGroupMapping> lgsGroupMappingList=lgsGroupMappingMapper.selectLgsGroupMappingList(lgsGroupMapping);

                    if (lgsGroupMappingList.size()>0){//已存在 执行修改
                        lgsGroupMapping.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
                        lgsGroupMappingMapper.updateLgsGroupMapping(lgsGroupMapping);
                    }else {//不存在 执行插入
                        lgsGroupMapping.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
                        lgsGroupMappingMapper.insertLgsGroupMapping(lgsGroupMapping);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            i=0;
        }

        return i;
    }
}
