package com.ruoyi.lab.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.security.utils.SecurityUtils;
import com.ruoyi.lab.domain.LgsAssetsClient;
import com.ruoyi.lab.domain.LgsAssetsHardware;
import com.ruoyi.lab.domain.LgsAssetsManagement;
import com.ruoyi.lab.domain.LgsAssetsSystem;
import com.ruoyi.lab.mapper.LgsAssetsClientMapper;
import com.ruoyi.lab.mapper.LgsAssetsHardwareMapper;
import com.ruoyi.lab.mapper.LgsAssetsSystemMapper;
import com.ruoyi.lab.service.ILgsAssetsManagementService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 资产管理Service业务层处理
 * 
 * @author lgn
 * @date 2022-07-28
 */
@Service
public class LgsAssetsManagementServiceImpl implements ILgsAssetsManagementService
{
    @Resource
    private LgsAssetsClientMapper lgsAssetsClientMapper;
    @Resource
    private LgsAssetsHardwareMapper lgsAssetsHardwareMapper;
    @Resource
    private LgsAssetsSystemMapper lgsAssetsSystemMapper;


    /**
     * 查询资产管理
     * 
     * @param id 资产管理主键
     * @return 资产管理
     */
    @Override
    public LgsAssetsManagement selectLgsAssetsManagementById(Long id)
    {
        LgsAssetsManagement lgsAssetsManagement=new LgsAssetsManagement();

        LgsAssetsSystem system=new LgsAssetsSystem();
        system.setDemandId(id);
        system.setDelFlag(1);
        List<LgsAssetsSystem> list1=lgsAssetsSystemMapper.selectLgsAssetsSystemList(system);

        LgsAssetsHardware hardware=new LgsAssetsHardware();
        hardware.setDemandId(id);
        hardware.setDelFlag(1);
        List<LgsAssetsHardware> list=lgsAssetsHardwareMapper.selectLgsAssetsHardwareList(hardware);

        LgsAssetsClient client=new LgsAssetsClient();
        client.setDemandId(id);
        client.setDelFlag(1);
        List<LgsAssetsClient> list2=lgsAssetsClientMapper.selectLgsAssetsClientList(client);

        if (list.size()>0){
            lgsAssetsManagement.setLgsAssetsHardware(list.get(0));
        }

        if (list1.size()>0){
            lgsAssetsManagement.setLgsAssetsSystem(list1.get(0));
        }

        if (list2.size()>0){
            lgsAssetsManagement.setLgsAssetsClient(list2.get(0));
        }

        return lgsAssetsManagement;
    }


    /**
     * 新增资产管理
     * 
     * @param lgsAssetsManagement 资产管理
     * @return 结果
     */
    @Override
    @Transactional
    public int insertLgsAssetsManagement(LgsAssetsManagement lgsAssetsManagement)
    {
        int i=200;

        LgsAssetsHardware h=lgsAssetsManagement.getLgsAssetsHardware();
        h.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        h.setDemandId(lgsAssetsManagement.getDemand_id());

        LgsAssetsSystem s=lgsAssetsManagement.getLgsAssetsSystem();
        s.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        s.setDemandId(lgsAssetsManagement.getDemand_id());

        LgsAssetsClient a=lgsAssetsManagement.getLgsAssetsClient();
        a.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        a.setDemandId(lgsAssetsManagement.getDemand_id());

        lgsAssetsHardwareMapper.insertLgsAssetsHardware(h);
        lgsAssetsSystemMapper.insertLgsAssetsSystem(s);
        lgsAssetsClientMapper.insertLgsAssetsClient(a);

        return i;
    }

    /**
     * 修改资产管理
     * 
     * @param lgsAssetsManagement 资产管理
     * @return 结果
     */
    @Override
    @Transactional
    public int updateLgsAssetsManagement(LgsAssetsManagement lgsAssetsManagement)
    {
        int i=200;

        LgsAssetsHardware h=lgsAssetsManagement.getLgsAssetsHardware();
        h.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());

