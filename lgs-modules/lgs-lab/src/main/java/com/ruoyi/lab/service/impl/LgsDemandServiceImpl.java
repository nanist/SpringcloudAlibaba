package com.ruoyi.lab.service.impl;

import java.util.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.utils.DictUtils;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.LgsFile;
import com.ruoyi.lab.domain.LgsMail;
import com.ruoyi.lab.mapper.LgsFileMapper;
import com.ruoyi.lab.mapper.LgsMailMapper;
import com.ruoyi.lab.utils.LgsConstants;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysDictData;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsDemandMapper;
import com.ruoyi.lab.domain.LgsDemand;
import com.ruoyi.lab.service.ILgsDemandService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 需求单Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-08
 */
@Service
public class LgsDemandServiceImpl implements ILgsDemandService
{
    Logger logger = LoggerFactory.getLogger(LgsDemandServiceImpl.class);

    @Resource
    private LgsDemandMapper lgsDemandMapper;
    @Resource
    private LgsMailMapper lgsMailMapper;
    @Resource
    private RemoteUserService remoteUserService;
    @Resource
    private LgsFileMapper lgsFileMapper;

    /**
     * 查询需求单
     * 
     * @param id 需求单主键
     * @return 需求单
     */
    @Override
    public JSONObject selectLgsDemandById(Long id)
    {
        JSONObject jsonObject=new JSONObject();
        LgsDemand lgsDemand=lgsDemandMapper.selectLgsDemandById(id);

        if (null != lgsDemand){
            jsonObject.put("lgsDemand",lgsDemand);

            if (StringUtils.isNotEmpty(lgsDemand.getFileId())){

                JSONArray jsonArray=JSONArray.parseArray(lgsDemand.getFileId());

                List<Integer> list = JSONObject.parseArray(jsonArray.toJSONString(),Integer.class);

                List<LgsFile> lgsFile=lgsFileMapper.findByList(list);
                jsonObject.put("lgsFile",lgsFile);//文件
            }

/*            List<Map> mapList=lgsDemandMapper.selectProcessListById(id);
            jsonObject.put("processList",mapList);*/
        }

        return jsonObject;
    }

    /**
     * 查询需求单列表
     * 
     * @param lgsDemand 需求单
     * @return 需求单
     */
    @Override
    public List<LgsDemand> selectLgsDemandList(LgsDemand lgsDemand)
    {
        return lgsDemandMapper.selectLgsDemandList(lgsDemand);
    }

    /**
     * 新增需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    @Override
    public int insertLgsDemand(LgsDemand lgsDemand)
    {
        lgsDemand.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());

        int i=lgsDemandMapper.insertLgsDemand(lgsDemand);

        if (i>0){

            int departmentId=lgsDemand.getDepartmentId().intValue();
            String titile=LgsConstants.DEMAND_NEW_MAIL_TITLE;
            String content="描述:"+lgsDemand.getDemandTitle()+" 责任人："+lgsDemand.getOwner();
            insertLgsCurrencyMail(departmentId,titile,content);

        }
        return i;
    }

    /**
     * 修改需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLgsDemand(LgsDemand lgsDemand)
    {
        logger.info("------------修改需求单开始---------------");
        if (null !=lgsDemand.getIsComplete()&& 1==lgsDemand.getIsComplete()){//已完成
            lgsDemand.setCompletedBy(SecurityUtils.getUserId().toString());
            lgsDemand.setCompletionTime(new Date());
        }
        lgsDemand.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        int i=lgsDemandMapper.updateLgsDemand(lgsDemand);

        if (i>0){
            LgsDemand lgsDemand1=lgsDemandMapper.selectLgsDemandById(lgsDemand.getId());

            int departmentId=lgsDemand1.getDepartmentId().intValue();
            String titile=LgsConstants.DEMAND_CHANGE_MAIL_TITLE;
            String content="描述:"+lgsDemand1.getDemandTitle()+" 责任人："+lgsDemand1.getOwner();
            insertLgsCurrencyMail(departmentId,titile,content);

            logger.info("修改需求单成功以后给运营人员发送站内信！"+" departmentId:"+departmentId+" titile:"+titile+" content"+content);

/*            if (null !=lgsDemand.getIsComplete()&& 1==lgsDemand.getIsComplete()) {//已完成的需求单 在入组管理需求沟通里插入数据
                LgsGroupMapping lgsGroupMapping=new LgsGroupMapping();
                lgsGroupMapping.setDemandId(lgsDemand.getId().intValue());
                lgsGroupMapping.setGroupManagementId(1);//需求沟通
                lgsGroupMappingMapper.insertLgsGroupMapping(lgsGroupMapping);

                logger.info("------------已完成的需求单在入组管理需求沟通里插入数据---------------"+" lgsDemandId:"+lgsDemand.getId());
            }*/
            logger.info("------------修改需求单结束---------------");
        }
        return i;
    }

    /**
     * 批量删除需求单
     * 
     * @param ids 需要删除的需求单主键
     * @return 结果
     */
    @Override
    public int deleteLgsDemandByIds(Long[] ids)
    {
        return lgsDemandMapper.deleteLgsDemandByIds(ids);
    }

    /**
     * 删除需求单信息
     * 
     * @param id 需求单主键
     * @return 结果
     */
    @Override
    public int deleteLgsDemandById(Long id)
    {
        return lgsDemandMapper.deleteLgsDemandById(id);
    }

    /**
     * 获取字典选择框列表
     * @return
     */
    @Override
    public JSONObject selectDictTypeAll() {

        JSONObject jpriorityObject=new JSONObject();
        JSONArray priorityArray=new JSONArray();
        List<SysDictData> dictDatasList = DictUtils.getDictCache("priority");

        dictDatasList.stream().forEach(SysDictData ->{
            JSONObject jsonObject =new JSONObject();
/*            System.out.println("getDictLabel:"+SysDictData.getDictLabel());
            System.out.println("getDictValue:"+SysDictData.getDictValue());*/
            jsonObject.put("DictLabel",SysDictData.getDictLabel());
            jsonObject.put("DictValue",SysDictData.getDictValue());
            priorityArray.add(jsonObject);
        });

        jpriorityObject.put("priority",priorityArray);

        return jpriorityObject;
    }

    /**
     * 取消/激活工单
     * @param lgsDemand
     * @return
     */
    @Override
    public String updateDemandState(LgsDemand lgsDemand) {

        Optional.ofNullable(lgsDemand)
                .ifPresent(l->{
                    lgsDemand.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
                    int i=lgsDemandMapper.updateLgsDemand(lgsDemand);

                    if (i>0){
                        String titile=null;
                        if (2==l.getIsComplete()){//是否完成;是否完成0：否，1：是
                            titile=LgsConstants.DEMAND_CANCEL_MAIL_TITLE;
                        }else if (0==l.getIsComplete()){
                            titile=LgsConstants.DEMAND_ACTIVATION_MAIL_TITLE;
                        }

                        int departmentId=lgsDemand.getDepartmentId().intValue();
                        String content="描述:"+lgsDemand.getDemandTitle()+" 责任人："+lgsDemand.getOwner();
                        insertLgsCurrencyMail(departmentId,titile,content);
                    }

                });
        return null;
    }

    /**
     　　* @description: TODO
     　　* @param 通用发送邮件
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
