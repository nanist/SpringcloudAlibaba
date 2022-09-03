package com.ruoyi.lab.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 分组管理通用子流程对象 lgs_group_subprocess
 * 
 * @author lgn
 * @date 2022-08-25
 */
public class LgsGroupSubprocess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 分组管理id */
    @Excel(name = "分组管理id")
    private Long groupManagementId;

    /** 流程环节 */
    @Excel(name = "流程环节")
    private String processLink;

    /** 子流程 */
    @Excel(name = "子流程")
    private String subprocess;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

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

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

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

    /**
     * id集合
     */
    private List<Long> ids;

    /** 需求id */
    private Integer demandId;

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupManagementId(Long groupManagementId) 
    {
        this.groupManagementId = groupManagementId;
    }

    public Long getGroupManagementId() 
    {
        return groupManagementId;
    }
    public void setProcessLink(String processLink) 
    {
        this.processLink = processLink;
    }

    public String getProcessLink() 
    {
        return processLink;
    }
    public void setSubprocess(String subprocess) 
    {
        this.subprocess = subprocess;
    }

    public String getSubprocess() 
    {
        return subprocess;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
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
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("groupManagementId", getGroupManagementId())
            .append("processLink", getProcessLink())
            .append("subprocess", getSubprocess())
            .append("sort", getSort())
            .append("isComplete", getIsComplete())
            .append("completedBy", getCompletedBy())
            .append("completionTime", getCompletionTime())
            .append("remarks", getRemarks())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
