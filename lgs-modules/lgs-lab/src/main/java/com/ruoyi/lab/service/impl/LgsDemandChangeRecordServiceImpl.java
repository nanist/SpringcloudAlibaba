package com.ruoyi.lab.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.LgsDemand;
import com.ruoyi.lab.domain.LgsFile;
import com.ruoyi.lab.domain.LgsMail;
import com.ruoyi.lab.mapper.LgsDemandMapper;
import com.ruoyi.lab.mapper.LgsFileMapper;
import com.ruoyi.lab.mapper.LgsMailMapper;
import com.ruoyi.lab.utils.LgsConstants;
import com.ruoyi.system.api.RemoteUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsDemandChangeRecordMapper;
import com.ruoyi.lab.domain.LgsDemandChangeRecord;
import com.ruoyi.lab.service.ILgsDemandChangeRecordService;

import javax.annotation.Resource;

/**
 * 需求变更记录Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-09
 */
@Service
public class LgsDemandChangeRecordServiceImpl implements ILgsDemandChangeRecordService
{
    @Resource
    private LgsDemandChangeRecordMapper demandChangeRecordMapper;
    @Resource
    private LgsDemandMapper lgsDemandMapper;
    @Resource
    private RemoteUserService remoteUserService;
    @Resource
    private LgsFileMapper lgsFileMapper;
    @Resource
    private LgsMailMapper lgsMailMapper;
    /**
     * 查询需求变更记录
     * 
     * @param id 需求变更记录主键
     * @return 需求变更记录
     */
    @Override
    public LgsDemandChangeRecord selectDemandChangeRecordById(Long id)
    {
        return demandChangeRecordMapper.selectLgsDemandChangeRecordById(id);
    }

    /**
     * 查询需求变更记录列表
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 需求变更记录
     */
    @Override
    public List<LgsDemandChangeRecord> selectDemandChangeRecordList(LgsDemandChangeRecord demandChangeRecord)
    {
        return demandChangeRecordMapper.selectLgsDemandChangeRecordList(demandChangeRecord);
    }

    /**
     * 新增需求变更记录
     * 
     * @param demandChangeRecord 需求变更记录
     * @return 结果
     */
    @Override
    public int insertDemandChangeRecord(LgsDemandChangeRecord demandChangeRecord)
    {
        demandChangeRecord.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        int i=demandChangeRecordMapper.insertLgsDemandChangeRecord(demandChangeRecord);

        if (i>0){
            LgsDemand lgsDemand=lgsDemandMapper.selectLgsDemandById(demandChangeRecord.getLgsDemandId());

            int departmentId=lgsDemand.getDepartmentId().intValue();
            String titile=LgsConstants.DEMANDCHANGE_NEW_MAIL_TITLE;
            String content="描述:"+lgsDemand.getDemandTitle()+" 责任人："+lgsDemand.getOwner();
            insertLgsCurrencyMail(departmentId,titile,content);
        }

/*        Map<String, Integer> map=new HashMap<>();
        map.put("dept_id",lgsDemand.getDepartmentId().intValue());
        R<List<Integer>> hashMap=remoteUserService.getSupportUserBySiteId(map);

        if (null != hashMap.getData()){
            List<Integer> integerList=hashMap.getData();

            for (Integer userid:integerList){
                LgsMail lgsMail=new LgsMail();
                lgsMail.setSender("0");
                lgsMail.setReceiver(userid.toString());//接收人
                lgsMail.setTitle(LgsConstants.DEMANDCHANGE_NEW_MAIL_TITLE);
                lgsMail.setContent("描述:"+demandChangeRecord.getRecordDescribe()+" 创建人："+SecurityUtils.getLoginUser().getUsername());
                lgsMail.setMailType(1);//信件类别;0:需求，1:需求变更，2：设备退役申请，3：日常保修，4：运维任务
                lgsMailMapper.insertLgsMail(lgsMail);//发送站内信！
            }
        }*/

        return i;
    }

    /**
     * 修改需求变更记录
     * 
     * @param changeRecord 需求变更记录
     * @return 结果
     */
    @Override
    public int updateDemandChangeRecord(LgsDemandChangeRecord changeRecord)
    {
        changeRecord.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        int i=demandChangeRecordMapper.updateLgsDemandChangeRecord(changeRecord);

        if (i>0){
            LgsDemandChangeRecord record=demandChangeRecordMapper.selectLgsDemandChangeRecordById(changeRecord.getId());
            LgsDemand lgsDemand=lgsDemandMapper.selectLgsDemandById(record.getLgsDemandId());
            int departmentId=lgsDemand.getDepartmentId().intValue();
            String titile=LgsConstants.DEMANDCHANGE_CHANGE_MAIL_TITLE;
            String content="描述:"+lgsDemand.getDemandTitle()+" 责任人："+lgsDemand.getOwner();
            insertLgsCurrencyMail(departmentId,titile,content);
        }

        return i;
    }

    /**
     * 批量删除需求变更记录
     * 
     * @param ids 需要删除的需求变更记录主键
     * @return 结果
     */
    @Override
    public int deleteDemandChangeRecordByIds(Long[] ids)
    {
        return demandChangeRecordMapper.deleteDemandChangeRecordByIds(ids);
    }

    /**
     * 删除需求变更记录信息
     * 
     * @param id 需求变更记录主键
     * @return 结果
     */
    @Override
    public int deleteDemandChangeRecordById(Long id)
    {
        return demandChangeRecordMapper.deleteDemandChangeRecordById(id);
    }

    /**
     * 根据变更id查看需求变更记录详细信息
     * @param demandChangeRecord
     * @return
     */
    @Override
    public JSONObject getChangeInfoById(LgsDemandChangeRecord demandChangeRecord) {

        JSONObject jsonObject=new JSONObject();

        if (null != demandChangeRecord.getId()){
            LgsDemandChangeRecord record=demandChangeRecordMapper.selectLgsDemandChangeRecordById(demandChangeRecord.getId());
            jsonObject.put("record",record);

            if (StringUtils.isNotEmpty(record.getFileId())){
                JSONArray jsonArray=JSONArray.parseArray(record.getFileId());
                List<Integer> list = JSONObject.parseArray(jsonArray.toJSONString(),Integer.class);
                List<LgsFile> lgsFile=lgsFileMapper.findByList(list);
                jsonObject.put("lgsFile",lgsFile);//文件
            }

            if (null != record && null!=record.getLgsDemandId()){
                LgsDemand lgsDemand=lgsDemandMapper.selectLgsDemandById(record.getLgsDemandId());
                jsonObject.put("lgsDemand",lgsDemand);
            }

        }
        return jsonObject;
    }

    /**
    　　* @description: TODO
    　　* @param 取消/激活需求变更单
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/25 11:22 
    　　*/
    @Override
    public String updateDemandChangeRecordState(LgsDemandChangeRecord demandChangeRecord) {

        Optional.ofNullable(demandChangeRecord)
                .ifPresent(l->{
                    demandChangeRecord.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
                    int i=demandChangeRecordMapper.updateLgsDemandChangeRecord(demandChangeRecord);

                    if (i>0){
                        LgsDemand lgsDemand=lgsDemandMapper.selectLgsDemandById(demandChangeRecord.getLgsDemandId());

                        String titile=null;
                        if (2==l.getIsComplete()){//是否完成;是否完成0：否，1：是
                            titile=LgsConstants.DEMAND_CHANGE_CANCEL_MAIL_TITLE;
                        }else if (0==l.getIsComplete()){
                            titile=LgsConstants.DEMAND_CHANGE_ACTIVATION_MAIL_TITLE;
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
