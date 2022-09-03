package com.ruoyi.lab.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 需求单对象 lgs_demand
 * 
 * @author lgn
 * @date 2022-08-23
 */
public class LgsDemand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 站点id */
    @Excel(name = "站点id")
    private Long siteId;

    /** 部门id */
    @Excel(name = "部门id")
    private Long departmentId;

    /** 文件id */
    @Excel(name = "文件id")
    private String fileId;

    /** 优先级;0:低1：中2：高 */
    @Excel(name = "优先级;0:低1：中2：高")
    private int priority;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** 供应商联系方式;0:是1：否 */
    @Excel(name = "供应商联系方式;0:是1：否")
    private String supplierContact;

    /** 拥有者 */
    @Excel(name = "拥有者")
    private String owner;

    /** 期望完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "期望完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedCompletionTime;

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

    /** 需求标题 */
    @Excel(name = "需求标题")
    private String demandTitle;

    /** 需求描述 */
    @Excel(name = "需求描述")
    private String demandDescription;

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
    public void setSiteId(Long siteId) 
    {
        this.siteId = siteId;
    }

    public Long getSiteId() 
    {
        return siteId;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setFileId(String fileId)
    {
        this.fileId = fileId;
    }

    public String getFileId()
    {
        return fileId;
    }
    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public int getPriority()
    {
        return priority;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setSupplierContact(String supplierContact) 
    {
        this.supplierContact = supplierContact;
    }

    public String getSupplierContact() 
    {
        return supplierContact;
    }
    public void setOwner(String owner) 
    {
        this.owner = owner;
    }

    public String getOwner() 
    {
        return owner;
    }
    public void setExpectedCompletionTime(Date expectedCompletionTime) 
    {
        this.expectedCompletionTime = expectedCompletionTime;
    }

    public Date getExpectedCompletionTime() 
    {
        return expectedCompletionTime;
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
    public void setDemandTitle(String demandTitle) 
    {
        this.demandTitle = demandTitle;
    }

    public String getDemandTitle() 
    {
        return demandTitle;
    }
    public void setDemandDescription(String demandDescription) 
    {
        this.demandDescription = demandDescription;
    }

    public String getDemandDescription() 
    {
        return demandDescription;
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
            .append("siteId", getSiteId())
            .append("departmentId", getDepartmentId())
            .append("fileId", getFileId())
            .append("priority", getPriority())
            .append("supplier", getSupplier())
            .append("supplierContact", getSupplierContact())
            .append("owner", getOwner())
            .append("expectedCompletionTime", getExpectedCompletionTime())
            .append("isComplete", getIsComplete())
            .append("completedBy", getCompletedBy())
            .append("completionTime", getCompletionTime())
            .append("demandTitle", getDemandTitle())
            .append("demandDescription", getDemandDescription())
            .append("delFlag", getDelFlag())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