        LgsAssetsSystem s=lgsAssetsManagement.getLgsAssetsSystem();
        s.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());

        LgsAssetsClient a=lgsAssetsManagement.getLgsAssetsClient();
        a.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());

        lgsAssetsHardwareMapper.updateLgsAssetsHardware(lgsAssetsManagement.getLgsAssetsHardware());
        lgsAssetsSystemMapper.updateLgsAssetsSystem(lgsAssetsManagement.getLgsAssetsSystem());
        lgsAssetsClientMapper.updateLgsAssetsClient(lgsAssetsManagement.getLgsAssetsClient());

        return i;
    }

    /**
    　　* @description: TODO
    　　* @param 批量保存正式环境搭建
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:16 
    　　*/
    @Override
    public int batchSaveAssets(LgsAssetsSystem lgsAssetsSystem) {
        int i=1;
        if (null != lgsAssetsSystem.getId()){
            lgsAssetsSystem.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
            lgsAssetsSystemMapper.updateLgsAssetsSystem(lgsAssetsSystem);
        }else {
            lgsAssetsSystem.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
            lgsAssetsSystemMapper.insertLgsAssetsSystem(lgsAssetsSystem);
        }

        return i;
    }

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:51 
    　　*/
    @Override
    public int addHardware(LgsAssetsHardware lgsAssetsHardware) {
        lgsAssetsHardware.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsAssetsHardwareMapper.insertLgsAssetsHardware(lgsAssetsHardware);
    }

    /**
    　　* @description: TODO
    　　* @param 入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 13:51 
    　　*/
    @Override
    public int addClient(LgsAssetsClient lgsAssetsClient) {
        lgsAssetsClient.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsAssetsClientMapper.insertLgsAssetsClient(lgsAssetsClient);
    }

    /**
    　　* @description: TODO
    　　* @param 修改入组管理正式环境搭建实验室计算机信息
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:05 
    　　*/
    @Override
    public int updateHardware(LgsAssetsHardware lgsAssetsHardware) {
        lgsAssetsHardware.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsAssetsHardwareMapper.updateLgsAssetsHardware(lgsAssetsHardware);
    }

    /**
    　　* @description: 修改入组管理正式环境搭建服务器信息/单机版计算机信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:08
    　　*/
    @Override
    public int updateClient(LgsAssetsClient lgsAssetsClient) {
        lgsAssetsClient.setUpdatedBy(SecurityUtils.getLoginUser().getUserid().toString());
        return lgsAssetsClientMapper.updateLgsAssetsClient(lgsAssetsClient);
    }

    /**
    　　* @description: 根据需求单id获取正式环境搭建详细信息
    　　* @param
    　　* @return
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/31 14:28
    　　*/
    @Override
    public JSONObject getInfoByDemandId(Long demandId) {

        JSONObject jsonObject=new JSONObject();

        LgsAssetsSystem system=new LgsAssetsSystem();
        system.setDemandId(demandId);
        system.setDelFlag(0);
        List<LgsAssetsSystem> systemlist1=lgsAssetsSystemMapper.selectLgsAssetsSystemList(system);

        LgsAssetsHardware hardware=new LgsAssetsHardware();//实验室计算机信息
        hardware.setDemandId(demandId);
        hardware.setDelFlag(0);
        List<LgsAssetsHardware> lab_computerlist=lgsAssetsHardwareMapper.selectLgsAssetsHardwareList(hardware);

        LgsAssetsClient client=new LgsAssetsClient();
        client.setDemandId(demandId);
        client.setDelFlag(0);
        List<LgsAssetsClient> clientList2=lgsAssetsClientMapper.selectLgsAssetsClientList(client);

        if (systemlist1.size()>0){
            jsonObject.put("system",systemlist1.get(0));
        }

        if (lab_computerlist.size()>0){
            jsonObject.put("labComputer",lab_computerlist);
        }

        if (clientList2.size()>0){
            Map<Integer,List<LgsAssetsClient>> collectMap = clientList2.stream().collect(Collectors.groupingBy(LgsAssetsClient::getComputerType));
            // 替换key！！！！！！！！！！！
            jsonObject.put("server",collectMap.get(0));//服务器信息
            jsonObject.put("standAloneComputer",collectMap.get(1));//单机版计算机信息
        }

        return jsonObject;
    }

}
