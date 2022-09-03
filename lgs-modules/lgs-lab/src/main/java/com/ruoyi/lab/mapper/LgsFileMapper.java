package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.LgsFile;

/**
 * lgs文件Mapper接口
 * 
 * @author lgn
 * @date 2022-08-03
 */
public interface LgsFileMapper 
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
     * 删除lgs文件
     * 
     * @param id lgs文件主键
     * @return 结果
     */
    public int deleteLgsFileById(Long id);

    /**
     * 批量删除lgs文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLgsFileByIds(Long[] ids);

    /**
    　　* @description: TODO
    　　* @param
    　　* @return 
    　　* @throws
    　　* @author lgn
    　　* @date 2022/8/24 9:56
    　　*/
    List<LgsFile> findByList(List<Integer> list);
}
