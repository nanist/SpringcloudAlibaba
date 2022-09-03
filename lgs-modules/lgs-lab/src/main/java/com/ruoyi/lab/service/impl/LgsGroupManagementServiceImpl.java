package com.ruoyi.lab.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.*;
import com.ruoyi.lab.mapper.*;
import com.ruoyi.lab.utils.LgsConstants;
import com.ruoyi.system.api.RemoteUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.service.ILgsGroupManagementService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 入组管理Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-02
 */
@Service
public class LgsGroupManagementServiceImpl implements ILgsGroupManagementService 
{
    Logger logger = LoggerFactory.getLogger(LgsGroupManagementServiceImpl.class);

    @Resource
    private LgsGroupManagementMapper lgsGroupManagementMapper;
    @Resource
    private LgsDemandMapper lgsDemandMapper;
    @Resource
    private LgsGroupSubprocessMapper lgsGroupSubprocessMapper;
    @Resource
    private LgsDemandGroupMapper lgsDemandGroupMapper;
    @Resource
    private RemoteUserService remoteUserService;
    @Resource
    private LgsMailMapper lgsMailMapper;

    /**
     * 查询入组管理
     * 
     * @param id 入组管理主键
     * @return 入组管理
     */
    @Override
    public LgsGroupManagement selectLgsGroupManagementById(Long id)
    {
        return lgsGroupManagementMapper.selectLgsGroupManagementById(id);
    }

    /**
     * 查询入组管理列表
     * 
     * @param lgsGroupManagement 入组管理
     * @return 入组管理
     */
    @Override
    public List<LgsGroupManagement> selectLgsGroupManagementList(LgsGroupManagement lgsGroupManagement)
    {
        return lgsGroupManagementMapper.selectLgsGroupManagementList(lgsGroupManagement);
    }

    /**
     * 新增入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    @Override
    public int insertLgsGroupManagement(LgsGroupManagement lgsGroupManagement)
    {
        lgsGroupManagement.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupManagementMapper.insertLgsGroupManagement(lgsGroupManagement);
    }

    /**
     * 修改入组管理
     * 
     * @param lgsGroupManagement 入组管理
     * @return 结果
     */
    @Override
    public int updateLgsGroupManagement(LgsGroupManagement lgsGroupManagement)
    {
        if (null!=lgsGroupManagement.getIsComplete()&&1==lgsGroupManagement.getIsComplete()){//已完成
            lgsGroupManagement.setCompletedBy(SecurityUtils.getLoginUser().getUserid().toString());
            lgsGroupManagement.setCompletionTime(new Date());
        }
        lgsGroupManagement.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsGroupManagementMapper.updateLgsGroupManagement(lgsGroupManagement);
    }

    /**
     * 批量删除入组管理
     * 
     * @param ids 需要删除的入组管理主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupManagementByIds(Long[] ids)
    {
        return lgsGroupManagementMapper.deleteLgsGroupManagementByIds(ids);
    }

    /**
     * 删除入组管理信息
     * 
     * @param id 入组管理主键
     * @return 结果
     */
    @Override
    public int deleteLgsGroupManagementById(Long id)
    {
        return lgsGroupManagementMapper.deleteLgsGroupManagementById(id);
    }

    /**
     * 查询-IT场地确认/预算申请/采购-流程详情
     * @param lgsGroup
     * @return
     */
    @Override
    public JSONObject getSubprocessInfo(LgsGroupManagement lgsGroup) {
        JSONObject jsonObject =new JSONObject();

        LgsDemand demand=lgsDemandMapper.selectLgsDemandById(lgsGroup.getDemandId());
        jsonObject.put("demand",demand);

        List<LgsGroupManagement> list=lgsGroupManagementMapper.selectLgsGroupManagementList(lgsGroup);

        if (null!=list&&list.size()>0){
            LgsGroupManagement groupManagement=list.get(0);
            LgsGroupSubprocess lgsGroupSubprocess=new LgsGroupSubprocess();
            lgsGroupSubprocess.setGroupManagementId(groupManagement.getId());
            List<LgsGroupSubprocess> groupSubprocessList=lgsGroupSubprocessMapper.selectLgsGroupSubprocessList(lgsGroupSubprocess);
            jsonObject.put("groupSubprocess",groupSubprocessList);
            jsonObject.put("groupManagementId",groupManagement.getId());
        }

        return jsonObject;
    }

