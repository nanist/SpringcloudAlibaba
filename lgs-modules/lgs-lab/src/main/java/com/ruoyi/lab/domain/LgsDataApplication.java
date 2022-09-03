package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 数据备份/还原申请对象 lgs_data_application
 * 
 * @author lgn
 * @date 2022-08-30
 */
public class LgsDataApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求单id */
    @Excel(name = "需求单id")
    private Long demandId;

    /** 文件id集合 */
    @Excel(name = "文件id集合")
    private String fileIds;

    /** 数据类型;0：数据备份1：数据还原 */
    @Excel(name = "数据类型;0：数据备份1：数据还原")
    private Integer dataType;

    /** 删除状态;0：有效，1：无效 */
    @Excel(name = "删除状态;0：有效，1：无效")
    private Integer delFlag;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDemandId(Long demandId) 
    {
        this.demandId = demandId;
    }

    public Long getDemandId() 
    {
        return demandId;
    }
    public void setFileIds(String fileIds) 
    {
        this.fileIds = fileIds;
    }

    public String getFileIds() 
    {
        return fileIds;
    }
    public void setDataType(Integer dataType) 
    {
        this.dataType = dataType;
    }

    public Integer getDataType() 
    {
        return dataType;
    }
    public void setDelFlag(Integer delFlag) 
    {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() 
    {
        return delFlag;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("demandId", getDemandId())
            .append("fileIds", getFileIds())
            .append("dataType", getDataType())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
