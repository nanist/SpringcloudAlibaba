package com.ruoyi.lab.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.lab.domain.LgsFile;

/**
 * lgs文件Service接口
 * 
 * @author lgn
 * @date 2022-08-03
 */
public interface ILgsFileService 
{
    /**
     * 查询lgs文件
     * 
     * @param id lgs文件主键
     * @return lgs文件
     */
    public LgsFile selectLgsFileById(Long id);

    /**
     * 查询lgs文件列表
     * 
     * @param lgsFile lgs文件
     * @return lgs文件集合
     */
    public List<LgsFile> selectLgsFileList(LgsFile lgsFile);

    /**
     * 新增lgs文件
     * 
     * @param lgsFile lgs文件
     * @return 结果
     */
    public int insertLgsFile(LgsFile lgsFile);

    /**
     * 修改lgs文件
     * 
     * @param lgsFile lgs文件
     * @return 结果
     */
    public int updateLgsFile(LgsFile lgsFile);

    /**
     * 批量删除lgs文件
     * 
     * @param ids 需要删除的lgs文件主键集合
     * @return 结果
     */
    public int deleteLgsFileByIds(Long[] ids);

    /**
     * 删除lgs文件信息
     * 
     * @param id lgs文件主键
     * @return 结果
     */
    public int deleteLgsFileById(Long id);

    /**
     * 批量插入文件
     * @param list
     * @return
     */
    JSONArray batchInsertFile(List<Map<String,String>>  list);
}