    /**
    　　* @description: TODO
    　　* @param 入组管理子流程标记完成
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/30 13:58 
    　　*/
    @Override
    public int groupSubprocessComplete(LgsDemandGroup demandGroup) {
        logger.info("-----------入组管理子流程标记完成!"+" 需求单id："+demandGroup.getDemandId()+" 流程id："+demandGroup.getGroupManagementId());
        demandGroup.setIsComplete(1);//是否完成;是否完成0：否，1：是
        demandGroup.setCompletedBy(SecurityUtils.getLoginUser().getUserid().toString());
        demandGroup.setCompletionTime(new Date());
        demandGroup.setUpdatedBy(SecurityUtils.getUserId().toString());
        int i=lgsDemandGroupMapper.insertLgsDemandGroup(demandGroup);
        return i;
    }

    /**
    　　* @description: TODO
    　　* @param 获取入组管理子流程进度列表
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/30 14:06 
    　　*/
    @Override
    public List<LgsGroupManagement> groupSubprocessList(LgsGroupManagement lgsGroup) {
        List<LgsGroupManagement> list=lgsGroupManagementMapper.groupSubprocessList(lgsGroup);
        return list;
    }

    /**
    　　* @description: 入组管理流程完毕-设备放行
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 17:23
    　　*/
    @Override
    @Transactional
    public int groupSubprocessCompleteAndRelease(LgsDemandGroup demandGroup) {
        logger.info("-----------入组管理流程完毕设备放行!"+" 需求单id："+demandGroup.getDemandId()+" 流程id："+demandGroup.getGroupManagementId());
        demandGroup.setIsComplete(1);//是否完成;是否完成0：否，1：是
        demandGroup.setCompletedBy(SecurityUtils.getUserId().toString());
        demandGroup.setCompletionTime(new Date());
        demandGroup.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        int i=lgsDemandGroupMapper.insertLgsDemandGroup(demandGroup);

        if (i>0){
            LgsDemand lgsDemand1=lgsDemandMapper.selectLgsDemandById(demandGroup.getDemandId());
            int departmentId=lgsDemand1.getDepartmentId().intValue();
            String titile= LgsConstants.DEMAND_COMPLETE_MAIL_TITLE;
            String content="描述:"+lgsDemand1.getDemandTitle()+" 责任人："+lgsDemand1.getOwner();

            logger.info("需求被成功设备放行（需求完成）后，为此需求的责任人发送站内信！"+" departmentId:"+departmentId+" titile:"+titile+" content"+content);
            insertLgsCurrencyMail(departmentId,titile,content);
        }

        return i;
    }

    /**
     　　* @description: 通用发送邮件
     　　* @param
     　　* @return
     　　* @throws
     　　* @author lgn
     　　* @date 2022/8/24 14:10
     　　*/
    public void insertLgsCurrencyMail(int departmentId,String titile,String content){
        Map<String, Integer> map=new HashMap<>();
        map.put("dept_id",departmentId);
        R<List<Integer>> hashMap=remoteUserService.getSupportUserBySiteId(map);

        if (null != hashMap.getData()){
            List<Integer> integerList=hashMap.getData();

            for (Integer userid:integerList){
                LgsMail lgsMail=new LgsMail();
                lgsMail.setSender("0");
                lgsMail.setReceiver(userid.toString());//接收人
                lgsMail.setTitle(titile);
                lgsMail.setContent(content);
                lgsMail.setMailType(0);//信件类别;0:需求，1:需求变更，2：设备退役申请，3：日常保修，4：运维任务
                lgsMail.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
                lgsMailMapper.insertLgsMail(lgsMail);//发送站内信！
            }
        }
    }
}
