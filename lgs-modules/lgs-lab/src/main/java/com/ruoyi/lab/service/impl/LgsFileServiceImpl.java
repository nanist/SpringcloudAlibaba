package com.ruoyi.lab.service.impl;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.security.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.LgsFileMapper;
import com.ruoyi.lab.domain.LgsFile;
import com.ruoyi.lab.service.ILgsFileService;

/**
 * lgs文件Service业务层处理
 * 
 * @author lgn
 * @date 2022-08-03
 */
@Service
public class LgsFileServiceImpl implements ILgsFileService 
{
    @Autowired
    private LgsFileMapper lgsFileMapper;

    /**
     * 查询lgs文件
     * 
     * @param id lgs文件主键
     * @return lgs文件
     */
    @Override
    public LgsFile selectLgsFileById(Long id)
    {
        return lgsFileMapper.selectLgsFileById(id);
    }

    /**
     * 查询lgs文件列表
     * 
     * @param lgsFile lgs文件
     * @return lgs文件
     */
    @Override
    public List<LgsFile> selectLgsFileList(LgsFile lgsFile)
    {
        return lgsFileMapper.selectLgsFileList(lgsFile);
    }

    /**
     * 新增lgs文件
     * 
     * @param lgsFile lgs文件
     * @return 结果
     */
    @Override
    public int insertLgsFile(LgsFile lgsFile)
    {
        return lgsFileMapper.insertLgsFile(lgsFile);
    }

    /**
     * 修改lgs文件
     * 
     * @param lgsFile lgs文件
     * @return 结果
     */
    @Override
    public int updateLgsFile(LgsFile lgsFile)
    {
        return lgsFileMapper.updateLgsFile(lgsFile);
    }

    /**
     * 批量删除lgs文件
     * 
     * @param ids 需要删除的lgs文件主键
     * @return 结果
     */
    @Override
    public int deleteLgsFileByIds(Long[] ids)
    {
        return lgsFileMapper.deleteLgsFileByIds(ids);
    }

    /**
     * 删除lgs文件信息
     * 
     * @param id lgs文件主键
     * @return 结果
     */
    @Override
    public int deleteLgsFileById(Long id)
    {
        return lgsFileMapper.deleteLgsFileById(id);
    }

    /**
     * 批量插入文件
     * @param list
     * @return
     */
    @Override
    public JSONArray batchInsertFile(List<Map<String,String>>  list) {

        JSONArray jsonArray=new JSONArray();

        for (Map<String,String> map:list){
            String name=map.get("name");
            String url=map.get("url");

            LgsFile lgsFile=new LgsFile();
            lgsFile.setFileName(name);
            lgsFile.setFileUrl(url);
            lgsFile.setCreatedBy(SecurityUtils.getLoginUser().getUserid().toString());
            lgsFileMapper.insertLgsFile(lgsFile);

            jsonArray.add(lgsFile.getId());
        }

        return jsonArray;
    }
}
