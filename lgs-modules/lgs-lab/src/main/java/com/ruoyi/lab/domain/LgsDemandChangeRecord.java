package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 需求变更记录对象 lgs_demand_change_record
 * 
 * @author ruoyi
 * @date 2022-08-23
 */
public class LgsDemandChangeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求单id */
    @Excel(name = "需求单id")
    private Long lgsDemandId;

    /** 文件id */
    @Excel(name = "文件id")
    private String fileId;

    /** 系统名称 */
    @Excel(name = "系统名称")
    private String systemName;

    /** 仪器编号 */
    @Excel(name = "仪器编号")
    private String instrumentCode;

    /** 优先级;0:低1：中2：高 */
    @Excel(name = "优先级;0:低1：中2：高")
    private Integer priority;

    /** 期望完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "期望完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedCompletionTime;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String recordDescribe;

    /** 是否完成;0：未完成1：已完成 */
    @Excel(name = "是否完成;0：未完成1：已完成")
    private Integer isComplete;

    /** 完成人 */
    @Excel(name = "完成人")
    private String completedBy;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

    /** 删除状态 */
    @Excel(name = "删除状态")
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
    /**
     * 延期几天
     */
    private Integer DiffDate;
    /**
     * 延期状态 0未延期，1已延期
     */
    private Integer DiffState;

    public Integer getDiffState() {
        return DiffState;
    }

    public void setDiffState(Integer diffState) {
        DiffState = diffState;
    }

    public Integer getDiffDate() {
        return DiffDate;
    }

    public void setDiffDate(Integer diffDate) {
        DiffDate = diffDate;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLgsDemandId(Long lgsDemandId) 
    {
        this.lgsDemandId = lgsDemandId;
    }

    public Long getLgsDemandId() 
    {
        return lgsDemandId;
    }
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setSystemName(String systemName) 
    {
        this.systemName = systemName;
    }

    public String getSystemName() 
    {
        return systemName;
    }
    public void setInstrumentCode(String instrumentCode) 
    {
        this.instrumentCode = instrumentCode;
    }

    public String getInstrumentCode() 
    {
        return instrumentCode;
    }
    public void setPriority(Integer priority) 
    {
        this.priority = priority;
    }

    public Integer getPriority() 
    {
        return priority;
    }
    public void setExpectedCompletionTime(Date expectedCompletionTime) 
    {
        this.expectedCompletionTime = expectedCompletionTime;
    }

    public Date getExpectedCompletionTime() 
    {
        return expectedCompletionTime;
    }
    public void setRecordDescribe(String recordDescribe) 
    {
        this.recordDescribe = recordDescribe;
    }

    public String getRecordDescribe() 
    {
        return recordDescribe;
    }
    public void setIsComplete(Integer isComplete) 
    {
        this.isComplete = isComplete;
    }

    public Integer getIsComplete() 
    {
        return isComplete;
    }
    public void setCompletedBy(String completedBy) 
    {
        this.completedBy = completedBy;
    }

    public String getCompletedBy() 
    {
        return completedBy;
    }
    public void setCompletionTime(Date completionTime) 
    {
        this.completionTime = completionTime;
    }

    public Date getCompletionTime() 
    {
        return completionTime;
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
            .append("lgsDemandId", getLgsDemandId())
            .append("fileId", getFileId())
            .append("systemName", getSystemName())
            .append("instrumentCode", getInstrumentCode())
            .append("priority", getPriority())
            .append("expectedCompletionTime", getExpectedCompletionTime())
            .append("recordDescribe", getRecordDescribe())
            .append("isComplete", getIsComplete())
            .append("completedBy", getCompletedBy())
            .append("completionTime", getCompletionTime())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
