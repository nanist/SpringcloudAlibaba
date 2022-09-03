package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 需求单入组管理映射对象 lgs_group_mapping
 * 
 * @author lgn
 * @date 2022-08-29
 */
public class LgsGroupMapping extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 需求id */
    @Excel(name = "需求id")
    private Integer demandId;

    /** 入组管理id */
    @Excel(name = "入组管理id")
    private Integer groupManagementId;

    /** 流程环节id集合 */
    @Excel(name = "流程环节id集合")
    private String subprocessIds;

    /** 是否完成;是否完成0：否，1：是 */
    @Excel(name = "是否完成;是否完成0：否，1：是")
    private Integer isComplete;

    /** 完成人 */
    @Excel(name = "完成人")
    private String completedBy;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date completionTime;

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
    public void setDemandId(Integer demandId)
    {
        this.demandId = demandId;
    }

    public Integer getDemandId()
    {
        return demandId;
    }
    public void setGroupManagementId(Integer groupManagementId)
    {
        this.groupManagementId = groupManagementId;
    }

    public Integer getGroupManagementId()
    {
        return groupManagementId;
    }
    public void setSubprocessIds(String subprocessIds) 
    {
        this.subprocessIds = subprocessIds;
    }

    public String getSubprocessIds() 
    {
        return subprocessIds;
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
            .append("demandId", getDemandId())
            .append("groupManagementId", getGroupManagementId())
            .append("subprocessIds", getSubprocessIds())
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
