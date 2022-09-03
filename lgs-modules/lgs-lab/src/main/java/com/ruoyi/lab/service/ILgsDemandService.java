package com.ruoyi.lab.service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.lab.domain.LgsDemand;
import com.ruoyi.system.api.domain.SysDictData;
import com.ruoyi.system.api.domain.SysDictType;

/**
 * 需求单Service接口
 * 
 * @author lgn
 * @date 2022-08-08
 */
public interface ILgsDemandService 
{
    /**
     * 查询需求单
     * 
     * @param id 需求单主键
     * @return 需求单
     */
    public JSONObject selectLgsDemandById(Long id);

    /**
     * 查询需求单列表
     * 
     * @param lgsDemand 需求单
     * @return 需求单集合
     */
    public List<LgsDemand> selectLgsDemandList(LgsDemand lgsDemand);

    /**
     * 新增需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    public int insertLgsDemand(LgsDemand lgsDemand);

    /**
     * 修改需求单
     * 
     * @param lgsDemand 需求单
     * @return 结果
     */
    public int updateLgsDemand(LgsDemand lgsDemand);

    /**
     * 批量删除需求单
     * 
     * @param ids 需要删除的需求单主键集合
     * @return 结果
     */
    public int deleteLgsDemandByIds(Long[] ids);

    /**
     * 删除需求单信息
     * 
     * @param id 需求单主键
     * @return 结果
     */
    public int deleteLgsDemandById(Long id);

    /**
     * 获取字典选择框列表
     * @return
     */
    JSONObject selectDictTypeAll();

    /**
    　　* @description: 取消/激活工单
    　　* @param
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/25 9:37 
    　　*/
    String updateDemandState(LgsDemand lgsDemand);
}
